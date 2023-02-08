package Pattern.Bridge;

import Pattern.Bridge.Brand.Brand;

/**
 * @package_name: Pattern.Bridge
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 曲面手机 （新增加的）
 * @author: morSun
 */

public class CurvePhone extends Phone{
    public CurvePhone(Brand brand) {
        super(brand);
    }

    @Override
    public String call() {
        return "曲面 "+super.call();
    }

    @Override
    public String online() {
        return "曲面 " +super.online();
    }
}
