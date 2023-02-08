package Pattern.Memento;

import java.util.Stack;

/**
 * @package_name: Pattern.Memento
 * @date: 2023/2/3
 * @week: 星期五
 * @message: 编辑器备份管理器
 * @author: morSun
 */
public class EditorMementoManager{
    Stack<EditorMemento> stack;
    EditorMementoManager()
    {
        stack=new Stack<>();

    }
    public void add(EditorMemento memento)
    {
        stack.push(memento);
    }
    public EditorMemento getLastMemento()
    {
        return stack.pop();
    }
}
