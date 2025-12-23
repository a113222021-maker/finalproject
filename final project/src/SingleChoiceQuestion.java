// 類別說明：單選題，支援自動評分
public class SingleChoiceQuestion extends Question implements AutoGradable {
    // 欄位說明：正確選項字串
    private final String correctOption;

    // 建構子說明：建立單選題並指定正確選項
    public SingleChoiceQuestion(String id, String content, double score, String correctOption) {
        // 呼叫父類建構子設定 id、內容與分數
        super(id, content, score);
        // 指派正確選項
        this.correctOption = correctOption;
    }

    @Override
    // 方法說明：評分，若學生所選包含正確選項則給滿分
    public double grade(Answer answer) {
        // 使用 pattern matching for instanceof，若不是 ChoiceAnswer 則回 0
        if (!(answer instanceof ChoiceAnswer ca)) {
            return 0;
        }
        // 直接使用 pattern 變數 ca
        if (ca.getSelectedOptions() == null || ca.getSelectedOptions().isEmpty()) return 0; // 若未選任何選項，回 0
        // 檢查每個被選項是否與正確選項相等（不分大小寫、去空白）
        for (String opt : ca.getSelectedOptions()) {
            // 若匹配，回傳題目分數
            if (opt != null && opt.trim().equalsIgnoreCase(correctOption.trim())) {
                return score;
            }
        }
        // 若無匹配，回傳 0
        return 0;
    }

    @Override
    // 方法說明：回傳正確答案字串
    public String getCorrectAnswer() {
        // 回傳正確選項
        return correctOption;
    }
}
