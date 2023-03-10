package Pattern.Proxy.DynamicProxy.CGlibProxy;

/**
 * @package_name: Pattern.Proxy.DynamicProxy.CGlibProxy
 * @date: 2023/1/27
 * @week: ζζδΊ
 * @message:
 * @author: morSun
 */
public class Client {
    public static void main(String[] args) {
        CGlibProxyFactory proxyFactory = new CGlibProxyFactory();
        proxyFactory.setTeacherDao(new TeacherDao());
        TeacherDao instance = proxyFactory.getProxyInstance();
        instance.teach();
    }
}
