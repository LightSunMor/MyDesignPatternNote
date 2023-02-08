package Pattern.Facade;

/**
 * @package_name: Pattern.Facade
 * @date: 2023/1/25
 * @week: 星期三
 * @message: 投影仪
 * @author: morSun
 */
public class Projector {
    private Projector(){}
    private static final  Projector instance= new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void open()
    {
        System.out.println("投影仪打开");
    }
    public void close()
    {
        System.out.println("投影仪关闭");
    }
    public void pause()
    {
        System.out.println("投影仪暂停");
    }
    public void play()
    {
        System.out.println("投影仪正在播放");
    }
}
