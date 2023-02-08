package Pattern.State;

/**
 * @package_name: Pattern.State
 * @date: 2023/2/5
 * @week: 星期日
 * @message: 抽奖
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        Activity activity = new Activity();
        try {
            //设置积分
            activity.setIntegral(100);
            for (int i = 0; i < 10; i++) {
                System.out.println("===第次"+(i+1)+"抽奖===");
                //扣积分
                activity.deduce();
                //抽奖
                boolean raffle = activity.raffle();
                if (raffle)
                {
                    activity.dispensePrize();
                }
                System.out.println("**目前奖品剩余**");
                System.out.println(activity.getCountPrize()+"件");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
