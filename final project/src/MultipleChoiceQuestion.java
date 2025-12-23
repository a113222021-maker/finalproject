import java.util.Set;

public class MultipleChoiceQuestion extends Question
        implements AutoGradable, PartialCredit {

    private Set<String> correctOptions;

    public MultipleChoiceQuestion(String id, String content,
                                  double score, Set<String> correctOptions) {
        super(id, content, score);
        this.correctOptions = correctOptions;
    }
    @Override
    public double grade(Answer answer) {
        if (answer == null || !(answer instanceof ChoiceAnswer)) {
            return 0;
        }
        return calculatePartialScore(answer);
    }
    @Override
    public double calculatePartialScore(Answer answer) {
        ChoiceAnswer userAnswer = (ChoiceAnswer) answer;
        Set<String> selected = userAnswer.getSelectedOptions();

        if (selected == null || selected.isEmpty()) {
            return 0;
        }

        int totalCorrect = correctOptions.size();
        double unitScore = score / totalCorrect;
        double result = 0;

        for (String option : selected) {
            if (correctOptions.contains(option)) {
                result += unitScore;
            } else {
                result -= unitScore * 0.5;
            }
        }

        return Math.max(result, 0);
    }
    @Override
    public String getCorrectAnswer() {
        return correctOptions.toString();
    }

    @Override
    public String getPartialCreditRules() {
        return "每答對一個選項得 (滿分/N)，答錯扣 (滿分/N × 0.5)，最低 0 分";
    }
}
