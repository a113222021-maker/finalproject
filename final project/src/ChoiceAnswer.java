// 匯入說明：使用 Set  ；檔案：ChoiceAnswer.java
import java.util.Set; // 匯入 Set

public class ChoiceAnswer extends Answer { // 類別開始：ChoiceAnswer 繼承 Answer
    private Set<String> selectedOptions; // 欄位：選到的選項集合

    public ChoiceAnswer(Set<String> selectedOptions) { // 建構子：以選項集合建立
        this.selectedOptions = selectedOptions; // 指派欄位
    } // 建構子結束

    public Set<String> getSelectedOptions() { // 方法：取得選項集合
        return selectedOptions; // 回傳欄位
    } // 方法結束
} // 類別結束
