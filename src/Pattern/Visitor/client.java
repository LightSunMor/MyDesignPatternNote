package Pattern.Visitor;

import java.util.ArrayList;

/**
 * @package_name: Pattern.Visitor
 * @date: 2023/1/30
 * @week: 星期一
 * @message: 客户端
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        // 拿到机器人
        Root root = new Root();
        root.action();
        System.out.println("===机器人进行升级===");
        // 创建升级包
        UpdateKit kit = new UpdateKit();
        // 机器人升级
        root.accept(kit);
        root.action();
    }
}
