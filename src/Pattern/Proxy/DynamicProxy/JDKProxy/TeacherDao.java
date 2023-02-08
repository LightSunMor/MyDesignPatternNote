package Pattern.Proxy.DynamicProxy.JDKProxy;

import Pattern.Proxy.DynamicProxy.JDKProxy.ITeacherDao;

/**
 * @package_name: Pattern.Proxy.StaticProxy
 * @date: 2023/1/27
 * @week: 星期五
 * @message: 实现类
 * @author: morSun
 */
public class TeacherDao implements ITeacherDao {
    
    @Override
    public void teach() {
        System.out.println("java老师正在授课.....");
    }
}
