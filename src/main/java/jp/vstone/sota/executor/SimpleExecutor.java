/**
 * 
 */
package jp.vstone.sota.executor;

import jp.vstone.sota.common.SotaConfig;
import jp.vstone.sota.domain.service.SotaService;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sota.exception.SotaRuntimeException;

/**
 * @author nobutnk
 *
 */
public class SimpleExecutor extends AbstractExecutor {

    public SimpleExecutor(SotaConfig config, String[] args) {
        super(config, args);
    }

    /* (non-Javadoc)
     * @see jp.vstone.sota.bootstrap.AbstractShutdownHook#release()
     */
    @Override
    public void release() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see jp.vstone.sota.bootstrap.AbstractShutdownHook#doExecute()
     */
    @Override
    public void doExecute() throws SotaException{
        String serviceClass = config.getString("sota.service");
        SotaService sotaService = loadService(serviceClass);
        
        sotaService.execute();
    }
    
    @SuppressWarnings("unchecked")
    public SotaService loadService(String className) {
        SotaService service = null;
        try {
            Class<SotaService> clazz = (Class<SotaService>) Class.forName(className);
            service = clazz.newInstance();
            
            return service;
        } catch (ClassNotFoundException e) {
            throw new SotaRuntimeException(e);
        } catch (InstantiationException e) {
            throw new SotaRuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new SotaRuntimeException(e);
        }
    }

}
