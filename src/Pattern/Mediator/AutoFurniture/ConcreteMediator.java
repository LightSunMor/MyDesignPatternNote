package Pattern.Mediator.AutoFurniture;

import java.util.ArrayList;
import java.util.List;

/**
 * @package_name: Pattern.Mediator
 * @date: 2023/2/2
 * @week: 星期四
 * @message: 中介者实现类
 * @author: morSun
 */
public class ConcreteMediator implements Mediator{
    private List<Furniture> furnitureList;

    ConcreteMediator()
    {
        furnitureList=new ArrayList<>();
    }

    public void setFurniture(Furniture furniture)
    {
        furnitureList.add(furniture);
    }

    void error(Furniture furniture,String tag)
    {
        String name = furniture.getClass().getSimpleName();
        System.out.println("----任务执行顺序异常，中断此次"+name+"的"+tag+"请求----");
    }

    @Override
    public void dealWork(Furniture furniture, String tag) {
        //如果是电视机发来的请求
        if (furniture instanceof TV)
        {
            if (tag=="start")
            {
                ((TV) furniture).prepare();
                for (Furniture furniture1 : furnitureList) {
                    if (furniture1 instanceof CoffeeMachine)
                    {
                        ((CoffeeMachine) furniture1).open();
                    }
                }
            }else if (tag=="end")
            {
                ((TV) furniture).close();
            }else if (tag=="pause")
            {
                ((TV) furniture).pause();
            }else if (tag=="back")
            {
                ((TV) furniture).play();
            }else if (tag=="play")
            {
                ((TV) furniture).play();
                for (Furniture furniture1 : furnitureList) {
                    if (furniture1 instanceof CoffeeMachine)
                    {
                        ((CoffeeMachine) furniture1).stop();
                    }
                }
            }
            else {
                error(furniture,tag);
            }
        }
        //如果是咖啡关闭指令
        if (furniture instanceof CoffeeMachine)
        {
            if (tag=="end")
            {
                ((CoffeeMachine) furniture).stop();
                for (Furniture furniture1 : furnitureList) {
                    if (furniture1 instanceof TV)
                    {
                        ((TV) furniture1).play();
                    }
                }
            }else {
                error(furniture,tag);
            }
        }
    }
}
