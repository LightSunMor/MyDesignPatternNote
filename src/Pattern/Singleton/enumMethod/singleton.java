package Pattern.Singleton.enumMethod;

import java.util.Collection;

/**
 * @package_name: Pattern.Singleton.enumMethod
 * @date: 2023/1/16
 * @week: 星期一
 * @message: 利用枚举类的特性，制造单例
 * @author: morSun
 */
public enum singleton {
    INSTANCE(1){    //无法找出第二个INSTANCE

        @Override
        public void say() {
            System.out.println("instance");
        }
    };
    private int num;

    //枚举类默认的构造器本来是私有的
    singleton(int i) {
        this.num=i;
    }

    public void run()
    {
        System.out.println(INSTANCE.ordinal()+":跑起来");
    }
    //枚举类可以有抽象方法，且枚举项必须实现它
    public abstract void say();

    public static void main(String[] args) {
        singleton instance = singleton.INSTANCE;
        singleton instance1 = singleton.INSTANCE;
        System.out.println(instance1==instance);
        System.out.println(instance1.hashCode()+"  "+instance.hashCode());
        System.out.println("----------");
        instance.say();
        instance.run();
    }
}
