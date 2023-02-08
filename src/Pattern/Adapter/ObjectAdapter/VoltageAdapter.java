package Pattern.Adapter.ObjectAdapter;

/**
 * @package_name: Pattern.Adapter.ObjectAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 电压转化器
 * @author: morSun
 */
public class VoltageAdapter implements Voltage22{
    //聚合一个220V
    Voltage220 voltage220;
    public VoltageAdapter(Voltage220 voltage220)
    {
        this.voltage220=voltage220;
    }
    //可以实现一个默认的Voltage220，用作handle中的默认处理对象
//    public Voltage22 handle()
//    {
//    }

    @Override
    public int outPut20() {
        int put220 = voltage220.outPut220();
        int output = put220 / 10;
        System.out.println("充电器转换电压为："+output);
        System.out.println("交流电---->直流电");
        return output;
    }
}
