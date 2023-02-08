package Pattern.Mediator.AutoFurniture;

/**
 * @package_name: Pattern.Mediator
 * @date: 2023/2/1
 * @week: 星期三
 * @message: 中介者接口
 * @author: morSun
 */
public interface Mediator {
    void dealWork(Furniture furniture,String tag);
    void setFurniture(Furniture furniture);
}
