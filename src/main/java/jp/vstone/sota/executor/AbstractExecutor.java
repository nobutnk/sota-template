/**
 * 
 */
package jp.vstone.sota.executor;

import jp.vstone.sota.common.SotaConfig;
import jp.vstone.sota.exception.SotaException;

/**
 * @author nobutnk
 *
 */
public abstract class AbstractExecutor implements Executor {
    
    private final String[] args;
    
    protected final SotaConfig config;
    
    public AbstractExecutor(SotaConfig config, String[] args) {
        this.config = config;
        this.args = args;
    }

    /* (non-Javadoc)
     * @see com.blogspot.tanakanbb.process.ShutdownHook#execute()
     */
    public void execute() throws SotaException {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                release();
            }
        });
        doExecute();
    }

    /**
     * 停止時の処理
     */
    public abstract void release() ;
    
    /**
     * メインループ
     */
    public abstract void doExecute() throws SotaException;

    /**
     * @return the args
     */
    public String[] getArgs() {
        return args;
    }
}
