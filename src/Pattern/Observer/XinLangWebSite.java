package Pattern.Observer;

/**
 * @package_name: Pattern.Observer
 * @date: 2023/2/1
 * @week: 星期三
 * @message: 新浪
 * @author: morSun
 */
public class XinLangWebSite implements Observer{
    private String temperature;
    private String humidity;

    public XinLangWebSite(String temperature, String humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public XinLangWebSite() {
    }

    public void display()
    {
        System.out.println("####新浪网页为您服务，天气情况如下####");
        System.out.println("温度："+temperature);
        System.out.println("湿度："+humidity);
    }

    @Override
    public void update(String temperature,String humidity) {
        //更新
        this.temperature=temperature;
        this.humidity=humidity;
        display();
    }
}
