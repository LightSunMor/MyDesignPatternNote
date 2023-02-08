package Pattern.State;

/**
 * @package_name: Pattern.State
 * @date: 2023/2/5
 * @week: 星期日
 * @message: 抽象状态类
 * @author: morSun
 */
public abstract class State {
    protected Activity activity=null;

    public State(Activity activity) {
        this.activity = activity;
    }

    //扣积分
    public abstract void deduce();
    //抽奖
    public abstract boolean raffle();
    //兑换奖励
    public abstract void dispensePrize();
}
