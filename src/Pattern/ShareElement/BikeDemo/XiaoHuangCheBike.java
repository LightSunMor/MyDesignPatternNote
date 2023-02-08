package Pattern.ShareElement.BikeDemo;

/**
 * @package_name: Pattern.ShareElement.BikeDemo
 * @date: 2023/1/26
 * @week: 星期四
 * @message: 具体单车
 * @author: morSun
 */
public class XiaoHuangCheBike extends Bike{
    public Integer rideId;

    public XiaoHuangCheBike() {
    }

    public XiaoHuangCheBike(Integer rideId) {
        this.rideId = rideId;
    }

    @Override
    protected void ride(User user) {
        if (state==0)
            System.out.println(user.getName()+" 正在骑单车"+rideId+"号");
        else
            System.out.println(rideId+"号这辆车正在被人骑");
        state=1;
    }

    @Override
    protected void back() {
        System.out.println(rideId+"号已还车成功");
        state=0;
    }
}
