package Pattern.Builder.Demo2经典四对象;

/**
 * @package_name: Pattern.Builder.Demo3
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 房屋抽象建造接口
 * @author: morSun
 */
// OCP原则 ，
public abstract class HouseBuilder {
//    House house = new House(); //唯一对象，使用这种方法，一个Builder只对应一个House
    private String floor;
    private   String window;
    private String area;

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public void setArea(String area) {
        this.area = area;
    }

    abstract HouseBuilder withFloor();
   abstract HouseBuilder withWindow();
   abstract HouseBuilder withArea();

    public House build()
    {
        House house = new House();
        house.setFloor(floor);
        house.setArea(area);
        house.setWindow(window);
        return house;
    }
}
