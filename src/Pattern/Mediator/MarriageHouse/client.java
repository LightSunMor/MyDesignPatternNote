package Pattern.Mediator.MarriageHouse;

/**
 * @package_name: Pattern.Mediator.MarriageHouse
 * @date: 2023/2/2
 * @week: 星期四
 * @message:
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        ConrecteMarriage marriage = new ConrecteMarriage();
        Person 小红 = new Person("小红", 22, Sex.WOMAN, 24, marriage);
        Person 小绿 = new Person("小绿", 21, Sex.WOMAN, 24, marriage);
        Person 小青 = new Person("小青", 23, Sex.WOMAN, 24, marriage);

        Person 许仙 = new Person("许仙", 24, Sex.MAN, 21, marriage);

        许仙.find();
    }
}
