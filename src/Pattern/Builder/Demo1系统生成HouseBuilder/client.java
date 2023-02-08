package Pattern.Builder.Demo1系统生成HouseBuilder;

/**
 * @package_name: Pattern.Builder.Demo1
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 客户端使用
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        HouseBuilder houseBuilder = HouseBuilder.aHouse();
        House build = houseBuilder.withWall("大理石").withFloor("红木").build(); //这一步可以根据客户端的要求，再builder新建构建House方法进行处理
        System.out.println(build);
    }
}
