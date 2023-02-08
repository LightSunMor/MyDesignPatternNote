package Pattern.Strategy;

/**
 * @package_name: Pattern.Strategy
 * @date: 2023/2/6
 * @week: 星期一
 * @message: 使用策略方
 * @author: morSun
 */
public abstract class Person {
    RunStrategy runStrategy=null;

    public Person(RunStrategy runStrategy) {
        this.runStrategy = runStrategy;
    }

    void eat()
    {
        System.out.println(this.getClass().getSimpleName()+"可以吃饭");
    }
    void run()
    {
        if (runStrategy!=null)
        {
            runStrategy.run();
        }else {
            System.out.println("不清楚能否跑步");
        }
    }
}
