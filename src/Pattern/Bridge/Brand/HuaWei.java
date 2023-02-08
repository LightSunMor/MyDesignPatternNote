package Pattern.Bridge.Brand;

/**
 * @package_name: Pattern.Bridge.Brand
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 华为品牌
 * @author: morSun
 */
public class HuaWei implements Brand{

    @Override
    public String call() {
        System.out.println("华为 打电话");
        return "华为";
    }

    @Override
    public String online() {
        System.out.println("华为 上网");
        return "华为";
    }
}
