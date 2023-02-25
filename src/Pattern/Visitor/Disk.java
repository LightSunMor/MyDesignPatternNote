package Pattern.Visitor;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/30
 * @week: 星期一
 * @message: 硬件磁盘
 * @author: morSun
 */
public class Disk extends HardWare{
    /**②重写 双分派之动态分派 --- 同CPU*/
    @Override
    protected void accept(Kit kit) {
        kit.visit(this);// 工具包接收硬件做升级操作,直接将硬件传入
    }
}
