package Pattern.Prototype.DeepClone;

import java.io.*;

/**
 * @package_name: Pattern.Prototype.DeepClone
 * @date: 2023/1/18
 * @week: 星期三
 * @message: 电脑原始类
 * @author: morSun
 */
public class Computer implements Cloneable, Serializable {
    private String name;
    private KeyBoard keyBoard;

    public Computer(String name, KeyBoard keyBoard) {
        this.name = name;
        this.keyBoard = keyBoard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", keyBoard=" + keyBoard +
                ",hashCode="+this.hashCode()+
                '}';
    }

    // 存在引用类型 KeyBoard，使用浅拷贝的话，这个引用类型不会克隆
    //方式1 重写clone
//    @Override
//    protected Object clone()  {
//        // 先调用默认的克隆方法，将该对象的非引用类型对象拷贝下来
//        Computer clone = null;
//        try {
//            clone = (Computer) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        //再单独处理引用类型的变量，再次进行一个拷贝
//        clone.keyBoard= (KeyBoard) keyBoard.clone();
//        return clone;
//    }

    // ❗❗❤推荐写法：序列化和反序列化（更方便，以后Computer发生改变，这个写法不用改变）

    @Override
    protected Object clone(){
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        ByteArrayInputStream bis=null; //对象最后要通过Byte形式传输，而不是Object
        ByteArrayOutputStream bos=null;
        try {
            //序列化 （不写入文件中，只是放在数据流管道里）
            bos=new ByteArrayOutputStream();
            oos= new ObjectOutputStream(bos); // 这个类的无参构造对象是protect修饰，于是只能调用有参数的
            oos.writeObject(this);

           //反序列化
            bis=new ByteArrayInputStream(bos.toByteArray()); // public ByteArrayInputStream(byte buf[], int offset, int length)
            ois=new ObjectInputStream(bis);
            Computer readObject = (Computer) ois.readObject();

            return readObject;

        } catch (Exception e) {
            e.printStackTrace();
            // 关闭流
        } finally {
            try {
                oos.close();
                ois.close();
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
