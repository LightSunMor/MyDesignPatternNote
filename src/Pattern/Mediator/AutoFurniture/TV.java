package Pattern.Mediator.AutoFurniture;

/**
 * @package_name: Pattern.Mediator
 * @date: 2023/2/2
 * @week: 星期四
 * @message: 智能电视
 * @author: morSun
 */
public class TV extends Furniture{


    TV(Mediator mediator, String name) {
        super(mediator, name);

    }

    void prepare()
    {
        System.out.println("电视机电源开启");
    }

    void play()
    {
        System.out.println("电视机正在播放...");
    }
    void pause()
    {
        System.out.println("电视机暂停");
    }
    void close()
    {
        System.out.println("关闭电视机");
    }
    @Override
    protected void sendMsg(String tag) {
        getMediator().dealWork(this,tag);
    }
}
