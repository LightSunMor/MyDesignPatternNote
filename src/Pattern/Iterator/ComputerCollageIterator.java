package Pattern.Iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @package_name: Pattern.Iterator
 * @date: 2023/1/30
 * @week: 星期一
 * @message: 计算机学院 系迭代器
 * @author: morSun
 */
public class ComputerCollageIterator implements Iterator {
    private List<Department> departments;
    public ComputerCollageIterator(List<Department> list)
    {
        this.departments=list;
    }
    Integer position=0;
    Integer removeIndex=0;
    @Override
    public boolean hasNext() {
        if (position>departments.size()-1)
        {
            return false;
        }
        else
            return true;
    }

    @Override
    public Department next() {
        if (hasNext())
        {
            removeIndex=position;
            return departments.get(position++);
        }else
            return null;
    }

    //删除刚才遍历的元素
    @Override
    public void remove() {
        if (removeIndex<departments.size())
        {
            departments.remove(removeIndex);
        }
    }
}
