/**
 * 
 */
package jp.vstone.sota.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.sota.exception.SotaException;

/**
 * @author nobutnk
 *
 */
@Component
public class MockSotaSoundModule implements SotaSoundModule {
    
    private static final String TAG = MockSotaSoundModule.class.getName();
    
    private List<String> kanaWords = new ArrayList<String>();
    
    private List<String> words = new ArrayList<String>();
    
    private int kanaWordCount = 0;
    
    private int wordCount = 0;
    
    public CPlayWave playFromText(String text, boolean wait) {
        CRobotUtil.Log(TAG, "mock#playFromText -> " + text);
        return new CPlayWave();
    }
    
    public CPlayWave playFromFile(String filePath, boolean wait) {
        CRobotUtil.Log(TAG, "mock#playFromFile -> " + filePath);
        return new CPlayWave();
    }
    
    public CPlayWave playFromBinary(byte[] data, boolean wait) {
        CRobotUtil.Log(TAG, "mock#playFromBinary -> " + data);
        return new CPlayWave();
    }
    
    public byte[] createWaveDataFromText(String text) throws SotaException {
        CRobotUtil.Log(TAG, "mock#createWaveDataFromText -> " + text);
        if (Objects.nonNull(text)) {
            return text.getBytes();
        } else {
            return null;
        }
    }

    @Override
    public String getKanaWordWithHighScore(int timeout, int retry) throws SotaException {
        String result = null;
        if (kanaWords.size() == 0) {
            throw new SotaException("no mock kana words exists.");
        } else if (kanaWordCount < kanaWords.size()) {
            result = kanaWords.get(kanaWordCount);
        } else {
            kanaWordCount = 0;
            result = kanaWords.get(kanaWordCount);
        }
        return result;
    }

    @Override
    public String getWordWithHighScore(int timeout, int retry) throws SotaException {
        String result = null;
        if (words.size() == 0) {
            throw new SotaException("no mock words exists.");
        } else if (wordCount < words.size()) {
            result = words.get(wordCount);
        } else {
            wordCount = 0;
            result = words.get(wordCount);
        }
        return result;
    }
    
    public void addKanaWord(String kana) {
        this.kanaWords.add(kana);
    }
    
    public void addWord(String word) {
        this.words.add(word);
    }
}
