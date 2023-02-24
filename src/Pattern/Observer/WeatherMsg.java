package Pattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @package_name: Pattern.Observer
 * @date: 2023/2/1
 * @week: 星期三
 * @message: 天气信息
 * @author: morSun
 */
public class WeatherMsg implements Subject{

    private String temperature;// 温度
    private String humidity;// 湿度
    private List<Observer> observerList; //订阅者列表

   public WeatherMsg()
   {
       observerList=new ArrayList<>();
   }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void remove(Observer observer) {
       if (observerList.contains(observer))
       {
           observerList.remove(observer);
       }
    }

    //提醒所有观察者更新
    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(temperature,humidity);
        }
    }
}
