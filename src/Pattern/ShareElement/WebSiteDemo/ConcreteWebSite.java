package Pattern.ShareElement.WebSiteDemo;

/**
 * @package_name: Pattern.ShareElement.WebSiteDemo
 * @date: 2023/1/26
 * @week: 星期四
 * @message: 具体的网站
 * @author: morSun
 */
public class ConcreteWebSite extends WebSite{
    public ConcreteWebSite(String type)
    {
        super(type);
    }

    @Override
    public void use(User user) {
        System.out.println(user.getName()+"正在使用 " +type+"网站");
    }
}
