package Pattern.Singleton.Lhan;

/**
 * @package_name: Pattern.Singleton.Lhan
 * @date: 2023/1/15
 * @week: 星期日
 * @message: 单例模式之懒汉式 线程不安全
 * @author: morSun
 */
public class LhanUnsafe {
    private LhanUnsafe(){}

    private static LhanUnsafe singleton;

    public static LhanUnsafe getSingleton()
    {
        //达到懒加载的目的
        if (singleton==null)
            singleton=new LhanUnsafe();
        return singleton;
    }

}
