package pat.international.explosivepopcorn.models;

import com.google.firebase.firestore.FirebaseFirestore;

public class Article {
    private static final String TAG = "Article";
    private String title;
    private String source;
    private String summary;
    private String text;
    private String id;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

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
