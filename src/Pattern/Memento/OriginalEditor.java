package Pattern.Memento;

/**
 * @package_name: Pattern.Memento
 * @date: 2023/2/3
 * @week: 星期五
 * @message: 编辑器
 * @author: morSun
 */
public class OriginalEditor {
    private String content="";

    public OriginalEditor(String content) {
        this.content = content;
    }

    public OriginalEditor() {
    }

    public void changeAdd(String msg)
    {
        this.content+=msg;
    }
    //执行撤销动作
    public void resume(EditorMemento memento)
    {
        content=memento.getContent();
    }
    public void print()
    {
        System.out.println(content);
    }
    //保存副本
    public EditorMemento save()
    {
        return  new EditorMemento(content);
    }
}
