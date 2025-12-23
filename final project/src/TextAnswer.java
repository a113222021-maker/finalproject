// 類別說明：TextAnswer 表示文字型答案
public class TextAnswer extends Answer {
    // 欄位說明：答案文字內容
    private final String text; // 欄位：答案文字內容（不可變）

    // 建構子說明：用文字建立 TextAnswer
    public TextAnswer(String text) {
        // 指派文字
        this.text = text; // 指派文字
    } // 建構子結束

    // 方法說明：取得文字內容
    public String getText() {
        // 回傳文字欄位
        return text; // 回傳文字欄位
    } // 方法結束
} // 類別結束
