package Pattern.ShareElement.BikeDemo;

/**
 * @package_name: Pattern.ShareElement.BikeDemo
 * @date: 2023/1/25
 * @week: 星期三
 * @message: 抽象自行车类
 * @author: morSun
 */
public abstract class Bike {
    //内部状态  0-未使用  1-使用中
    protected int state;

    protected  abstract void ride(User user);
    protected abstract void back();

    public int getState() {
        return state;
    }
}
