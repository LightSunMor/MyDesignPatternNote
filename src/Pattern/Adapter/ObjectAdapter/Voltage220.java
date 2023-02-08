package Pattern.Adapter.ObjectAdapter;

/**
 * @package_name: Pattern.Adapter.ClassAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 220V交流电
 * @author: morSun
 */
public class Voltage220 {

    //原始接口提供的功能
    public int outPut220()
    {
        System.out.println("插板提供220V交流电");
        return 220;
    }
}
