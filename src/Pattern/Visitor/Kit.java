package Pattern.Visitor;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/29
 * @week: 星期日
 * @message: 工具包
 * @author: morSun
 */
// 只做升级操作，不做功能执行操作
public interface Kit {
    // 工具包要知道硬件数据结构可访问的元素有那些，并提供响应的方法
    void visit(Disk disk);
    void visit(CPU cpu);
}
