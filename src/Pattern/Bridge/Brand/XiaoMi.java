package Pattern.Bridge.Brand;

/**
 * @package_name: Pattern.Bridge.Brand
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 小米品牌
 * @author: morSun
 */
public class XiaoMi implements Brand{

    @Override
    public String call() {
        System.out.println("小米 打电话");
        return "小米";
    }

    @Override
    public String online() {
        System.out.println("小米 上网");
        return "小米";
    }
}
