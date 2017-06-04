/**
 * 
 */
package jp.vstone.sota.bootstrap;

import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.sota.common.ClassUtils;
import jp.vstone.sota.common.SotaConfig;
import jp.vstone.sota.executor.Executor;

/**
 * @author nobutnk
 *
 */
public class SotaMain {
    /**
     * ログに使うTAG
     */
    private static final String TAG = SotaMain.class.getName();
    
    public static String configXmlPath;

    /**
     * @param args
     */
    public static void main(String[] args) {
        configXmlPath = args[0];
        SotaConfig config = SotaConfig.loadConfig(configXmlPath);
        
        try {
            Executor main = getExecutor(config, args);
            main.execute();
        } catch (Exception e) {
            CRobotUtil.Log(TAG, e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static Executor getExecutor(SotaConfig sotaConfig, String[] args) {
        Class<Executor> clazz = ClassUtils.getClassForName(sotaConfig.getString("executor"));
        Executor executor = ClassUtils.getInstance(
                clazz,
                new Class[]{SotaConfig.class,  String[].class},
                new Object[]{sotaConfig, args});
        
        return executor;
    }

}
