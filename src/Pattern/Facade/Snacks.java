package Pattern.Facade;

/**
 * @package_name: Pattern.Facade
 * @date: 2023/1/25
 * @week: 星期三
 * @message: 零食
 * @author: morSun
 */
public class Snacks {
    private Snacks(){}
    private static final Snacks instance=new Snacks();

    public static Snacks getInstance() {
        return instance;
    }

    public void prepare()
    {
        System.out.println("准备零食");
    }
    public void eat()
    {
        System.out.println("吃零食");
    }
    public void clean()
    {
        System.out.println("收拾食物残渣");
    }
}
