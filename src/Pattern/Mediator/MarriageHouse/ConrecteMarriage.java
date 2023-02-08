package Pattern.Mediator.MarriageHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * @package_name: Pattern.Mediator.MarriageHouse
 * @date: 2023/2/2
 * @week: 星期四
 * @message:
 * @author: morSun
 */
public class ConrecteMarriage implements MarriageMediator{
    List<Person> personList;
    ConrecteMarriage ()
    {
        personList=new ArrayList<>();
    }


    @Override
    public void register(Person person) {
        personList.add(person);
    }

    @Override
    public void pair(Person person) {
        for (Person pa : personList) {
            if (pa.age==person.requestAge&&person.sex!=pa.sex)
            {
                System.out.println("匹配"+person.name+"和"+pa.name+"成功");
            }
        }
    }
}
