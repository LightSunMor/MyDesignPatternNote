package Pattern.Facade;

import java.util.HashMap;

/**
 * @package_name: Pattern.Facade
 * @date: 2023/1/25
 * @week: 星期三
 * @message: 观影人
 * @author: morSun
 */
public class watchClient {
    public static void main(String[] args) {
        // 原始看电影调用顺序 (都是单例模式获取对象)
        Projector projector = Projector.getInstance();
        Screen screen =Screen.getInstance();
        Snacks snacks = Snacks.getInstance();
            //1.准备
//        projector.open();
//        screen.down();
//        snacks.prepare();
//            //2.看
//        projector.play();
//        snacks.eat();
//            //3.暂停
//        projector.pause();
//            //4.结束
//        projector.close();
//        snacks.clean();
//        screen.up();


        //使用外观模式
        watchingFacade facade = new watchingFacade();
        System.out.println("--准备阶段--");
        facade.prepare();
        System.out.println("--观影阶段--");
        facade.watching();
        System.out.println("--暂停阶段--");
        facade.pause();
        System.out.println("--回到观影阶段--");
        facade.reBack();
        System.out.println("--结束观影--");
        facade.end();


    }
}
