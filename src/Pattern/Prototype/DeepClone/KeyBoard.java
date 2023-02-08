package Pattern.Prototype.DeepClone;

import java.io.Serializable;

/**
 * @package_name: Pattern.Prototype.DeepClone
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 键盘原始类
 * @author: morSun
 */
public class KeyBoard implements Cloneable, Serializable {
    String name;

    @Override
    public String toString() {
        return "KeyBoard{" +
                "name='" + name + '\'' +
                ",hashCode="+this.hashCode()+
                '}';
    }

    public KeyBoard(String name) {
        this.name = name;
    }

    // 不提供对外获取属性的入口

    // 由于没有引用数据类型，键盘类可以直接使用浅拷贝
    @Override
    protected Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
