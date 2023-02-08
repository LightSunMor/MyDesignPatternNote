package Pattern.Iterator;

/**
 * @package_name: Pattern.Iterator
 * @date: 2023/1/31
 * @week: 星期二
 * @message: 系
 * @author: morSun
 */
public class Department {
    String name;
    String des;

    public Department() {
    }

    public Department(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
