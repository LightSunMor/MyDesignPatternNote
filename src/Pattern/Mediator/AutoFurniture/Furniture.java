package Pattern.Mediator.AutoFurniture;

/**
 * @package_name: Pattern.Mediator
 * @date: 2023/2/1
 * @week: 星期三
 * @message: 家具抽象方法
 * @author: morSun
 */
public abstract class Furniture {
    private Mediator mediator;
    protected String name;

    Furniture(Mediator mediator,String name)
    {
        this.mediator=mediator;
        this.name=name;
        //在构建的时候，直接放入中介者
        mediator.setFurniture(this);
    }

        Mediator getMediator()
        {
            return this.mediator;
        }
        protected abstract void sendMsg(String tag);
}
