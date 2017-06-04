package jp.vstone.sota.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jp.vstone.sota.domain.service.AbstractBeanSotaService;
import jp.vstone.sota.domain.service.ServiceInput;
import jp.vstone.sota.domain.service.api.simpleapi.SimpleApiResult;
import jp.vstone.sota.domain.service.api.simpleapi.Station;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sota.module.SotaSoundModule;

@Service
public class TextToSpeechSampleService extends AbstractBeanSotaService {

    @Autowired
    protected SotaSoundModule soundModule;
    
    @Autowired
    private RestTemplate restTemplate;
    
    static final String TAG = "SpeechRecSample";

    @Override
    public void doService(ServiceInput serviceInput) throws SotaException {
        soundModule.playFromText("やっほー", true);
        soundModule.playFromText("僕の名前はSotaです。", true);
        byte[] data = soundModule.createWaveDataFromText("これから、よろしくね！");
        soundModule.playFromBinary(data, true);
        
        soundModule.playFromText(
                "僕の名前はSotaです",
                true);
        
    }
}
