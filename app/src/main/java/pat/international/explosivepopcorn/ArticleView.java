package pat.international.explosivepopcorn;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;



import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import pat.international.explosivepopcorn.models.Article;
import pat.international.explosivepopcorn.models.ArticleListViewModel;


public class ArticleView extends Fragment  {

    ArticleListViewModel viewModel;
    View view;
    Article article;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ArticleListViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.articles_list, container, false);

        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        article= viewModel.getSelectedArticle(null);

    }





}