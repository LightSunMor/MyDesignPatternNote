package Pattern.Visitor;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/30
 * @week: 星期一
 * @message: 机器人
 * @author: morSun
 */
public class Root {
    //组装硬件
    private HardWare cpu;
    private HardWare disk;
    //初始化
    Root()
    {
        cpu=new CPU();
        cpu.setCommand("1=1");
        disk=new Disk();
        disk.setCommand("记住 1=1");
    }
    //功能使用
    public void action()
    {
        cpu.run();
        disk.run();
    }

    //接收升级包
    public void accept(Kit kit)
    {
        // 根据实际类型动态分派
        cpu.accept(kit);
        disk.accept(kit);
    }
}
