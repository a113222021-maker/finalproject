public class GradeReport {
    private Student student;
    private double totalScore;

    public GradeReport(Student student, double totalScore) {
        this.student = student;
        this.totalScore = totalScore;
    }

    public String getSummary() {
        return "Report for " + student.getName() + ": total score = " + totalScore;
    }
}

