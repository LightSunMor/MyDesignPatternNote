package Pattern.ResponsibilityChain;

/**
 * @package_name: Pattern.ResponsibilityChain
 * @date: 2023/2/7
 * @week: 星期二
 * @message: 主任
 * @author: morSun
 */
public class DepartmentActor extends Handler{


    public DepartmentActor(String name) {
        super(name);
    }

    @Override
    public void processRequest(MoneyRequest request) {
        if (0<=request.getPrice()&&request.getPrice()<1000)
        {
            System.out.println(request.requestName+"被主任处理了");
        }else {
            // 交给下一个处理器
            nextHandler.processRequest(request);
        }
    }
}
