package pat.international.explosivepopcorn;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pat.international.explosivepopcorn.adapters.ArticlesRecViewAdapter;
import pat.international.explosivepopcorn.models.Article;
import pat.international.explosivepopcorn.models.ArticleListViewModel;

public class ArticlesList extends Fragment {

    private static final String TAG = "Articles";
    RecyclerView recyclerArticles;
    ArticlesRecViewAdapter adapter;
    ArrayList<Article> articlesList = new ArrayList<>();
    View view;
    NavController navController;
    ArticleListViewModel viewModel;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ArticleListViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.articles_list, container, false);
        startRecyclerView(view);
        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        viewModel.requestListOfArticles();
        viewModel.getListOfArticles().observe(getViewLifecycleOwner(), i->adapter.setArticles(i));

    }



    private void startRecyclerView(View view){
        recyclerArticles = view.findViewById(R.id.rec_view_article);
        recyclerArticles.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new ArticlesRecViewAdapter(viewModel,view);
        recyclerArticles.setAdapter(adapter);
    }






}