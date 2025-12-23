// 中文註解：AutoGradable 介面用於可自動評分的題型，提供 grade 方法用以根據學生答案計分，及取得正確答案的描述。  // 檔案說明
public interface AutoGradable { // 介面開始
    // 傳入學生的 Answer，回傳此題所得分數  // 方法說明
    double grade(Answer answer); // grade 方法宣告
    // 回傳正確答案的字串表示，供顯示或紀錄用  // 方法說明
    String getCorrectAnswer(); // getCorrectAnswer 方法宣告
} // 介面結束

