package Pattern.Memento;

/**
 * @package_name: Pattern.Memento
 * @date: 2023/2/3
 * @week: 星期五
 * @message:
 * @author: morSun
 */
public class Client {
    public static void main(String[] args) {
        //使用编辑器
        EditorMementoManager manager = new EditorMementoManager();
        OriginalEditor editor = new OriginalEditor();

        editor.changeAdd("l");
        editor.print();
        manager.add(editor.save());

        editor.changeAdd("s");
        editor.print();
        manager.add(editor.save());

        editor.changeAdd("r");
        editor.print();
        manager.add(editor.save());
        editor.changeAdd("d");
        editor.print();


        System.out.println("=====ctrl+z 两次=====");
        //撤销两次
        editor.resume(manager.getLastMemento());
        editor.print();

        editor.resume(manager.getLastMemento());
        editor.print();

    }
}
