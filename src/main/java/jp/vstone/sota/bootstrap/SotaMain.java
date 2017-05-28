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

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        
        String configXml = args[0];
        SotaConfig config = SotaConfig.loadConfig(configXml);
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
