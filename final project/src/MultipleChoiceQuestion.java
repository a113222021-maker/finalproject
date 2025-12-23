import java.util.Set; // 匯入 Set

public class MultipleChoiceQuestion extends Question implements AutoGradable, PartialCredit { // 類別：多選題
    private final Set<String> correctOptions; // 欄位：正確選項集合（不可變）

    public MultipleChoiceQuestion(String id, String content, double score, Set<String> correctOptions) { // 建構子：設定 id、內容、分數、正確選項
        super(id, content, score); // 呼叫父類建構子
        this.correctOptions = correctOptions; // 指派正確選項
    } // 建構子結束

    @Override
    public double grade(Answer answer) { // 方法：評分入口
        if (!(answer instanceof ChoiceAnswer)) { // 只檢查 instanceof（instanceof 已對 null 返回 false）
            return 0; // 非 ChoiceAnswer 回 0
        } // 條件結束
        return calculatePartialScore(answer); // 使用部分得分邏輯計算分數
    } // 方法結束

    @Override
    public double calculatePartialScore(Answer answer) { // 方法：計算部分得分
        ChoiceAnswer userAnswer = (ChoiceAnswer) answer; // 轉型為 ChoiceAnswer
        Set<String> selected = userAnswer.getSelectedOptions(); // 取得學生所選項目
        if (selected == null || selected.isEmpty()) { // 若未選任何選項
            return 0; // 回 0 分
        } // 條件結束
        int totalCorrect = correctOptions.size(); // 正確選項總數
        double unitScore = score / totalCorrect; // 每個正確選項的單位分數
        double result = 0; // 初始結果
        for (String option : selected) { // 檢查每個被選項目
            if (correctOptions.contains(option)) { // 如果為正確選項
                result += unitScore; // 加上單位分數
            } else { // 否則
                result -= unitScore * 0.5; // 扣除半個單位分數
            } // 條件結束
        } // 迴圈結束
        return Math.max(result, 0); // 最低 0 分
    } // 方法結束

    @Override
    public String getCorrectAnswer() { // 方法：回傳正確選項表示
        return correctOptions.toString(); // 回傳集合字串
    } // 方法結束

    @Override
    public String getPartialCreditRules() { // 方法：回傳部分得分規則說明
        return "每回答對一個選項得 (滿分/N)，回答錯則扣 (滿分/N × 0.5)，最低 0 分"; // 回傳規則字串
    } // 方法結束
} // 類別結束
