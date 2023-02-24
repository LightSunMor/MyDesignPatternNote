package Pattern.State;

import java.util.Random;

/**
 * @package_name: Pattern.State
 * @date: 2023/2/5
 * @week: 星期日
 * @message: 可以抽奖状态
 * @author: morSun
 */
// 定义操作，切换状态
public class CanRaffleState extends State{

    public CanRaffleState(Activity activity) {
        super(activity);
    }

    @Override
    public void deduce() {
        throw new UnsupportedOperationException("积分已经扣除，请进行抽奖");
    }

    @Override
    public boolean raffle() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        if (nextInt==7)
        {
            System.out.println("恭喜，中奖了！！！");
            activity.setState(activity.getStateList().get("dispense"));
            return true;
        }
        else {
            System.out.println("抱歉，你和奖品插肩而过~~");
            activity.setState(activity.getStateList().get("noraffle"));
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        throw new UnsupportedOperationException("还未抽奖，无法兑奖");
    }
}
