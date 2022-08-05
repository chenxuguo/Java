package typeinfo;

public class Main {
    public static void main(String[] args){
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
        // proxy and proxied
        SmsService proxy = (SmsService)JdkProxyFactory.getProxy(smsService);
        proxy.send("python");
    }
}
