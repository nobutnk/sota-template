package jp.vstone.sota.sample.service;

import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.sota.domain.service.AbstractBeanSotaService;
import jp.vstone.sota.domain.service.ServiceInput;
import jp.vstone.sota.module.MockSotaSoundModule;

public class SpeechRecGetNameService extends AbstractBeanSotaService {

    static final String TAG = SpeechRecGetNameService.class.getName();

    public void doService(ServiceInput serviceInput) {
        MockSotaSoundModule soundController= new MockSotaSoundModule();
        soundController.playFromText("お名前はなんですか？", true);

        String name = recog.getName(15000, 3);
        if (name != null) {
            CRobotUtil.Log(TAG, name);
            soundController.playFromText(name + "さん！。覚えたよ！", true);
        }
    }
}
