package Pattern.Observer;

/**
 * @package_name: Pattern.Observer
 * @date: 2023/2/1
 * @week: 星期三
 * @message: 客户端
 * @author: morSun
 */
public class Client {
    public static void main(String[] args) {
        WeatherMsg weatherMsg = new WeatherMsg();
        weatherMsg.setTemperature("20℃");
        weatherMsg.setHumidity("20%");

        BaiDuWebSite baiDuWebSite = new BaiDuWebSite();
        XinLangWebSite xinLangWebSite=new XinLangWebSite();

        weatherMsg.registerObserver(baiDuWebSite);
        weatherMsg.registerObserver(xinLangWebSite);

        weatherMsg.notifyObserver();

        System.out.println("！！！ 气象台提醒各观察者，信息更新了");
        weatherMsg.setHumidity("30%");
        weatherMsg.setTemperature("17℃");

        weatherMsg.notifyObserver();
    }
}
