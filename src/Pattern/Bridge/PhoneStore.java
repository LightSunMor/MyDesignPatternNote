package Pattern.Bridge;

import Pattern.Bridge.Brand.HuaWei;
import Pattern.Bridge.Brand.XiaoMi;

/**
 * @package_name: Pattern.Bridge
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 手机店
 * @author: morSun
 */
public class PhoneStore {
    public static void main(String[] args) {
        RotatePhone rotatePhone = new RotatePhone(new XiaoMi());
        System.out.println(rotatePhone.call());
        System.out.println("***");
        System.out.println(rotatePhone.online());
        System.out.println("-------------");
         //新增一种类型的手机，只用继承Phone就行了，不用新增加其他的什么
        CurvePhone curvePhone = new CurvePhone(new HuaWei());
        System.out.println(curvePhone.call());
        System.out.println("***");
        System.out.println(curvePhone.online());
    }
}
