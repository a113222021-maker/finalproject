public class SingleChoiceQuestion extends Question implements AutoGradable {
    private String correctOption;

    public SingleChoiceQuestion(String id, String content, double score, String correctOption) {
        super(id, content, score);
        this.correctOption = correctOption;
    }

    @Override
    public double grade(Answer answer) {
        if (answer == null || !(answer instanceof ChoiceAnswer)) {
            return 0;
        }
        ChoiceAnswer ca = (ChoiceAnswer) answer;
        if (ca.getSelectedOptions() == null || ca.getSelectedOptions().isEmpty()) return 0;
        // consider correct if any selected option equals correctOption (case-insensitive, trimmed)
        for (String opt : ca.getSelectedOptions()) {
            if (opt != null && opt.trim().equalsIgnoreCase(correctOption.trim())) {
                return score;
            }
        }
        return 0;
    }

    @Override
    public String getCorrectAnswer() {
        return correctOption;
    }
}

