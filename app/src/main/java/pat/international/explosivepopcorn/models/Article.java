package pat.international.explosivepopcorn.models;


public class Article {
    private static final String TAG = "Article";
    private String title;
    private String source;
    private String summary;
    private String author;
    private int date;
    private String id;
    private String dateArticle;
    private String topic;
    private int idImage;

    public void setId(String id) {
        this.id = id;
    }

    public Article() {
        generateImageId();
    }

    private void generateImageId() {
        int min = 0; // Minimum value of range
        int max = 6; // Maximum value of range
        idImage = (int)Math.floor(Math.random() * (max - min + 1) + min);

    }

    public String getTitle() {
        return title;
    }

    public int retrieveIdImage() {
        return idImage;
    }

    public String getSource() {
        return source;
    }

    public String getSummary() {
        return summary;
    }

    public String getAuthor() {
        return author;
    }

    public int getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getDateArticle() {
        return dateArticle;
    }

    public String getTopic() {
        return topic;
    }
}
