package Pattern.Builder.Demo2经典四对象;

/**
 * @package_name: Pattern.Builder.Demo3
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 一级房屋建造器
 * @author: morSun
 */
public class LevelOneHouseBuilder extends HouseBuilder{
    @Override
    public HouseBuilder withFloor() {
        setFloor("红木地板");
        return this;
    }
    @Override
    public HouseBuilder withWindow() {
        setWindow("防弹玻璃");
        return this;
    }

    @Override
    public HouseBuilder withArea() {
        setArea("占地100平");
        return this;
    }

}
