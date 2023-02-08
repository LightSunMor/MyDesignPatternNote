package Pattern.ResponsibilityChain;

/**
 * @package_name: Pattern.ResponsibilityChain
 * @date: 2023/2/6
 * @week: 星期一
 * @message: 抽象处理者
 * @author: morSun
 */
public  abstract class Handler {
    String name;
    Handler nextHandler;

    public Handler(String name) {
        this.name = name;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //处理请求
    public abstract void processRequest(MoneyRequest request);
}
