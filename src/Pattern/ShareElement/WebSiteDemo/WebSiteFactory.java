package Pattern.ShareElement.WebSiteDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @package_name: Pattern.ShareElement.WebSiteDemo
 * @date: 2023/1/26
 * @week: 星期四
 * @message: 网站工厂，管理对象
 * @author: morSun
 */
public class WebSiteFactory {
    List<WebSite> webSites=new ArrayList<>();

    public synchronized WebSite getWebSiteCategory(String type)
    {
        WebSiteType[] values = WebSiteType.values();
        List<String> types = Arrays.stream(values).map(Enum::name).collect(Collectors.toList());
        if (!types.contains(type))
        {
            System.out.println("此网站无法支持该种类型");
            return null;
        }
        for (WebSite webSite : webSites) {
            if (webSite.getType().equals(type))
            {
                return webSite;
            }
        }
        ConcreteWebSite webSite = new ConcreteWebSite(type);
        webSites.add(webSite);
        return webSite;
    }
}
