/**
 * 
 */
package jp.vstone.sota.common;

import java.util.ResourceBundle;

/**
 * @author nobutnk
 *
 */
public class SotaMessage {
    
    protected ResourceBundle messageResource;

    public SotaMessage(SotaConfig config) {
        String baseName = config.getString("sota.messageResource");
        messageResource = ResourceBundle.getBundle(baseName);
    }
    
    public String getMessage(String key) {
        return messageResource.getString(key);
    }
}
