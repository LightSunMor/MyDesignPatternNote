package Pattern.Singleton.Ehan;

/**
 * @package_name: Pattern.Singleton.Ehan
 * @date: 2023/1/15
 * @week: 星期日
 * @message: 单例模式之饿汉式
 * @author: morSun
 */
public class Ehan {
    private Ehan()
    {

    }
    private static final Ehan singleton=new Ehan(); //增加final可以优化singleton唯一的逻辑
    public static Ehan getSingleton()
    {
        return singleton;
    }

    // 使用静态代码块替换直接创建也可以
//    static {
//        singleton=new Ehan();
//    }


}
