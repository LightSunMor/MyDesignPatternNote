package Pattern.Proxy.DynamicProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @package_name: Pattern.Proxy.DynamicProxy.JDKProxy
 * @date: 2023/1/27
 * @week: 星期五
 * @message: 代理工厂
 * @author: morSun
 */
public class ProxyFactory implements InvocationHandler {
    private ITeacherDao teacherDao;

    public void setTeacherDao(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    // 获取代理对象
    public ITeacherDao getProxyInstance()
    {
        return (ITeacherDao) Proxy.newProxyInstance(teacherDao.getClass().getClassLoader(),teacherDao.getClass().getInterfaces(),this);
    }
    private void log()
    {
        System.out.println("上课铃响了");
    }

    // 执行目标方法，触发方法处理器
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy指定代理对象
        System.out.println("动态生成的代理对象"+proxy.getClass().getName());
        System.out.println("代理工作如下：------");
        log();
        Object res = method.invoke(teacherDao, args);
        return res;
    }
}
