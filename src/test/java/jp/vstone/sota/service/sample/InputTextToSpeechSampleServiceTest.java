package jp.vstone.sota.service.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jp.vstone.sota.exception.SotaException;
import jp.vstone.sota.sample.service.InputTextToSpeechSampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/META-INF/spring/applicationContext.xml" })
public class InputTextToSpeechSampleServiceTest {

    static final String TAG = InputTextToSpeechSampleServiceTest.class.getName();
    
    @Autowired
    protected InputTextToSpeechSampleService service;

    @Test
    public void expectSuccessDoService() throws SotaException {
        service.doService();
    }
}
