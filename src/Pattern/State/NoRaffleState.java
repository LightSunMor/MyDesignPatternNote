package Pattern.State;

/**
 * @package_name: Pattern.State
 * @date: 2023/2/5
 * @week: 星期日
 * @message: 无法抽奖状态（初始默认状态）
 * @author: morSun
 */
public class NoRaffleState extends State{


    public NoRaffleState(Activity activity) {
        super(activity);
    }

    @Override
    public void deduce() {
        if (activity.getCountPrize()>0&&activity.getIntegral()>=20)
        {
            System.out.println("扣除积分成功！积分减20");
            activity.setIntegral(activity.getIntegral()-20);
            // 执行扣除积分动作后，转变状态
            activity.setState(activity.getStateList().get("canraffle"));
        }else if (activity.getCountPrize()<=0){
            //没有奖励了
            System.out.println("奖励已经兑换完，无法进行抽奖");
            activity.setState(activity.getStateList().get("prizeover"));
        } else if (activity.getIntegral()<20)
        {
            System.out.println("积分不足，无法进行抽奖");
        }

    }

    @Override
    public boolean raffle() {
        throw new UnsupportedOperationException("还未扣除积分，无法抽奖");
    }

    @Override
    public void dispensePrize() {
        throw new UnsupportedOperationException("还未抽奖，无法兑奖");
    }
}
