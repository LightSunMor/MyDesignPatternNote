package Pattern.Builder.Demo2经典四对象;

/**
 * @package_name: Pattern.Builder.Demo3
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 二级房屋建造
 * @author: morSun
 */
public class LevelTwoHouseBuilder extends HouseBuilder{

    @Override
    public HouseBuilder withFloor() {
        setFloor("瓷砖");
        return this;
    }

    @Override
    public HouseBuilder withWindow() {
       setWindow("普通玻璃");
        return this;
    }

    @Override
    public HouseBuilder withArea() {
        setArea("占地50平");
        return this;
    }
}
