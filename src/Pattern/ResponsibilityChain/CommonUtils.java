package Pattern.ResponsibilityChain;

import java.util.ArrayList;
import java.util.List;

/**
 * @package_name: Pattern.ResponsibilityChain
 * @date: 2023/2/7
 * @week: 星期二
 * @message: 责任链整合
 * @author: morSun
 */
public class CommonUtils {
    List<Handler> handlerList=new ArrayList<>();
    public CommonUtils()
    {
        DepartmentActor dactor = new DepartmentActor("主任");
        ColleageActor cactor = new ColleageActor("院长");
        SchoolMasterActor schoolMasterActor = new SchoolMasterActor("校长");
        dactor.setNextHandler(cactor);
        cactor.setNextHandler(schoolMasterActor);
        schoolMasterActor.setNextHandler(dactor);
        handlerList.add(dactor);
        handlerList.add(cactor);
        handlerList.add(schoolMasterActor);
    }


    void processRequest(MoneyRequest request)
    {
        Handler handler = handlerList.get(0);
        handler.processRequest(request);
    }
}
