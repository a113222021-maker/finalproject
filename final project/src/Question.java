public abstract class Question {
    protected String id;
    protected String content;
    protected double score;

    public Question(String id, String content, double score) {
        this.id = id;
        this.content = content;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    // 所有題目一定要能評分
    public abstract double grade(Answer answer);
}

