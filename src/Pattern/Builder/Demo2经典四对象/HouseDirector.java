package Pattern.Builder.Demo2经典四对象;

/**
 * @package_name: Pattern.Builder.Demo3
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 房屋建造指挥者
 * @author: morSun
 */
public class HouseDirector {
    private HouseBuilder houseBuilder;
    public  HouseDirector(HouseBuilder houseBuilder)
    {
        this.houseBuilder=houseBuilder;
    }

    //指定建造房子的流程(如果觉得不复杂就交给客户端来做)
    public House getHouse()
    {
        House build = houseBuilder.withFloor().withWindow().withArea().build();
        return build;
    }
}
