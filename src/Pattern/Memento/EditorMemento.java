package Pattern.Memento;

/**
 * @package_name: Pattern.Memento
 * @date: 2023/2/3
 * @week: 星期五
 * @message: 编辑器内容备份
 * @author: morSun
 */
public class EditorMemento {
    private String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


}
