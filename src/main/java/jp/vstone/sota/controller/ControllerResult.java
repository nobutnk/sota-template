/**
 * 
 */
package jp.vstone.sota.controller;

import jp.vstone.sota.domain.service.ServiceInput;

/**
 * @author nobutnk
 *
 */
public class ControllerResult {

    public enum Status {
        STOP,
        SERVICE,
        UNKNOWN,
        ERROR
    }
    
    private Status status;
    
    private String serviceBeanName;
    
    private ServiceInput serviceInput;

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the serviceBeanName
     */
    public String getServiceBeanName() {
        return serviceBeanName;
    }

    /**
     * @param serviceBeanName the serviceBeanName to set
     */
    public void setServiceBeanName(String serviceBeanName) {
        this.serviceBeanName = serviceBeanName;
    }

    /**
     * @return the serviceInput
     */
    public ServiceInput getServiceInput() {
        return serviceInput;
    }

    /**
     * @param serviceInput the serviceInput to set
     */
    public void setServiceInput(ServiceInput serviceInput) {
        this.serviceInput = serviceInput;
    }
}
