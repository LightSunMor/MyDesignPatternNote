package Pattern.ResponsibilityChain;

/**
 * @package_name: Pattern.ResponsibilityChain
 * @date: 2023/2/7
 * @week: 星期二
 * @message: 申请经费
 * @author: morSun
 */
public class MoneyRequest {
    int price;
    String requestName;

    public MoneyRequest(String requestName) {
        this.requestName = requestName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
