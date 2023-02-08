package Pattern.ShareElement.BikeDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @package_name: Pattern.ShareElement.BikeDemo
 * @date: 2023/1/26
 * @week: 星期四
 * @message: 自行车工厂
 * @author: morSun
 */
public class BikeFactory {
    List<Bike> bikes =new ArrayList<>();
    public BikeFactory()
    {
        for (int i = 1; i < 3; i++) {
            bikes.add(new XiaoHuangCheBike(i));
        }
    }

    public Bike getBike()
    {
        for (Bike bike : bikes) {
            if (bike.getState()==0)
                return bike;
        }
        return null;
    }
}
