package Pattern.Visitor;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/30
 * @week: 星期一
 * @message: 硬件CPU
 * @author: morSun
 */
public class CPU extends HardWare{

    /**②重写 双分派之动态分派 --- 同Disk*/
    @Override
    public void accept(Kit kit) {
        System.out.println("cpu accept");
        //调用升级包的访问方法
        kit.visit(this);
    }
}
