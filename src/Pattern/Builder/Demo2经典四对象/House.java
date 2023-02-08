package Pattern.Builder.Demo2经典四对象;

/**
 * @package_name: Pattern.Builder.Demo3
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 房屋产品类
 * @author: morSun
 */
public class House {
    private String floor;
    private String window;
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

    @Override
    public String toString() {
        return "House{" +
                "floor='" + floor + '\'' +
                ", window='" + window + '\'' +
                ", area='" + area + '\'' +
                ",hashCode="+this.hashCode()+
                '}';
    }
}
