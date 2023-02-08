package Pattern.Observer;

/**
 * @package_name: Pattern.Observer
 * @date: 2023/2/1
 * @week: 星期三
 * @message: 百度页面
 * @author: morSun
 */
public class BaiDuWebSite implements Observer{
    private String temperature;
    private String humidity;

    public BaiDuWebSite(String temperature, String humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public BaiDuWebSite() {
    }

    public void display()
   {
       System.out.println("====百度网页为您服务，天气情况如下====");
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
