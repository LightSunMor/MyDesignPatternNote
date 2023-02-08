package Pattern.Facade;

/**
 * @package_name: Pattern.Facade
 * @date: 2023/1/25
 * @week: 星期三
 * @message: 荧幕
 * @author: morSun
 */
public class Screen {
    private Screen(){}
    private static final  Screen instance= new Screen();

    public static Screen getInstance() {
        return instance;
    }
    public void up()
    {
        System.out.println("荧幕升起");
    }
    public void down()
    {
        System.out.println("荧幕降下");
    }

}
