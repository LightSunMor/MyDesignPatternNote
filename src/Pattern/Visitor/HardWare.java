package Pattern.Visitor;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/29
 * @week: 星期日
 * @message: 硬件接口
 * @author: morSun
 */
public abstract class HardWare {
    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    //执行指令的方法
    public void run()
    {
        System.out.println(command);
    }

    //暴露方法，让操作可以访问数据结构中的元素
    protected abstract void accept(Kit kit);
}
