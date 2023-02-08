package Pattern.Adapter.DefaultAdapter;

/**
 * @package_name: Pattern.Adapter.DefaultAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 行动操作组接口适配器
 * @author: morSun
 */
public abstract class ActionGroupAdapter implements ActionGroup{
    //对所有方法进行默认实现，这样子类就可以自己选择重写方法了
        // 当然如果有的方法必须实现，这里就不做默认实现
    @Override
    public void actionA() {

    }

    @Override
    public void actionB() {

    }

    @Override
    public void actionC() {

    }

    @Override
    public void actionD() {

    }
}
