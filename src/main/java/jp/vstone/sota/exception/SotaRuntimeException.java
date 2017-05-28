/**
 * 
 */
package jp.vstone.sota.exception;

/**
 * @author nobutnk
 *
 */
public class SotaRuntimeException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3926191586595318637L;
    
    public SotaRuntimeException(String message, Throwable t) {
        super(message, t);
    }
    
    public SotaRuntimeException(Throwable t) {
        super(t);
    }

}
