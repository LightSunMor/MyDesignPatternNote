package Pattern.Compose;

/**
 * @package_name: Pattern.Compose
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 叶子  负责一些工作的类
 * @author: morSun
 */
public class DetailCountCity extends CityComponent{
    private Long count=0L;

    public DetailCountCity(Long count)
    {
        this.count=count;
    }

    @Override
    public Long count() {
        // 原本应该做一系列侦查工作，统计出当前小地方的人数
        return this.count;
    }
}
