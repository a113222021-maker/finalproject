// 類別說明：簡答題，通常需要人工評分
public class ShortAnswerQuestion extends Question {
    // 建構子說明：建立簡答題需提供 id、內容與分數
    public ShortAnswerQuestion(String id, String content, double score) {
        // 呼叫父類建構子設定 id、內容與分數
        super(id, content, score);
    }

    @Override
    // 方法說明：自動評分邏輯（簡答題通常不自動給分）
    public double grade(Answer answer) {
        // 如果答案為 null 或是標示為待人工評分，回傳 0（自動評分視為 0）
        if (answer == null || answer instanceof PendingAnswer) return 0;
        // 若要自動比對文字，可在此實作；目前對非待評分答案仍回傳 0
        return 0;
    }
}
