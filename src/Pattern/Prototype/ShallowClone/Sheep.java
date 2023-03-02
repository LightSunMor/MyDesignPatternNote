package Pattern.Prototype.ShallowClone;

/**
 * @package_name: Pattern.Prototype.DeepClone
 * @date: 2023/1/17
 * @week: 星期二
 * @message: 克隆羊类
 * @author: morSun
 */
public class Sheep implements Cloneable{
    private String name;
    private String color;

    Sheep(String name,String color)
    {
        this.color=color;
        this.name=name;
    }
    // 不提供对外获取属性的入口
    @Override
    protected Object clone(){
        try{
            //使用默认的clone方法，是原生的本地方法   protected native Object clone() throws CloneNotSupportedException;
            return super.clone();
        }catch (CloneNotSupportedException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +"hashCode="+this.hashCode()+'\''+
                '}';
    }
}
