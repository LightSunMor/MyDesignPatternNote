package Pattern.Template;

/**
 * @package_name: Pattern.Template
 * @date: 2023/1/28
 * @week: 星期六
 * @message: 炒土豆
 * @author: morSun
 */
// 继承模板方法类
public class CookPotato extends CookingTemplate{


    @Override
    protected void addActor() {
        System.out.println("--放入洗好的土豆以及适量的水");
    }

    @Override
    protected void addSeasoning() {
        System.out.println("--放入盐，鸡精");
    }

    //需要炒料
    @Override
    protected Boolean isFryStir() {
        return true;
    }
}
