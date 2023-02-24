package Pattern.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @package_name: Pattern.State
 * @date: 2023/2/5
 * @week: 星期日
 * @message: 活动
 * @author: morSun
 */
//管理状态，执行操作
public class Activity {
    int countPrize=0;
    int integral=0;
    State state=null;
    // 管理本身拥有的多种状态
    HashMap<String,State> stateList=null;

    public Activity() {
        stateList=new HashMap<>();
        //将activity （content）传入状态，以便修改状态
        NoRaffleState noRaffleState = new NoRaffleState(this);
        stateList.put("noraffle",noRaffleState);
        stateList.put("canraffle",new CanRaffleState(this));
        stateList.put("dispense",new DispenseState(this));
        stateList.put("prizeover",new PrizeOverState(this));
        state=noRaffleState;
        countPrize=2;
    }

    public HashMap<String, State> getStateList() {
        return stateList;
    }

    /***
     *  添加状态
     * @param state
     */
    public void addState(State state)
    {
        String namesimple = state.getClass().getSimpleName().toLowerCase();
        String keyname = namesimple.substring(0, namesimple.length() - 5);
        System.out.println(keyname);
        stateList.put(keyname,state);
    }

    /**
     *  移除状态
     * @param key
     */
    public void removeState(String key)
    {
        if (stateList.containsKey(key))
        {
            stateList.remove(key);
        }
    }

    public int getCountPrize() {
        return countPrize;
    }

    public void setCountPrize(int countPrize) {
        this.countPrize = countPrize;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    //本人执行抽奖行为

    //扣积分
    public  void deduce(){
        state.deduce();
    }
    //抽奖
    public boolean raffle(){
        return state.raffle();
    }
    //兑换奖励
    public  void dispensePrize(){
        state.dispensePrize();
    }
}
