package Pattern.Strategy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @package_name: Pattern.Strategy
 * @date: 2023/2/6
 * @week: 星期一
 * @message:
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        Baby baby = new Baby(new NoRunStrategy());
        baby.eat();
        baby.run();

        OldMan oldMan = new OldMan(new RunSlowStrategy());
        oldMan.eat();
        oldMan.run();

        Boerte boerte = new Boerte(new RunFastStrategy());
        boerte.eat();
        boerte.run();


    }
}
