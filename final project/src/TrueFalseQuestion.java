// 類別說明：是非題，支援自動評分
public class TrueFalseQuestion extends Question implements AutoGradable { // 類別：TrueFalseQuestion
    private final boolean correctValue; // 欄位：正確的布林值（不可變）

    public TrueFalseQuestion(String id, String content, double score, boolean correctValue) { // 建構子：設定 id、內容、分數與正確值
        super(id, content, score); // 呼叫父類建構子
        this.correctValue = correctValue; // 指派正確值
    } // 建構子結束

    @Override
    // 方法：評分，使用 pattern-matching for instanceof 解析 ChoiceAnswer
    public double grade(Answer answer) { // grade 方法開始
        if (!(answer instanceof ChoiceAnswer ca)) return 0; // 若不是 ChoiceAnswer（或為 null）回 0，並建立 pattern 變數 ca
        if (ca.getSelectedOptions() == null || ca.getSelectedOptions().isEmpty()) return 0; // 若未選任何選項回 0
        for (String opt : ca.getSelectedOptions()) { // 逐一檢查被選項
            if (opt == null) continue; // 若該選項為 null，跳過
            String normalized = opt.trim().toLowerCase(); // 正規化字串
            boolean val; // 中間變數：解析後的布林值
            if (normalized.equals("true") || normalized.equals("t") || normalized.equals("yes") || normalized.equals("y")) { // 常見 true 形式
                val = true; // 設為 true
            } else if (normalized.equals("false") || normalized.equals("f") || normalized.equals("no") || normalized.equals("n")) { // 常見 false 形式
                val = false; // 設為 false
            } else { // 無法解析的表示法
                continue; // 跳過該選項
            }
            if (val == correctValue) return score; // 若解析後值與答案相符，給滿分
        } // 迴圈結束
        return 0; // 無匹配則回 0
    } // grade 方法結束

    @Override
    // 方法：回傳正確答案的字串表示
    public String getCorrectAnswer() { // getCorrectAnswer 方法開始
        return String.valueOf(correctValue); // 回傳布林值的字串表示
    } // getCorrectAnswer 方法結束
} // 類別結束
