package Pattern.Visitor;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/30
 * @week: 星期一
 * @message: 硬件磁盘
 * @author: morSun
 */
public class Disk extends HardWare{

    @Override
    protected void accept(Kit kit) {
        kit.visitDisk(this);
    }
}
