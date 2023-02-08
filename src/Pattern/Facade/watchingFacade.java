package Pattern.Facade;

/**
 * @package_name: Pattern.Facade
 * @date: 2023/1/25
 * @week: 星期三
 * @message: 观影外观模式
 * @author: morSun
 */
public class watchingFacade {
   private Projector projector=Projector.getInstance();
   private Screen screen=Screen.getInstance();
   private Snacks snacks=Snacks.getInstance();

    public void prepare()
    {
        screen.down();
        projector.open();
        snacks.prepare();
    }

    public void watching()
    {
        projector.play();
        snacks.eat();

    }
    public void pause()
    {
        projector.pause();
    }
    public void reBack()
    {
        projector.play();
    }
    public void end()
    {
        projector.close();
        screen.up();
        snacks.clean();
    }
}
