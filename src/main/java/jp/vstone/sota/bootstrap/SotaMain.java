/**
 * 
 */
package jp.vstone.sota.bootstrap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.sota.exception.SotaRuntimeException;

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
        Properties config = loadConfig(configXml);
        String tag = config.getProperty(SOTA_LOG_PROP_KEY);
        
        try {
            AbstractExecutor main = new SimpleExecutor(config, args);
            main.execute();
        } catch (Exception e) {
            CRobotUtil.Log(tag, e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * プロパティファイル読み込み
     * @param path ファイルパス
     * @return Properties
     */
    public static Properties loadConfig(String path) {
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(path));
        } catch (InvalidPropertiesFormatException e) {
            throw new SotaRuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new SotaRuntimeException(e);
        } catch (IOException e) {
            throw new SotaRuntimeException(e);
        }
        
        return prop;
    }
    

}
