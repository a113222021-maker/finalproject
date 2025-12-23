public class ShortAnswerQuestion extends Question {
    public ShortAnswerQuestion(String id, String content, double score) {
        super(id, content, score);
    }

    @Override
    public double grade(Answer answer) {
        // Short answers require manual grading; if PendingAnswer provided, treat as 0 for auto grading
        if (answer == null || answer instanceof PendingAnswer) return 0;
        // If student provided a text answer and we want to auto-grade basic matches, we could implement it,
        // but for now treat any non-pending as 0 (requires manual review).
        return 0;
    }
}

