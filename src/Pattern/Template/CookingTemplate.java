package Pattern.Template;

/**
 * @package_name: Pattern.Template
 * @date: 2023/1/28
 * @week: 星期六
 * @message: 做饭模板类（抽象类）
 * @author: morSun
 */
public abstract class CookingTemplate {
    public final void template()
    {
        firePot();
        oil();
        if (isFryStir())
            fryStir();
        addActor();
        addSeasoning();
        turnOffFire();
    }

    //烧锅
    protected void firePot()
    {
        System.out.println("--开火烧锅");
    }
    //放油
    protected void oil()
    {
        System.out.println("--火候合适，放入油");
    }
    // 炒料
    protected void fryStir()
    {
        System.out.println("--放入姜蒜干辣椒等爆香");
    }
    // 由于有的菜不需要爆香，所以对其设置一个钩子方法 (默认不实现)
    protected Boolean isFryStir()
    {
        return false;
    }

    //下菜
    protected abstract void addActor();

    // 放调味料
    protected abstract void addSeasoning();
    //关火乘出
    protected void turnOffFire()
    {
        System.out.println("--关火，乘出");
    }
}
