package typeinfo;
import static net.mindview.util.Print.*;

public class SmsProxy implements SmsService{
    private final SmsService smsService;
    public SmsProxy(SmsService smsService){
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //增加操作
        print("before method send()");
        smsService.send(message);
        //添加操作
        print("after method send() ");
        return null;

    }
}
