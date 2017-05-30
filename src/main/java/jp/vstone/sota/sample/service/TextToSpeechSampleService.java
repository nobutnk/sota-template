package jp.vstone.sota.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.vstone.sota.controller.SotaSoundController;
import jp.vstone.sota.domain.service.AbstractBeanSotaService;
import jp.vstone.sota.exception.SotaException;

@Service
public class TextToSpeechSampleService extends AbstractBeanSotaService {

    @Autowired
    protected SotaSoundController soundController;
    
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
    }
}
