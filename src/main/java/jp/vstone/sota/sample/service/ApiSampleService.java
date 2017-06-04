package jp.vstone.sota.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jp.vstone.sota.domain.service.AbstractBeanSotaService;
import jp.vstone.sota.domain.service.ServiceInput;
import jp.vstone.sota.domain.service.api.geocoding.GeocodingApiResult;
import jp.vstone.sota.domain.service.api.simpleapi.SimpleApiResult;
import jp.vstone.sota.domain.service.api.simpleapi.Station;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sota.module.SotaSoundModule;

@Service
public class ApiSampleService extends AbstractBeanSotaService {

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
        
        soundModule.playFromText("最寄駅を探すね", true);
        soundModule.playFromText("どこに行きたいですか？", true);
        
        String answer = "豊洲";
        
        String geoUrl = "http://www.geocoding.jp/api/?v=1.1&q=" + answer;
        GeocodingApiResult geoResult = restTemplate.getForObject(geoUrl, GeocodingApiResult.class);
        String y = geoResult.getCoordinate().getLat();
        String x = geoResult.getCoordinate().getLng();
        
        String url = "http://map.simpleapi.net/stationapi?x=" + x + "&y=" + y;
        
        System.out.println(url);
        
        SimpleApiResult result = restTemplate.getForObject(url, SimpleApiResult.class);
        
        for (Station s : result.getStations()) {
            System.out.println(s.getName());
            soundModule.playFromText(s.getName(), true);
        }
        
    }
}
