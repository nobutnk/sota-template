/**
 * 
 */
package jp.vstone.sota.domain.service;

import jp.vstone.sota.exception.SotaException;

/**
 * @author nobutnk
 *
 */
public interface SotaService {

    void execute(ServiceInput serviceInput) throws SotaException;
}
