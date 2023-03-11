package pat.international.explosivepopcorn.models;

import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;

public class Category {
    private boolean selected;
    private String title;
    private String id;
    private static final String TAG = "Category";

    public Category() {
    }

    public boolean isSelected() {
        return selected;
    }

    public String getTitle() {
        return title;
    }
    public  void updateCategory(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        setSelected();
        String urlNewTransactions = "categories";
        db.collection(urlNewTransactions).document(id)
                .set(this)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully written!"))
                .addOnFailureListener(e -> Log.w(TAG, "Error writing document", e));
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSelected() {
        this.selected = !selected;
    }
}
