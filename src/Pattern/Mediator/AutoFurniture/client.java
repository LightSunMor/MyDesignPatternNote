package Pattern.Mediator.AutoFurniture;

/**
 * @package_name: Pattern.Mediator.AutoFurniture
 * @date: 2023/2/2
 * @week: 星期四
 * @message:
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        TV tv = new TV(mediator, "电视机");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "咖啡机");

        //电视机打开准备 （电视机向中介者发出启动指令，并由中介者接收指令，并且）
        tv.sendMsg("start");

        coffeeMachine.sendMsg("start");

        tv.sendMsg("play");

        tv.sendMsg("pause");
        tv.sendMsg("back");

        tv.sendMsg("upLight");

        tv.sendMsg("end");

        //todo：这里的操作可以封装为一个组合模式

    }
}
