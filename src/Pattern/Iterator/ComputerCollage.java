package Pattern.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @package_name: Pattern.Iterator
 * @date: 2023/1/31
 * @week: 星期二
 * @message: 计算机学院（聚合类）
 * @author: morSun
 */
public class ComputerCollage implements Collage{
    //管理该院校的对应系
    private List<Department> departments;

    public ComputerCollage()
    {
        departments=new ArrayList<>();
        departments.add(new Department("计科","老牌系"));
        departments.add(new Department("软工","分支系"));
        departments.add(new Department("智科","新盛系"));
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public Iterator getIterator() {
        return new ComputerCollageIterator(departments);
    }
}
