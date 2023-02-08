package Pattern.ShareElement.BikeDemo;

/**
 * @package_name: Pattern.ShareElement.BikeDemo
 * @date: 2023/1/26
 * @week: 星期四
 * @message: 客户端
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        BikeFactory factory = new BikeFactory();

        Bike bike = factory.getBike();
        bike.ride(new User("鸿"));

        Bike bike1 = factory.getBike();
        bike1.ride(new User("鑫")); // todo：在User中添加一个ride和back方法更加合理

        //鸿还车了
        bike.back();

        Bike bike2 = factory.getBike();
        if (bike2==null)
            System.out.println("此时没有可用共享单车，请稍后再来");
        else
            bike2.ride(new User("明"));
        //明是否和鸿开到的车是同一辆
        System.out.println(bike==bike2);

    }
}
