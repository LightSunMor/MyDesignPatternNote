package Pattern.Adapter.ClassAdapter;

/**
 * @package_name: Pattern.Adapter.ClassAdapter
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 人（客户端）：给平板充电
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        Ipad ipad = new Ipad();
        ipad.charging(new VoltageAdapter());

    }
}
