/**
 * 
 */
package jp.vstone.sota.exception;

/**
 * @author nobutnk
 *
 */
public class SotaException extends Exception {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6096339405748115976L;

    public SotaException(String message, Throwable t) {
        super(message, t);
    }
    
    public SotaException(String message) {
        super(message);
    }
    
    public SotaException(Throwable t) {
        super(t);
    }
}
