package Pattern.ResponsibilityChain;

/**
 * @package_name: Pattern.ResponsibilityChain
 * @date: 2023/2/7
 * @week: 星期二
 * @message: 院长
 * @author: morSun
 */
public class ColleageActor extends Handler{

    public ColleageActor(String name) {
        super(name);
    }

    @Override
    public void processRequest(MoneyRequest request) {
        if (1000<=request.getPrice()&&request.getPrice()<10000)
        {
            System.out.println(request.requestName+"被院长处理了");
        }else {
            // 交给下一个处理器
            nextHandler.processRequest(request);
        }
    }
}
