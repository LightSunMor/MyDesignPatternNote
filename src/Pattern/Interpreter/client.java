package Pattern.Interpreter;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @package_name: Pattern.Interpreter
 * @date: 2023/2/4
 * @week: 星期六
 * @message:
 * @author: morSun
 */
public class client {
    public static void main(String[] args) {
        String expStr = getExpStr();
        HashMap<String, Integer> map = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("解释中.....");
        System.out.println("解释完毕，输出答案："+calculator.run(map));
    }

    public static String getExpStr()
    {
        System.out.println("===请输入表达式：");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
        //也可以自己对InputStreamReader封装一层BufferedReader来使用
    }

    public static HashMap<String,Integer> getValue(String str)
    {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (char c : str.toCharArray()) {
            if(c!='+'&&c!='-') //目前只对加减解释
            {
                System.out.println("===请输入"+c+"的值：");
                int val = scanner.nextInt();
                hashMap.put(String.valueOf(c),val);
            }
            //不是值不放入里面
        }
        return hashMap;
    }


}
