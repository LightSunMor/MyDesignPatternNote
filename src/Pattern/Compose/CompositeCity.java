package Pattern.Compose;

import java.util.ArrayList;
import java.util.List;

/**
 * @package_name: Pattern.Compose
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 管理叶子的容器层
 * @author: morSun
 */
public class CompositeCity extends CityComponent{
    private List<CityComponent> cityComponents=new ArrayList<>();


    @Override
    public void add(CityComponent component) {
        //在一些复杂的业务情况下，前面还要做许多操作
        cityComponents.add(component);
    }

    @Override
    public void remove(CityComponent component) {
        cityComponents.remove(component);
    }

    //管理层将收集人口数交给子元素，自己负责统计
    @Override
    public Long count() {
        long sum=0;
        for (CityComponent component : cityComponents) {
            sum+=component.count();
        }
        return sum;
    }
}
