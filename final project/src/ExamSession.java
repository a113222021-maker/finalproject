// 中文註解：ExamSession 代表一位學生的考試時段，負責接收答案、計算總分與取得學生資訊。
import java.util.HashMap;
import java.util.Map;

public class ExamSession {
    private Exam exam;
    private Student student;
    private Map<Question, Answer> answers = new HashMap<>();

    public ExamSession(Exam exam, Student student) {
        this.exam = exam;
        this.student = student;
    }

    // 提交某題的答案（會儲存或覆寫先前送出的答案）
    public void submitAnswer(Question q, Answer a) {
        if (q != null) {
            answers.put(q, a);
        }
    }

    // 計算整份考卷的總分，對於無法評分的題目或評分例外，視為 0
    public double calculateScore() {
        double total = 0;
        for (Question q : exam.getQuestions()) {
            Answer a = answers.get(q);
            try {
                total += q.grade(a);
            } catch (Exception e) {
                // 若評分程序發生例外，為了健壯性視為 0 分
            }
        }
        return total;
    }

    // 取得本次考試對應的學生物件
    public Student getStudent() {
        return student;
    }
}
