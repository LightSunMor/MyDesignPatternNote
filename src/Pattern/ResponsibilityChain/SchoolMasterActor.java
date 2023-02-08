package Pattern.ResponsibilityChain;

/**
 * @package_name: Pattern.ResponsibilityChain
 * @date: 2023/2/7
 * @week: 星期二
 * @message: 校长
 * @author: morSun
 */
public class SchoolMasterActor extends Handler{
    public SchoolMasterActor(String name) {
        super(name);
    }

    @Override
    public void processRequest(MoneyRequest request) {
        if (10000<=request.getPrice())
        {
            System.out.println(request.requestName+"被校长处理了");
        }else {
            // 交给下一个处理器
            nextHandler.processRequest(request);
        }
    }
}
