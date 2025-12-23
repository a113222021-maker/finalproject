import java.util.Set; // 匯入 Set

public class FillInBlankQuestion extends Question implements AutoGradable { // 類別：填空題，實作 AutoGradable
    private Set<String> acceptableAnswers; // 欄位：可接受答案集合

    public FillInBlankQuestion(String id, String content, double score, Set<String> acceptableAnswers) { // 建構子
        super(id, content, score); // 呼叫父類建構子
        this.acceptableAnswers = acceptableAnswers; // 指派可接受答案
    } // 建構子結束

    @Override
    public double grade(Answer answer) { // 方法：評分
        if (answer == null || !(answer instanceof TextAnswer)) return 0; // 若不是文字答案或為 null 回 0
        TextAnswer ta = (TextAnswer) answer; // 轉型為 TextAnswer
        String user = ta.getText(); // 取得使用者文字
        if (user == null) return 0; // 若為 null 回 0
        String norm = user.trim(); // 去除前後空白
        for (String acc : acceptableAnswers) { // 遍歷可接受答案
            if (acc != null && norm.equalsIgnoreCase(acc.trim())) { // 如匹配（不分大小寫）
                return score; // 回傳滿分
            } // 條件結束
        } // 迴圈結束
        return 0; // 無匹配回 0
    } // 方法結束

    @Override
    public String getCorrectAnswer() { // 方法：取得正確答案表示
        return acceptableAnswers.toString(); // 回傳集合字串表示
    } // 方法結束
} // 類別結束
