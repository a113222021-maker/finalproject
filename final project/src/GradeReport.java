public class GradeReport { // 類別開始：GradeReport
    private final Student student; // 欄位：學生（不可變）
    private final double totalScore; // 欄位：總分（不可變）

    public GradeReport(Student student, double totalScore) { // 建構子
        this.student = student; // 指派學生
        this.totalScore = totalScore; // 指派分數
    } // 建構子結束

    public String getSummary() { // 方法：回傳摘要
        return "Report for " + student.getName() + ": total score = " + totalScore; // 包含學生姓名與總分
    } // 方法結束
} // 類別結束
