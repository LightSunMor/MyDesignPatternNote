package Pattern.Bridge;

import Pattern.Bridge.Brand.Brand;

/**
 * @package_name: Pattern.Bridge
 * @date: 2023/1/21
 * @week: 星期六
 * @message: 桥接类 （可以是抽象类）
 * @author: morSun
 */
public abstract class Phone {
    protected Brand brand;
    public Phone(Brand brand)
    {
        this.brand=brand;
    }

    //手机对应的功能
    public String call()
    {
        String call = this.brand.call();
        System.out.println(call+"手机 打电话");
        return call+"手机 打电话";
    }
    public String online()
    {
        String online = this.brand.online();
        System.out.println(online+"手机 上网");
        return online +"手机 上网";
    }
}
