package Pattern.ResponsibilityChain;

import java.util.Stack;

/**
 * @package_name: Pattern.ResponsibilityChain
 * @date: 2023/2/7
 * @week: 星期二
 * @message:
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        CommonUtils utils = new CommonUtils();
        MoneyRequest request = new MoneyRequest("经费申请请求");
        request.setPrice(100);

        utils.processRequest(request);

    }
}
