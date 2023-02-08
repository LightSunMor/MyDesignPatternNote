package Pattern.State;

/**
 * @package_name: Pattern.State
 * @date: 2023/2/5
 * @week: 星期日
 * @message: 可兑奖状态
 * @author: morSun
 */
public class DispenseState extends State{

    public DispenseState(Activity activity) {
        super(activity);
    }

    @Override
    public void deduce() {
        throw new UnsupportedOperationException("积分已经扣除，请进行兑奖");
    }

    @Override
    public boolean raffle() {
        throw new UnsupportedOperationException("已中奖，无法抽奖");
    }

    @Override
    public void dispensePrize() {
        if (activity.getCountPrize()>0)
        {
            System.out.println("兑换奖品成功！");
            activity.setCountPrize(activity.getCountPrize()-1);
            activity.setState(activity.getStateList().get("noraffle"));
        }else {
            System.out.println("奖品已空，返还积分");
            activity.setIntegral(activity.getIntegral()+20);
            activity.setState(activity.getStateList().get("prizeover"));
        }
    }
}
