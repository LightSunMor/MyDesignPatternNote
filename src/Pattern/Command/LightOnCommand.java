package Pattern.Command;

/**
 * @package_name: Pattern.Command
 * @date: 2023/1/29
 * @week: 星期日
 * @message: 电灯打开命令
 * @author: morSun
 */
public class LightOnCommand implements Command{

    //聚合电灯，使用它的功能
    private LightReceiver receiver;
    public LightOnCommand(LightReceiver receiver)
    {
        this.receiver=receiver;
    }

    //在这个类中，不止做电灯的打开操作，还有一些业务逻辑
    @Override
    public void execute() {
        //...逻辑操作

        // 打开电灯
        receiver.on();

    }

    @Override
    public void undo() {
        System.out.println("撤销:");
        receiver.off(); //因为此类处理电灯打开操作（单一职责），它的撤销动作就是相反的
    }
}
