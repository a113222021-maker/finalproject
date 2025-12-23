// 中文註解：ChoiceAnswer 表示選擇題（單選或多選）的答案，使用 Set 儲存所選選項。
import java.util.Set;

public class ChoiceAnswer extends Answer {
    private Set<String> selectedOptions;

    public ChoiceAnswer(Set<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public Set<String> getSelectedOptions() {
        return selectedOptions;
    }
}
