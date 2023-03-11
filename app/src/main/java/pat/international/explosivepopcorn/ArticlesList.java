package pat.international.explosivepopcorn;

import android.os.Bundle;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import androidx.annotation.Nullable;

import pat.international.explosivepopcorn.adapters.ArticlesRecViewAdapter;
import pat.international.explosivepopcorn.models.ArticleListViewModel;

public class ArticlesList extends Fragment {

    private static final String TAG = "Articles";
    RecyclerView recyclerArticles;
    ArticlesRecViewAdapter adapter;
    View view;
    NavController navController;
    ArticleListViewModel viewModel;
    ImageButton categoriesMenuButton;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ArticleListViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.articles_list, container, false);
        categoriesMenuButton = view.findViewById(R.id.button_categories);
        startRecyclerView(view);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        viewModel.requestListOfArticles();
        viewModel.getListOfArticles().observe(getViewLifecycleOwner(), i->adapter.setArticles(i));
        categoriesMenuButton.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_FirstFragment_to_categoriesList);
        });

    }



    private void startRecyclerView(View view){
        recyclerArticles = view.findViewById(R.id.rec_view_article);
        recyclerArticles.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new ArticlesRecViewAdapter(viewModel,view);
        recyclerArticles.setAdapter(adapter);
    }






}