/**
 * 
 */
package jp.vstone.sota.test.RobotLib.mock;

import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotUtil;

/**
 * @author nobutnk
 *
 */
public class MockCRobotMem extends CRobotMem {

    private boolean isConnect = true;
    
    private String TAG = MockCRobotMem.class.getName();
    
    @Override
    public boolean Connect() {
        return this.isConnect;
    }
    
    @Override
    public void Disconnect() {
        CRobotUtil.Log(TAG, "disconnect");
    }
    
    
}
