package pat.international.explosivepopcorn.models;

public class Category {
    private boolean selected;
    private String title;
    private static final String TAG = "Category";

    public Category() {
    }

    public boolean isSelected() {
        return selected;
    }

    public String getTitle() {
        return title;
    }
}
