package pat.international.explosivepopcorn.models;


public class Article {
    private static final String TAG = "Article";
    private String title;
    private String source;
    private String summary;
    private String text;
    private String id;



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

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }
}
