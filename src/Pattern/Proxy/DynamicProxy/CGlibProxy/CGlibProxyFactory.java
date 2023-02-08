package Pattern.Proxy.DynamicProxy.CGlibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @package_name: Pattern.Proxy.DynamicProxy.CGlibProxy
 * @date: 2023/1/27
 * @week: 星期五
 * @message: cglib动态代理
 * @author: morSun
 */
public class CGlibProxyFactory implements MethodInterceptor {
    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    //cglib的创建代理对象和jdk不一样
    public TeacherDao getProxyInstance()
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(teacherDao.getClass());
        enhancer.setCallback(this);
        return (TeacherDao) enhancer.create();
    }

    private void log()
    {
        System.out.println("上课铃响了");
    }

    //方法调用处理器
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("o对象是="+o.getClass().getName());
        System.out.println("methodProxy="+methodProxy.getSuperName());
        log();
        Object res = method.invoke(teacherDao, args);

        return res;
    }
}
