package Pattern.Decorate;

/**
 * @package_name: Pattern.Decorate
 * @date: 2023/1/20
 * @week: 星期五
 * @message: 抽象产品类，包含价格和描述
 * @author: morSun
 */
public abstract class Drink {
    protected Integer price=0; //默认为0
    protected String des;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    //抽象方法  ： 具体花多少钱，不同子类不同的花费
    public abstract Integer cost();

}
