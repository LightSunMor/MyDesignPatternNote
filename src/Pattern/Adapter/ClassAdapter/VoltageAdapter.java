package Pattern.Adapter.ClassAdapter;

/**
 * @package_name: Pattern.Adapter.ClassAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 电压转换器
 * @author: morSun
 */
public class VoltageAdapter extends Voltage220 implements Voltage22 {

    @Override
    public int outPut20() {
        int outPut220 = outPut220();
        int output = outPut220 / 10;
        System.out.println("充电器转换电压为："+output);
        System.out.println("交流电---->直流电");
        return output;
    }
}
