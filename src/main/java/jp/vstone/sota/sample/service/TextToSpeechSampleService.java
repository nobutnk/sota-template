package jp.vstone.sota.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jp.vstone.sota.controller.SotaSoundController;
import jp.vstone.sota.domain.service.AbstractBeanSotaService;
import jp.vstone.sota.domain.service.api.simpleapi.SimpleApiResult;
import jp.vstone.sota.domain.service.api.simpleapi.Station;
import jp.vstone.sota.exception.SotaException;

@Service
public class TextToSpeechSampleService extends AbstractBeanSotaService {

    @Autowired
    protected SotaSoundController soundController;
    
    @Autowired
    private RestTemplate restTemplate;
    
    static final String TAG = "SpeechRecSample";

    @Override
    public void doService() throws SotaException {
        soundController.playFromText("やっほー", true);
        soundController.playFromText("僕の名前はSotaです。", true);
        byte[] data = soundController.createWaveDataFromText("これから、よろしくね！");
        soundController.playFromBinary(data, true);
        
        soundController.playFromText(
                "僕の名前はSotaです",
                true);
        
        soundController.playFromText("最寄駅を探すね", true);
        
        String url = "http://map.simpleapi.net/stationapi?x=139.8025&y=35.6657";
        SimpleApiResult result = restTemplate.getForObject(url, SimpleApiResult.class);
        
        for (Station s : result.getStations()) {
            System.out.println(s.getName());
            soundController.playFromText(s.getName(), true);
        }
        
    }
}
