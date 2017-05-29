/**
 * 
 */
package jp.vstone.sota.bootstrap;

import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.sota.common.SotaConfig;
import jp.vstone.sota.executor.Executor;
import jp.vstone.sota.executor.SimpleExecutor;

/**
 * @author nobutnk
 *
 */
public class SotaMain {
    /**
     * ログに使うTAGのプロパティキー名
     */
    private static final String SOTA_LOG_PROP_KEY = "log.TAG";
    
    public static String configXmlPath;

    /**
     * @param args
     */
    public static void main(String[] args) {
        configXmlPath = args[0];
        SotaConfig config = SotaConfig.loadConfig(configXmlPath);
        String tag = config.getString(SOTA_LOG_PROP_KEY);
        
        try {
            Executor main = new SimpleExecutor(config, args);
            main.execute();
        } catch (Exception e) {
            CRobotUtil.Log(tag, e.getMessage());
            e.printStackTrace();
        }
    }

}
