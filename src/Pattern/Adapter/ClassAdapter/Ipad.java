package Pattern.Adapter.ClassAdapter;

/**
 * @package_name: Pattern.Adapter.ClassAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 平板充电，使用20V直流电
 * @author: morSun
 */
public class Ipad {
    void charging(Voltage22 voltage20)
    {
        if (voltage20.outPut20()==22)
        {
            System.out.println("---------------");
            System.out.println("平板充电成功");
        }else {
            System.out.println("平板无法充电");
        }
    }
}
