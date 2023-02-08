package Pattern.ShareElement.WebSiteDemo;

/**
 * @package_name: Pattern.ShareElement.WebSiteDemo
 * @date: 2023/1/25
 * @week: 星期三
 * @message: 抽象网站类
 * @author: morSun
 */
public abstract class WebSite {
    protected String type;
    protected WebSite(String type)
    {
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public abstract void use(User user);
}
