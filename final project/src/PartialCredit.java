public interface PartialCredit { // 介面：PartialCredit 用於需要部分得分的題型
    double calculatePartialScore(Answer answer); // 方法：計算部分得分
    String getPartialCreditRules(); // 方法：回傳部分得分規則說明
} // 介面結束

