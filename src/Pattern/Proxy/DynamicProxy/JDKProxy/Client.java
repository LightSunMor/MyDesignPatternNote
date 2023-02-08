package Pattern.Proxy.DynamicProxy.JDKProxy;

/**
 * @package_name: Pattern.Proxy.DynamicProxy.JDKProxy
 * @date: 2023/1/27
 * @week: 星期五
 * @message:
 * @author: morSun
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        factory.setTeacherDao(new TeacherDao());
        ITeacherDao teacherDao = factory.getProxyInstance();
        teacherDao.teach();
    }
}
