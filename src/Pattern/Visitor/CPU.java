package Pattern.Visitor;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/30
 * @week: 星期一
 * @message: 硬件CPU
 * @author: morSun
 */
public class CPU extends HardWare{

    @Override
    public void accept(Kit kit) {
        //调用升级包的访问方法
        kit.visitCPU(this);
    }
}
