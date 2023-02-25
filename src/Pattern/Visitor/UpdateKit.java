package Pattern.Visitor;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/30
 * @week: 星期一
 * @message: 升级包
 * @author: morSun
 */
public class UpdateKit implements Kit{

    // 两个不同的硬件，只是对同一条命令的处理方式不一样，不影响抽象类HardWare 的结构

    /**①重写visit 双分派之静态分派*/
    @Override
    public void visit(Disk disk) {
        String command = disk.getCommand();
        command+=" 追加指令：记录 java=掉头发";
        disk.setCommand(command);
    }

    @Override
    public void visit(CPU cpu) {
        //更新指令
        String command = cpu.getCommand();
        command+= " 追加指令：java=掉头发";
        cpu.setCommand(command);
    }
}
