package Pattern.Builder.Demo2经典四对象;

/**
 * @package_name: Pattern.Builder.Demo3
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 需要房子的客户端
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        //需要一级房,拿到一级房的图纸（建造者）
        LevelOneHouseBuilder builder = new LevelOneHouseBuilder();
        HouseDirector houseDirector = new HouseDirector(builder);
        House house = houseDirector.getHouse();
        House temp = houseDirector.getHouse();
        System.out.println(temp);
        System.out.println(house);
        System.out.println(temp==house);// 如果使用

        //需要二级房,拿到一级房的图纸（建造者）
        LevelTwoHouseBuilder levelTwoHouseBuilder = new LevelTwoHouseBuilder();
        HouseDirector houseDirector1 = new HouseDirector(levelTwoHouseBuilder);
        House house1 = houseDirector1.getHouse();
        System.out.println(house1);


    }
}
