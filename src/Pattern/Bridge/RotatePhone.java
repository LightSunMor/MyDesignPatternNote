package Pattern.Bridge;

import Pattern.Bridge.Brand.Brand;

/**
 * @package_name: Pattern.Bridge
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 旋转手机
 * @author: morSun
 */
public class RotatePhone extends Phone{
    public RotatePhone(Brand brand) {
        super(brand);
    }

    @Override
    public String call() {
        String call = super.call();
        return "旋转 "+call;
    }

    @Override
    public String online() {
        return "旋转 "+super.online();
    }
}
