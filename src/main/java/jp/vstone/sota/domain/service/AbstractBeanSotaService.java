/**
 * 
 */
package jp.vstone.sota.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sota.common.SotaConfig;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sotatalk.SpeechRecog;

/**
 * @author nobutnk
 *
 */
public abstract class AbstractBeanSotaService implements SotaService {
    
    @Autowired
    protected CRobotMem mem;
    //Sota用モーション制御クラス
    @Autowired
    protected CSotaMotion motion;
    
    @Autowired
    protected SpeechRecog recog;
    
    @Autowired
    protected SotaConfig sotaConfig;
    
    
    /**
     * 
     */
    public AbstractBeanSotaService() {
    }
    
    /**
     * 
     * @param mem CRobotMem
     * @param motion CSotaMotion
     * @param recog SpeechRecog
     */
    public AbstractBeanSotaService(CRobotMem mem, CSotaMotion motion, SpeechRecog recog) {
        this.mem = mem;
        this.motion = motion;
        this.recog = recog;
    }

    /* (non-Javadoc)
     * @see jp.vstone.sota.domain.service.SotaService#doService()
     */
    public void execute() throws SotaException{
        if(mem.Connect()){
            //Sota仕様にVSMDを初期化
            motion.InitRobot_Sota();
            
            doService();
        }
    }
    
    public abstract void doService() throws SotaException;

}
