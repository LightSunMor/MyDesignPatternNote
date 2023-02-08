package Pattern.Singleton.staticInnerClass;

/**
 * @package_name: Pattern.Singleton.staticInnerClass
 * @date: 2023/1/16
 * @week: 星期一
 * @message: 利用静态内部类对变量进行实例化，利用jvm保证线程安全
 * @author: morSun
 */
public class staticInner {
    private staticInner(){}
    //定义一个静态内部类，用于初始化实例
    static class  staticInnerSingleton{
        public static final staticInner INSTANCE = new staticInner(); //内部类第一次加载时初始化
    }

    public static staticInner getInstance()
    {
        return staticInnerSingleton.INSTANCE; //直接调用静态变量
    }
}
