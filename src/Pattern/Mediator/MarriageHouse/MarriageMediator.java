package Pattern.Mediator.MarriageHouse;

/**
 * @package_name: Pattern.Mediator.MarriageHouse
 * @date: 2023/2/2
 * @week: 星期四
 * @message: 婚姻中介所（中介者接口）
 * @author: morSun
 */
public interface MarriageMediator {
    void register(Person person);
    void pair(Person person);
}
