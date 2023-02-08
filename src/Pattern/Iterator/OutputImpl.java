package Pattern.Iterator;

import org.apache.commons.beanutils.ConvertUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @package_name: Pattern.Iterator
 * @date: 2023/1/31
 * @week: 星期二
 * @message: 展示学院 信息
 * @author: morSun
 */
public class OutputImpl {
    private List<Collage> collageList=new ArrayList<>();
    OutputImpl()
    {
        collageList.add(new ComputerCollage());

        //新修改
        collageList.add(new EconomyCollage());
    }

   public void printMsg()
   {
       for (Collage collage : collageList) {
           System.out.println("#### "+collage.getName()+" ####");
           Iterator iterator = collage.getIterator();
           while (iterator.hasNext())
           {
               Department next = (Department) iterator.next(); // ！！！！如果这里两个学院下的管理的元素不是同一种，就不能写在一起了

               System.out.println(next.getName()+"---"+next.getDes());
           }
       }
   }

}
