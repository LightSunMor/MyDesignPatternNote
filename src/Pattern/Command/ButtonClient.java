package Pattern.Command;

/**
 * @package_name: Pattern.Command
 * @date: 2023/1/29
 * @week: 星期日
 * @message: 遥控器客户端
 * @author: morSun
 */
public class ButtonClient {
    public static void main(String[] args) {
        CommandController controller = new CommandController();
        LightReceiver lightReceiver = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
        controller.setOnCommand(0,lightOnCommand);
        controller.setOffCommand(0,lightOffCommand);

        //
        System.out.println("----打开电灯----");
        controller.pushOnButton(0);
        controller.undoButton();
        System.out.println("----关闭电灯----");
        controller.pushOffButton(0);
        controller.pushOnButton(0);
        controller.undoButton();
    }
    // 需要拓展子类的话，可以实现Command，只需创建三个类，就不用再修改什么（符合OCP原则）
}
