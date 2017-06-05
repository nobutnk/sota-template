/**
 * 
 */
package jp.vstone.sota.module;

import jp.vstone.RobotLib.CPlayWave;
import jp.vstone.sota.exception.SotaException;

/**
 * @author nobutnk
 *
 */
public interface SotaSoundModule {

    CPlayWave playFromText(String text, boolean wait);
    
    CPlayWave playFromFile(String filePath, boolean wait);
    
    CPlayWave playFromBinary(byte[] data, boolean wait);
    
    byte[] createWaveDataFromText(String text) throws SotaException;
    
    String getKanaWordWithHighScore(int timeout, int retry) throws SotaException;
    
    String getWordWithHighScore(int timeout, int retry) throws SotaException;
}
