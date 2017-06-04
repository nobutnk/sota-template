/**
 * 
 */
package jp.vstone.sota.module;

import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sotatalk.TextToSpeechSota;

/**
 * @author nobutnk
 *
 */
public class BasicSotaSoundModule implements SotaSoundModule {
    
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
}