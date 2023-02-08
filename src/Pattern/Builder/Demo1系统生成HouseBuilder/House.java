package Pattern.Builder.Demo1系统生成HouseBuilder;

/**
 * @package_name: Pattern.Builder.Demo1
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 建房子
 * @author: morSun
 */

public class House {
    private String floor;
    private String wall;
    private String roof;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "floor='" + floor + '\'' +
                ", wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}
