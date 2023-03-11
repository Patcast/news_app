package pat.international.explosivepopcorn.models;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends ViewModel {
    private static final String TAG = "CategoriesList";
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    private final MutableLiveData<List<Category>> listOfCategories = new MutableLiveData<>();
    public LiveData<List<Category>> getListOfCategories () {
        return listOfCategories ;
    }
    public void selectListOfCategories(List<Category> input){
        listOfCategories.setValue(input);
    }
    public void reset(){
        listOfCategories .setValue(null);
    }

    public void requestListOfCategories() {
        String urlGetAccountTransactions = "articles";
        Query articleTransQuery = db.collection(urlGetAccountTransactions);
        articleTransQuery.addSnapshotListener((value, e) -> {
            if (e != null) {
                Log.w(TAG, "Listen failed.", e);
                return;
            }
            List<Category> newListOfCategories = new ArrayList<>();

            if (value != null) {
                for (QueryDocumentSnapshot doc : value) {
                    Category category = doc.toObject(Category.class);
                    newListOfCategories.add(category);
                }
                selectListOfCategories(newListOfCategories);
            }
        });
    }
}