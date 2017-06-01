package jp.vstone.sota.sample.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.vstone.sota.controller.SotaSoundController;
import jp.vstone.sota.domain.service.AbstractBeanSotaService;
import jp.vstone.sota.exception.SotaException;

@Service
public class InputTextToSpeechSampleService extends AbstractBeanSotaService {

    @Autowired
    protected SotaSoundController soundController;
    
    static final String TAG = InputTextToSpeechSampleService.class.getName();

    @Override
    public void doService() throws SotaException {
        soundController.playFromText("やっほー", true);
        soundController.playFromText("僕の名前はSotaです。", true);
        soundController.playFromText("これからよろしくね！", true);

        for (int i = 0;;i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[" + i + "] Input > ");
         
            String input = scanner.nextLine();
         
            System.out.println("[" + i + "] " + input);
            if (!"end".equals(input)) {
                soundController.playFromText(input, true);
                scanner.close();
            } else {
                scanner.close();
                break;
            }
        }
        
        
    }
}
