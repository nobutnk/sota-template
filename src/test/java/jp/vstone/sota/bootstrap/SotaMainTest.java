/**
 * 
 */
package jp.vstone.sota.bootstrap;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import jp.vstone.sota.common.SotaConfig;
import jp.vstone.sota.executor.Executor;

/**
 * @author nobutnk
 *
 */
public class SotaMainTest {
    
    @Test
    public void expectSuccessGetExecutor() {
        
        String configXmlPath = "src/test/resources/sota-test-config-SotaMain.xml";
        SotaConfig sotaConfig = SotaConfig.loadConfig(configXmlPath);
        Executor executor = SotaMain.getExecutor(sotaConfig, new String[]{});
        
        Assert.assertThat(executor, is(notNullValue()));
        
    }

}
