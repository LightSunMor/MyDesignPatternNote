package Pattern.Singleton.Lhan;

import java.text.DateFormat;

/**
 * @package_name: Pattern.Singleton.Lhan
 * @date: 2023/1/16
 * @week: 星期一
 * @message: 单例模式之懒汉式 线程安全
 * @author: morSun
 */
public class LhanSafe {
    private LhanSafe(){}

    private static LhanSafe singleton;

    //锁住调用者的方法
    public synchronized LhanSafe getSingleton()
    {
        if (singleton==null)
            singleton=new LhanSafe();
        return singleton;
    }


}
