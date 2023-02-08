package Pattern.Prototype.ShallowClone;

/**
 * @package_name: Pattern.Prototype.ShallowClone
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 客户端
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("肖恩", "白色");
        // sheep是原始对象，现要根据它生成一个克隆对象
        Sheep cloneSheep = (Sheep) sheep.clone();

        System.out.println(sheep.toString());
        System.out.println(cloneSheep.toString());

        //{name='肖恩', color='白色'hashCode=1324119927'}
        //{name='肖恩', color='白色'hashCode=1072408673'}
        // 可以看出来，是真实的克隆出了一个对象，属性和之前的完全一样

    }
}
