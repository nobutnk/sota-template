/**
 * 
 */
package jp.vstone.sota.controller;

import java.util.Objects;

import org.springframework.stereotype.Component;

import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sota.module.SotaSoundController;

/**
 * @author nobutnk
 *
 */
@Component
public class MockSotaSoundController implements SotaSoundController {
    
    private static final String TAG = MockSotaSoundController.class.getName();
    
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
}
