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

    public void setId(String id) {
        this.id = id;
    }

    public Article() {
    }

    public String getTitle() {
        return title;
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

    public String getDateArticle() {
        return dateArticle;
    }

    public String getTopic() {
        return topic;
    }

    public String getId() {
        return id;
    }
}
