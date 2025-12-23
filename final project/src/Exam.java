// 中文註解：Exam 代表一份考試，包含標題與題目清單，可新增題目並取得不變的題目列表。
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam {
    private final String title; // 欄位：考試標題（不可變）
    private final List<Question> questions = new ArrayList<>(); // 欄位：題目清單（不可變參考）

    public Exam(String title) { // 建構子：以標題建立考試
        this.title = title; // 指派標題
    } // 建構子結束

    // 新增題目到考試
    public void addQuestion(Question q) {
        if (q != null) { // 若題目非 null
            questions.add(q); // 加入題目
        } // 條件結束
    } // 方法結束

    // 取得題目清單（不可變視圖）
    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions); // 回傳不可修改視圖
    } // 方法結束

    public String getTitle() {
        return title; // 回傳標題
    } // 方法結束
}
