package Pattern.Singleton.doubleCheck;

/**
 * @package_name: Pattern.Singleton.doubleCheck
 * @date: 2023/1/16
 * @week: 星期一
 * @message: 双重检查 线程安全
 * @author: morSun
 */
public class doubleCheck {
    private doubleCheck(){};
    private static volatile doubleCheck singleton; // volatile禁止指令重排
    //不在方法上加锁
    public doubleCheck getSingleton()
    {
        //外面的判断，可以达到只实例化一次。其余直接返回，提高效率
        if (singleton==null)
        {
            synchronized (doubleCheck.class) //将静态资源锁起来
            {
                if (singleton==null)
                    singleton=new doubleCheck();
            }
        }
        return singleton;
    }
}
