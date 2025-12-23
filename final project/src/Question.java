public abstract class Question { // 抽象類別：Question
    protected String id; // 欄位：題目 id
    protected String content; // 欄位：題目內容
    protected double score; // 欄位：題目分數

    public Question(String id, String content, double score) { // 建構子：指定 id、內容、分數
        this.id = id; // 指派 id
        this.content = content; // 指派內容
        this.score = score; // 指派分數
    } // 建構子結束

    public double getScore() { // 方法：回傳分數
        return score; // 回傳欄位 score
    } // 方法結束

    public abstract double grade(Answer answer); // 抽象方法：各題型實作評分邏輯
} // 類別結束
