import java.util.Set;

public class FillInBlankQuestion extends Question implements AutoGradable {
    private Set<String> acceptableAnswers;

    public FillInBlankQuestion(String id, String content, double score, Set<String> acceptableAnswers) {
        super(id, content, score);
        this.acceptableAnswers = acceptableAnswers;
    }

    @Override
    public double grade(Answer answer) {
        if (answer == null || !(answer instanceof TextAnswer)) return 0;
        TextAnswer ta = (TextAnswer) answer;
        String user = ta.getText();
        if (user == null) return 0;
        String norm = user.trim();
        for (String acc : acceptableAnswers) {
            if (acc != null && norm.equalsIgnoreCase(acc.trim())) {
                return score;
            }
        }
        return 0;
    }

    @Override
    public String getCorrectAnswer() {
        return acceptableAnswers.toString();
    }
}

