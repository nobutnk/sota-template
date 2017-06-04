/**
 * 
 */
package jp.vstone.sota.executor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import jp.vstone.sota.common.SotaConfig;
import jp.vstone.sota.domain.service.SotaService;
import jp.vstone.sota.exception.SotaException;

/**
 * @author nobutnk
 *
 */
public class BeanExecutor extends AbstractExecutor {
    
    private final ClassPathXmlApplicationContext context;
    
    public BeanExecutor(SotaConfig config, String[] args) {
        super(config, args);
        String configLocation = config.getString("context.location");
        context = new ClassPathXmlApplicationContext(configLocation);
        context.registerShutdownHook();
    }

    @Override
    public void release() {
        context.close();
    }

    @Override
    public void doExecute() throws SotaException {
        
        SotaService service = context.getBean(config.getString("serviceBeanName"), SotaService.class);
        
        service.execute(null);
    }

}
