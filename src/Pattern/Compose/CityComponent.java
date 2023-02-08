package Pattern.Compose;

/**
 * @package_name: Pattern.Compose
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 抽象类 定义一些通用的行为和变量
 * @author: morSun
 */
// 人口计数抽象总类
public abstract class CityComponent {
    //对添加和删除组件，进行默认实现，因为在叶子中不不需要这两个方法
    protected void add(CityComponent component)
    {
        throw new UnsupportedOperationException();
    }
    protected void remove(CityComponent component){
        throw new UnsupportedOperationException();
    }

    // 计数是抽象方法，因为每个类中都不一样
    protected abstract Long count();

}
