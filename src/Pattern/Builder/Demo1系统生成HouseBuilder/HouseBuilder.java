package Pattern.Builder.Demo1系统生成HouseBuilder;

/**
 * @package_name: Pattern.Builder.Demo1
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 房子建造者 这个类应该还可以再次被创建
 * @author: morSun
 */
public final class HouseBuilder {
    private String floor;
    private String wall;
    private String roof;

    private HouseBuilder() {
    }

    public static HouseBuilder aHouse() {
        return new HouseBuilder();
    }

    public HouseBuilder withFloor(String floor) {
        this.floor = floor;
        return this;
    }

    public HouseBuilder withWall(String wall) {
        this.wall = wall;
        return this;
    }

    public HouseBuilder withRoof(String roof) {
        this.roof = roof;
        return this;
    }

    public House build() {
        House house = new House(); //组合 House类
        house.setFloor(floor);
        house.setWall(wall);
        house.setRoof(roof);
        return house;
    }
}
