package jp.vstone.sota.service.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jp.vstone.sota.domain.service.ServiceInput;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sota.sample.service.ApiSampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/META-INF/spring/applicationContext.xml" })
public class ApiSampleServiceTest {

    static final String TAG = ApiSampleServiceTest.class.getName();
    
    @Autowired
    protected ApiSampleService service;

    @Test
    public void expectSuccessDoService() throws SotaException {
        ServiceInput serviceInput = new ServiceInput();
        service.doService(serviceInput);
    }
}
