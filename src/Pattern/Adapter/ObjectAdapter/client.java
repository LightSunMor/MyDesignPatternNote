package Pattern.Adapter.ObjectAdapter;

/**
 * @package_name: Pattern.Adapter.ObjectAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 客户端
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        Ipad ipad = new Ipad();
        ipad.charging(new VoltageAdapter(new Voltage220()));
    }
}
