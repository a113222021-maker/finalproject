public class TrueFalseQuestion extends Question implements AutoGradable {
    private boolean correctValue;

    public TrueFalseQuestion(String id, String content, double score, boolean correctValue) {
        super(id, content, score);
        this.correctValue = correctValue;
    }

    @Override
    public double grade(Answer answer) {
        if (answer == null || !(answer instanceof ChoiceAnswer)) return 0;
        ChoiceAnswer ca = (ChoiceAnswer) answer;
        if (ca.getSelectedOptions() == null || ca.getSelectedOptions().isEmpty()) return 0;
        for (String opt : ca.getSelectedOptions()) {
            if (opt == null) continue;
            String normalized = opt.trim().toLowerCase();
            boolean val;
            if (normalized.equals("true") || normalized.equals("t") || normalized.equals("yes") || normalized.equals("y")) {
                val = true;
            } else if (normalized.equals("false") || normalized.equals("f") || normalized.equals("no") || normalized.equals("n")) {
                val = false;
            } else {
                continue;
            }
            if (val == correctValue) return score;
        }
        return 0;
    }

    @Override
    public String getCorrectAnswer() {
        return String.valueOf(correctValue);
    }
}

