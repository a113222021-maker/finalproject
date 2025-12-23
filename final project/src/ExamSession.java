// 中文註解：ExamSession 代表一位學生的考試時段，負責接收答案、計算總分與取得學生資訊。
import java.util.HashMap; // 匯入 HashMap
import java.util.Map; // 匯入 Map

public class ExamSession { // 類別開始：ExamSession
    private final Exam exam; // 欄位：考試物件（不可變）
    private final Student student; // 欄位：學生物件（不可變）
    private final Map<Question, Answer> answers = new HashMap<>(); // 欄位：題目到答案的映射（不可變參考）

    public ExamSession(Exam exam, Student student) { // 建構子：需要考試與學生
        this.exam = exam; // 指派考試
        this.student = student; // 指派學生
    } // 建構子結束

    // 提交某題的答案（會儲存或覆寫先前送出的答案）
    public void submitAnswer(Question q, Answer a) { // 方法：提交某題答案
        if (q != null) { // 若題目非 null
            answers.put(q, a); // 儲存或覆寫答案
        } // 條件結束
    } // 方法結束

    // 計算整份考卷的總分，對於無法評分的題目或評分例外，視為 0
    public double calculateScore() { // 方法：計算總分
        double total = 0; // 初始化總分
        for (Question q : exam.getQuestions()) { // 逐題計算
            Answer a = answers.get(q); // 取得該題答案
            try { // 嘗試評分，若失敗則跳過
                total += q.grade(a); // 使用題目的 grade 方法累加分數
            } catch (Exception e) { // 捕捉任何例外
                // 若評分發生例外，當作該題 0 分（保護性處理）
            } // catch 結束
        } // 迴圈結束
        return total; // 回傳總分
    } // 方法結束

    // 取得本次考試對應的學生物件
    public Student getStudent() { // 方法：取得學生
        return student; // 回傳學生
    } // 方法結束
} // 類別結束
