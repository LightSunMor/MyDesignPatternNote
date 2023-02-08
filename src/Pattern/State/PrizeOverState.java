package Pattern.State;

/**
 * @package_name: Pattern.State
 * @date: 2023/2/5
 * @week: 星期日
 * @message: 奖品发放完毕状态
 * @author: morSun
 */
public class PrizeOverState extends State{

    public PrizeOverState(Activity activity) {
        super(activity);
    }

    @Override
    public void deduce() {
        throw new UnsupportedOperationException("奖品已经兑换完结，无法抽奖");
    }

    @Override
    public boolean raffle() {
        throw new UnsupportedOperationException("奖品已经兑换完结，无法抽奖");
    }

    @Override
    public void dispensePrize() {
        throw new UnsupportedOperationException("奖品已经兑换完结，无法抽奖");}
}
