/**
 * 
 */
package jp.vstone.sota.test.RobotLib.mock;

import java.util.HashMap;

import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotPose;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.RobotLib.CSotaMotion;

/**
 * @author nobutnk
 *
 */
public class MockCSotaMotion extends CSotaMotion {

    private static final String TAG = MockCSotaMotion.class.getName();
    
    private int batteryVoltage = 100;
    
    private int chargerAdapterVoltage = 100;
    
    private Byte[] defaultIDs = null;
    
    private Short[] readpos = null;
    
    private CRobotPose readPose = new CRobotPose();
    
    private HashMap<Byte, Short> speechRecogLEDColor = new HashMap<Byte, Short>();
    
    public MockCSotaMotion(CRobotMem mem) {
        super(mem);
    }
    
    @Override
    public void disabeMouthLEDVoiceSync() {
        CRobotUtil.Log(TAG, "disabeMouthLEDVoiceSync is called.");
    }
    
    @Override
    public void DisableCollidionDetect() {
        CRobotUtil.Log(TAG, "DisableCollidionDetect is called.");
    }

    @Override
    public void enabeMouthLEDVoiceSync() {
        CRobotUtil.Log(TAG, "enabeMouthLEDVoiceSync is called.");
    }
    
    @Override
    public void EnableCollidionDetect() {
        CRobotUtil.Log(TAG, "EnableCollidionDetect is called.");
    }
    
    @Override
    public int getBatteryVoltage() {
        return this.batteryVoltage;
    }
    
    @Override
    public int getChargerAdapterVoltage() {
        return this.chargerAdapterVoltage;
    }
    
    @Override
    public Byte[] getDefaultIDs() {
        return this.defaultIDs;
    }
    
    @Override
    public Short[] getReadpos() {
        return this.readpos;
    }
    
    @Override
    public CRobotPose getReadPose() {
        return this.readPose;
    }
    
    @Override
    public HashMap<Byte, Short> getSpeechRecogLEDColor() {
        return this.speechRecogLEDColor;
    }

    
    // -------------- for mock function
    /**
     * @param batteryVoltage the batteryVoltage to set
     */
    public void setBatteryVoltage(int batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    /**
     * @param chargerAdapterVoltage the chargerAdapterVoltage to set
     */
    public void setChargerAdapterVoltage(int chargerAdapterVoltage) {
        this.chargerAdapterVoltage = chargerAdapterVoltage;
    }

    /**
     * @param defaultIDs the defaultIDs to set
     */
    public void setDefaultIDs(Byte[] defaultIDs) {
        this.defaultIDs = defaultIDs;
    }

    /**
     * @param readpos the readpos to set
     */
    public void setReadpos(Short[] readpos) {
        this.readpos = readpos;
    }

    /**
     * @param readPose the readPose to set
     */
    public void setReadPose(CRobotPose readPose) {
        this.readPose = readPose;
    }

    /**
     * @param speechRecogLEDColor the speechRecogLEDColor to set
     */
    public void setSpeechRecogLEDColor(HashMap<Byte, Short> speechRecogLEDColor) {
        this.speechRecogLEDColor = speechRecogLEDColor;
    }
}
