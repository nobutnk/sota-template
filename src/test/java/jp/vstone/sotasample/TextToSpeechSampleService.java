package jp.vstone.sotasample;

import jp.vstone.RobotLib.CRobotMem;
import jp.vstone.RobotLib.CSotaMotion;
import jp.vstone.sota.controller.BasicSotaSoundController;
import jp.vstone.sota.domain.service.AbstractSotaService;
import jp.vstone.sota.exception.SotaException;
import jp.vstone.sotatalk.SpeechRecog;

public class TextToSpeechSampleService extends AbstractSotaService {
    public TextToSpeechSampleService(CRobotMem mem, CSotaMotion motion, SpeechRecog recog) {
        super(mem, motion, recog);
    }

    static final String TAG = "SpeechRecSample";

    @Override
    public void doService() throws SotaException {
        BasicSotaSoundController soundController = new BasicSotaSoundController();
        soundController.playFromFile("やっほー", true);
        soundController.playFromFile("僕の名前はSotaです。", true);
        byte[] data = soundController.createWaveDataFromText("これから、よろしくね！");
        soundController.playFromBinary(data, true);

        soundController.playFromText(
                "僕の名前はSotaです。僕の名前はSotaです。僕の名前はSotaです。"
                + "僕の名前はSotaです。僕の名前はSotaです。僕の名前はSotaです。"
                + "僕の名前はSotaです。僕の名前はSotaです。",
                true);
    }
}
