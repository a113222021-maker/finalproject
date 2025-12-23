// 中文註解：Exam 代表一份考試，包含標題與題目清單，可新增題目並取得不變的題目列表。
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam {
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Exam(String title) {
        this.title = title;
    }

    // 新增題目到考試
    public void addQuestion(Question q) {
        if (q != null) {
            questions.add(q);
        }
    }

    // 取得題目清單（不可變視圖）
    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public String getTitle() {
        return title;
    }
}
