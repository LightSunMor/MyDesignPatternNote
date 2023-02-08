package Pattern.Adapter.DefaultAdapter;

/**
 * @package_name: Pattern.Adapter.DefaultAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 行动类
 * @author: morSun
 */
public class Action extends ActionGroupAdapter{
    @Override
    public void actionD() {
        super.actionD();
        System.out.println("重写了行动D");
    }
}
