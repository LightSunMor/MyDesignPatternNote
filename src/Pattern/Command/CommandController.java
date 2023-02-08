package Pattern.Command;

/**
 * @package_name: Pattern.Command
 * @date: 2023/1/29
 * @week: 星期日
 * @message: 命令发送者
 * @author: morSun
 */
public class CommandController {
    // 使用队列放置命令对象
    private Command[] onCommands=new Command[3];
    private Command[] offCommands=new Command[3];

    //记录当前命令对象，用于撤销操作
    private Command undoCommand;

    //初始化命令
    public CommandController()
    {
        for (Command onCommand : onCommands) {
            onCommand=new NoCommand();
        }
        for (Command offCommand : offCommands) {
            offCommand=new NoCommand();
        }
    }

    //设置命令
    public void setOnCommand(int no,Command command)
    {
        onCommands[no]=command;
    }
    public void setOffCommand(int no,Command command)
    {
        offCommands[no]=command;
    }

    //开启按钮  no指定是那一台电器
    public void pushOnButton(int no)
    {
        onCommands[no].execute();
        undoCommand=onCommands[no];
    }

    //关闭按钮
    public void pushOffButton(int no)
    {
        offCommands[no].execute();
        undoCommand=offCommands[no];
    }

    //撤销操作
    public void undoButton()
    {
        undoCommand.undo();
    }
}
