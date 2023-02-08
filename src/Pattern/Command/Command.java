package Pattern.Command;

/**
 * @package_name: Pattern.Command
 * @date: 2023/1/29
 * @week: 星期日
 * @message: 命令接口
 * @author: morSun
 */
public interface Command {
    void execute();
    void undo();
}

