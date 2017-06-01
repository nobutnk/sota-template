package jp.vstone.sotasample;

import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CRobotUtil;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sota.controller.MockSotaSoundController;
import jp.vstone.sota.domain.service.AbstractSotaService;
import jp.vstone.sotatalk.SpeechRecog;

public class SpeechRecGetNameService extends AbstractSotaService {
    public SpeechRecGetNameService(CRobotMem mem, CSotaMotion motion, SpeechRecog recog) {
        super(mem, motion, recog);
    }

    static final String TAG = "SpeechRecSample";

    public void doService() {
        MockSotaSoundController soundController= new MockSotaSoundController();
        soundController.playFromText("お名前はなんですか？", true);

        String name = recog.getName(15000, 3);
        if (name != null) {
            CRobotUtil.Log(TAG, name);
            soundController.playFromText(name + "さん！。覚えたよ！", true);
        }
    }
}
