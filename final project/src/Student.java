// 類別說明：Student 儲存學生的學號與姓名
public class Student {
    // 欄位說明：學號
    private final String id; // 欄位：學號（不可變）
    // 欄位說明：姓名
    private final String name; // 欄位：姓名（不可變）

    // 建構子說明：建立學生需提供 id 與 name
    public Student(String id, String name) { // 建構子：指定 id 與 name
        // 指派學號
        this.id = id; // 指派學號
        // 指派姓名
        this.name = name; // 指派姓名
    } // 建構子結束

    // 方法說明：取得學號
    public String getId() { // 方法：取得學號
        // 回傳 id
        return id; // 回傳 id
    } // 方法結束

    // 方法說明：取得姓名
    public String getName() { // 方法：取得姓名
        // 回傳 name
        return name; // 回傳 name
    } // 方法結束
} // 類別結束
