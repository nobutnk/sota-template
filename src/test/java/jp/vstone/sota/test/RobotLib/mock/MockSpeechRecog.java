/**
 * 
 */
package jp.vstone.sota.test.RobotLib.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import jp.vstone.RobotLib.CRobotMotion;
import jp.vstone.sotatalk.SpeechRecog;

/**
 * @author nobutnk
 *
 */
public class MockSpeechRecog extends SpeechRecog {

    private CRobotMotion motion;
    
    private List<String> abortWord = new ArrayList<String>();
    
    public MockSpeechRecog(CRobotMotion motion) {
        super(motion);
        this.motion = motion;
    }
    
    @Override
    public void addAbortWord(String word) {
        this.abortWord.add(word);
    }
    
    @Override
    public void clearAbortWords() {
        this.abortWord.clear();
    }
    
    @Override
    public void addAbortWords(String[] arg0) {
        if (Objects.nonNull(arg0)) {
            this.abortWord.addAll(Arrays.asList(arg0));
        }
    }
    
    @Override
    public RecogResult getAbortResult() {
        RecogResult result = new RecogResult();
        return result;
    }
    
    @Override
    public Calendar getDate(RecogResult arg0) {
       Calendar calendar = Calendar.getInstance();
       return calendar;
    }
    
    @Override
    public int getDay(RecogResult arg0) {
        return 1;
    }

}
