package Pattern.Decorate.Coffee;

/**
 * @package_name: Pattern.Decorate.Coffee
 * @date: 2023/1/21
 * @week: 星期六
 * @message: 意式咖啡
 * @author: morSun
 */
public class LongBlack extends Coffee{
    // 只是一个单体咖啡的钱，也重写cost了
    public LongBlack()
    {
        setDes("意式咖啡");
        setPrice(6);
    }

}
