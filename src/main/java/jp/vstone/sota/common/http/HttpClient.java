/**
 * 
 */
package jp.vstone.sota.common.http;

import java.util.Map;

import jp.vstone.sota.exception.SotaException;

/**
 * @author nobutnk
 *
 */
public interface HttpClient {

    String get(String uri) throws SotaException;
    
    String get(Map<String, String> headers, String uri) throws SotaException;
    
    String post(String uri, Map<String, String> params, String charsetName) throws SotaException;
    
    String post(Map<String, String> headers, String uri, Map<String, String> params, String charsetName) throws SotaException;
}
