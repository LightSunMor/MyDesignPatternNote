package Pattern.Observer;

/**
 * @package_name: Pattern.Observer
 * @date: 2023/2/1
 * @week: 星期三
 * @message: 主题接口
 * @author: morSun
 */
public interface Subject {
    void registerObserver(Observer o);

    void remove(Observer observer);
    void notifyObserver();
}
