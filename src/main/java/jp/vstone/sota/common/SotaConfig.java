/**
 * 
 */
package jp.vstone.sota.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import jp.vstone.sota.exception.SotaRuntimeException;

/**
 * @author nobutnk
 *
 */
public class SotaConfig {

    private final Properties properties;
    
    public SotaConfig(Properties properties) {
        this.properties = properties;
    }
    
    public String getString(String key) {
        return properties.getProperty(key);
    }
    
    public int getInt(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
    
    /**
     * プロパティファイル読み込み
     * @param path ファイルパス
     * @return Properties
     */
    public static SotaConfig loadConfig(String path) {
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
        
        return new SotaConfig(prop);
    }
}
