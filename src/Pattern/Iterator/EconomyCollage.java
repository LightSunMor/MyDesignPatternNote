package Pattern.Iterator;

import java.util.Iterator;

/**
 * @package_name: Pattern.Iterator
 * @date: 2023/1/31
 * @week: 星期二
 * @message: 经济学院
 * @author: morSun
 */
public class EconomyCollage implements Collage{
    private Department[] departments;
    public EconomyCollage()
    {
        int i=0;
        departments=new Department[3];
        departments[i++]=new Department("经济系","经济管理");
        departments[i++]=new Department("金融系","金融管理");
        departments[i++]=new Department("银行系","银行管理");
    }


    @Override
    public String getName() {
        return "经济学院";
    }

    @Override
    public Iterator getIterator() {
        return new EconomyCollageIterator(departments);
    }
}
