/**
 * 
 */
package jp.vstone.sota.module;

import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sotatalk.SpeechRecog;
import jp.vstone.sotatalk.SpeechRecog.RecogResult;
import jp.vstone.sotatalk.TextToSpeechSota;

/**
 * @author nobutnk
 *
 */
public class BasicSotaSoundModule implements SotaSoundModule {
    
    @Autowired
    protected SpeechRecog recog;
    
    public CPlayWave playFromText(String text, boolean wait) {
        return CPlayWave.PlayWave(TextToSpeechSota.getTTSFile(text), wait);
    }
    
    public CPlayWave playFromFile(String filePath, boolean wait) {
        return CPlayWave.PlayWave(filePath, wait);
    }
    
    public CPlayWave playFromBinary(byte[] data, boolean wait) {
        return CPlayWave.PlayWave(data, wait);
    }
    
    public byte[] createWaveDataFromText(String text) throws SotaException {
        byte[] data = TextToSpeechSota.getTTS(text);
        if (data == null) {
            throw new SotaException("");
        } else {
            return data;
        }
    }
    
    public String getKanaWordWithHighScore(int timeout, int retry) throws SotaException {
        String result = null;
        for (int i = 0; i < retry; i++) {
            RecogResult recogResult = recog.getRecognition(timeout);
            if (recogResult != null) {
                HashMap<String, Double> resultKanaWithScore = recogResult.getResultKanaWithScore();
                Double highScore = Double.valueOf(0.0);
                
                for (Entry<String, Double> entry : resultKanaWithScore.entrySet()) {
                    String kana = entry.getKey();
                    Double score = entry.getValue();
                    if (highScore.compareTo(score) <= 0) {
                        result = kana;
                        if (kana.indexOf(",") != -1) {
                            result = kana.split(",")[0];
                        }
                    }
                }
                
                break;
            }
        }
        
        if (result == null) {
            throw new SotaException("cannot receive ant word from user.");
        }
        return result;
    }
    
    public String getWordWithHighScore(int timeout, int retry) throws SotaException {
        String result = null;
        for (int i = 0; i < retry; i++) {
            RecogResult recogResult = recog.getRecognition(timeout);
            if (recogResult != null) {
                HashMap<String, Double> resultWithScore = recogResult.getResultWithScore();
                Double highScore = Double.valueOf(0.0);
                
                for (Entry<String, Double> entry : resultWithScore.entrySet()) {
                    String word = entry.getKey();
                    Double score = entry.getValue();
                    if (highScore.compareTo(score) <= 0) {
                        result = word;
                        if (word.indexOf(",") != -1) {
                            result = word.split(",")[0];
                        }
                    }
                }
                
                break;
            }
        }
        
        if (result == null) {
            throw new SotaException("cannot receive ant word from user.");
        }
        return result;
    }
}
