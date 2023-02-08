package Pattern.Mediator.AutoFurniture;

/**
 * @package_name: Pattern.Mediator
 * @date: 2023/2/2
 * @week: 星期四
 * @message: 咖啡机
 * @author: morSun
 */
public class CoffeeMachine extends Furniture{


    CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
    }
    void open()
    {
        System.out.println("咖啡机开启了");
    }
    void stop()
    {
        System.out.println("咖啡机工作结束，咖啡已完成");
    }
    @Override
    protected void sendMsg(String tag) {
        getMediator().dealWork(this,tag);
    }
}
