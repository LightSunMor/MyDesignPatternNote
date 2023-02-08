package Pattern.Prototype.DeepClone;

/**
 * @package_name: Pattern.Prototype.DeepClone
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 客户端
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        Computer computer = new Computer("Thunder",new KeyBoard("狼途"));
        System.out.println(computer.toString());
        //对原始对象computer进行克隆
        Computer clone = (Computer) computer.clone();
        System.out.println(clone.toString());

        //Computer{name='Thunder', keyBoard=KeyBoard{name='狼途',hashCode=1531448569},hashCode=990368553}
        //Computer{name='Thunder', keyBoard=KeyBoard{name='狼途',hashCode=883049899},hashCode=1922154895}
            //达到了深拷贝的效果，键盘的实例不是同一个
    }
}
