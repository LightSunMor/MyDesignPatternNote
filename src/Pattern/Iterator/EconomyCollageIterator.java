package Pattern.Iterator;

import java.util.Iterator;

/**
 * @package_name: Pattern.Iterator
 * @date: 2023/1/31
 * @week: 星期二
 * @message: 经济学院迭代器
 * @author: morSun
 */
public class EconomyCollageIterator implements Iterator {
    private Department[] departments;
    public EconomyCollageIterator(Department[] departments)
    {
        this.departments=departments;
    }
    Integer index=0;

    @Override
    public boolean hasNext() {
       if (index>departments.length-1)
           return false;
       else
           return true;
    }

    @Override
    public Department next() {
        if (hasNext())
            return departments[index++];
        else
            return null;
    }

}
