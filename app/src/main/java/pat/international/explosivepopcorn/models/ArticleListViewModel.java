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

public class ArticleListViewModel extends ViewModel {
    private static final String TAG = "Article List";
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    private final MutableLiveData<List<Article>> listOfArticles = new MutableLiveData<>();
    public LiveData<List<Article>> getListOfArticles () {
        return listOfArticles ;
    }
    public void selectListOfStakeHolderTrans(List<Article> input){
        listOfArticles.setValue(input);
    }
    public void reset(){
        listOfArticles .setValue(null);
    }

    public void requestListOfArticles() {
        String urlGetAccountTransactions = "articles";
        Query articleTransQuery = db.collection(urlGetAccountTransactions);
        articleTransQuery.addSnapshotListener((value, e) -> {
            if (e != null) {
                Log.w(TAG, "Listen failed.", e);
                return;
            }
            List<Article> newListStakeHolderTrans = new ArrayList<>();

            if (value != null) {
                for (QueryDocumentSnapshot doc : value) {
                    Article article = doc.toObject(Article.class);
                    newListStakeHolderTrans.add(article);
                }
                selectListOfStakeHolderTrans(newListStakeHolderTrans);
            }
        });
    }
}