package Pattern.Proxy.StaticProxy;

/**
 * @package_name: Pattern.Proxy.StaticProxy
 * @date: 2023/1/27
 * @week: 星期五
 * @message: 客户端
 * @author: morSun
 */
public class Client {
    public static void main(String[] args) {
        TeacherDaoProxy proxy = new TeacherDaoProxy(new TeacherDao());
        proxy.teach();
    }
}
