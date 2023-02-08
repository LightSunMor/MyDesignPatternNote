package Pattern.Proxy.StaticProxy;

/**
 * @package_name: Pattern.Proxy.StaticProxy
 * @date: 2023/1/27
 * @week: 星期五
 * @message: 代理类
 * @author: morSun
 */
public class TeacherDaoProxy implements ITeacherDao{
    private ITeacherDao teacherDao;
    public TeacherDaoProxy(ITeacherDao teacherDao)
    {
        this.teacherDao=teacherDao;
    }

    @Override
    public void teach() {
        log();
        teacherDao.teach();
    }
    private void log()
    {
        System.out.println("上课铃响了");
    }
}
