package Pattern.Compose;

/**
 * @package_name: Pattern.Compose
 * @date: 2023/1/22
 * @week: 星期日
 * @message: 中国人口普查客户端
 * @author: morSun
 */
public class ChinaPopulationClient {
    public static void main(String[] args) {
        CompositeCity china = new CompositeCity();
        china.add(new DetailCountCity(100000L)); //北京直接知道人口数
        // 举例子

        //重庆市
        CompositeCity ChongQin = new CompositeCity();
        CompositeCity ZhongXian = new CompositeCity();
        ZhongXian.add(new DetailCountCity(10000L)); //忠县-拔山
        ZhongXian.add(new DetailCountCity(8000L)); //忠县-花桥

        ChongQin.add(ZhongXian);
        china.add(ChongQin);

        // 其余城市类似
            //....
        System.out.println("中国总人口总计数："+china.count()+"人");

        //todo 改进:可以将重庆市和忠县以及拔山这样的可以实现为一个类
    }
}
