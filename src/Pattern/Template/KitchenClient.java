package Pattern.Template;

/**
 * @package_name: Pattern.Template
 * @date: 2023/1/28
 * @week: 星期六
 * @message: 厨房客户端 
 * @author: morSun
 */
public class KitchenClient {
    public static void main(String[] args) {
        CookingTemplate cookPotato = new CookPotato();
        cookPotato.template();
        System.out.println("-----------");
        CookingTemplate soup = new CookEggSoup();
        soup.template();
    }
}
