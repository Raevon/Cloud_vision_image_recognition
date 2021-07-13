package Models;

public class Labels {

    private String mid;
    private String description;
    private double score;
    private double topicality;

    public Labels() {

    }

    public Labels(String mid, String description, double score, double topicality) {
        this.mid = mid;
        this.description = description;
        this.score = score;
        this.topicality = topicality;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getTopicality() {
        return topicality;
    }

    public void setTopicality(double topicality) {
        this.topicality = topicality;
    }

    @Override
    public String toString() {
        return "Labels{" +
                "mid='" + mid + '\'' +
                ", description='" + description + '\'' +
                ", score='" + score + '\'' +
                ", topicality='" + topicality + '\'' +
                '}';
    }
}
