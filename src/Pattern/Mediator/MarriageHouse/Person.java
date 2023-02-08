package Pattern.Mediator.MarriageHouse;

/**
 * @package_name: Pattern.Mediator.MarriageHouse
 * @date: 2023/2/2
 * @week: 星期四
 * @message: 证婚人  (参与者)
 * @author: morSun
 */
// 如果需要对Person划分得更细，就将其设置为abstract
public class Person {
    String name;
    int age;
    Sex sex;
    int requestAge;
    MarriageMediator mediator;

    public Person(String name, int age, Sex sex, int requestAge, MarriageMediator mediator) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.requestAge = requestAge;
        this.mediator = mediator;
        //注册此人
        mediator.register(this);
    }

    public void find()
    {
        mediator.pair(this);
    }
}

enum Sex{
    MAN,WOMAN
}