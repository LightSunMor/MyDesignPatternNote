package Pattern.Adapter.DefaultAdapter;

/**
 * @package_name: Pattern.Adapter.DefaultAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 操作行动组接口
 * @author: morSun
 */
public interface ActionGroup {
    void actionA();
    void actionB();
    void actionC();
    void actionD();

    //除了使用抽象类进行继承实现，jdk8之后也出现了default关键实现默认方法
    default void actionE()
    {

    }
}
