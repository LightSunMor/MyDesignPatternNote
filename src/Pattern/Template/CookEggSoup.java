package Pattern.Template;

/**
 * @package_name: Pattern.Template
 * @date: 2023/1/28
 * @week: 星期六
 * @message: 鸡蛋汤
 * @author: morSun
 */
public class CookEggSoup extends CookingTemplate{

    @Override
    protected void addActor() {
        System.out.println("--放入打散的鸡蛋，翻炒成型，再加入水");
    }

    @Override
    protected void addSeasoning() {
        System.out.println("--放入盐，鸡精，胡椒粉");
    }
}
