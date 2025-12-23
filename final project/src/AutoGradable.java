// 中文註解：AutoGradable 介面用於可自動評分的題型，提供 grade 方法用以根據學生答案計分，及取得正確答案的描述。
public interface AutoGradable {
    // 傳入學生的 Answer，回傳此題所得分數
    double grade(Answer answer);
    // 回傳正確答案的字串表示，供顯示或紀錄用
    String getCorrectAnswer();
}
