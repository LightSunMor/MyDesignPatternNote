package Pattern.ShareElement.WebSiteDemo;

/**
 * @package_name: Pattern.ShareElement.WebSiteDemo
 * @date: 2023/1/26
 * @week: 星期四
 * @message: 客户端
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite webSite = factory.getWebSiteCategory("BLOG");
        webSite.use(new User("红"));

        WebSite webSite1 = factory.getWebSiteCategory("BLOG");
        webSite1.use(new User("鑫"));

        //比较两个网站是否相同
        System.out.println(webSite==webSite1);

        WebSite webSite2 = factory.getWebSiteCategory("QUESTION");
        if (webSite2==null)
            System.out.println("无法使用这种网站");
        else
            webSite2.use(new User("鸿"));
    }
}
