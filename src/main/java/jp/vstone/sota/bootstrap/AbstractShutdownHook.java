/**
 * 
 */
package jp.vstone.sota.bootstrap;

import java.util.Properties;

/**
 * @author nobutnk
 *
 */
public abstract class AbstractShutdownHook implements ShutdownHook {
    
    private final String[] args;
    
    protected final Properties config;
    
    protected final String tag;
    
    public AbstractShutdownHook(Properties config, String[] args) {
        this.config = config;
        this.args = args;
        this.tag = config.getProperty("log.TAG");
    }

    /* (non-Javadoc)
     * @see com.blogspot.tanakanbb.process.ShutdownHook#execute()
     */
    public void execute() {
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
    public abstract void release();
    
    /**
     * メインループ
     */
    public abstract void doExecute();

    /**
     * @return the args
     */
    public String[] getArgs() {
        return args;
    }
}
