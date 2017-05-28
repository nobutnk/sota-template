/**
 * 
 */
package jp.vstone.sota.bootstrap;

import java.util.Properties;

/**
 * @author nobutnk
 *
 */
public class SimpleShutdownHook extends AbstractShutdownHook {

    public SimpleShutdownHook(Properties config, String[] args) {
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
    public void doExecute() {
        // TODO Auto-generated method stub

    }

}
