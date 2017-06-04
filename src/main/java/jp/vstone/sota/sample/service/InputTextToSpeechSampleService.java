package jp.vstone.sota.sample.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.vstone.sota.domain.service.AbstractBeanSotaService;
import jp.vstone.sota.domain.service.ServiceInput;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sota.module.SotaSoundModule;

@Service
public class InputTextToSpeechSampleService extends AbstractBeanSotaService {

    @Autowired
    protected SotaSoundModule soundModule;
    
    static final String TAG = InputTextToSpeechSampleService.class.getName();

    @Override
    public void doService(ServiceInput serviceInput) throws SotaException {
        soundModule.playFromText("やっほー", true);
        soundModule.playFromText("僕の名前はSotaです。", true);
        soundModule.playFromText("これからよろしくね！", true);

        Scanner scanner = new Scanner(System.in);
        for (int i = 0;;i++) {
            System.out.print("[" + i + "] Input > ");
            String input = scanner.next();
         
            System.out.println("[" + i + "] " + input);
            if (!"end".equals(input)) {
                soundModule.playFromText(input, true);
            } else {
                scanner.close();
                break;
            }
        }
        
        
    }
}
