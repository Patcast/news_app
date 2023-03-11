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
import android.widget.ImageView;
import android.widget.TextView;

import pat.international.explosivepopcorn.models.Article;
import pat.international.explosivepopcorn.models.ArticleListViewModel;


public class ArticleView extends Fragment  {

    ArticleListViewModel viewModel;
    View view;
    Article article;
    TextView titleTxt;
    TextView topicTxt;
    TextView SummaryTxt;
    TextView AuthorTxt;
    TextView SourceTxt;
    ImageView image;
    private final int[] primes = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7};

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ArticleListViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_article_view, container, false);

        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArticleViewArgs args = ArticleViewArgs.fromBundle(getArguments());
        article= viewModel.getSelectedArticle(args.getId());
        titleTxt = view.findViewById(R.id.textTitle);
        topicTxt = view.findViewById(R.id.textTopic);
        SummaryTxt = view.findViewById(R.id.textSummary);
        AuthorTxt = view.findViewById(R.id.textAuthor);
        SourceTxt = view.findViewById(R.id.textSource);
        image = view.findViewById(R.id.image_card);


        fillData();
    }

    private void fillData() {

        titleTxt.setText(article.getTitle());
        topicTxt.setText(article.getTopic());
        SummaryTxt.setText(article.getSummary());
        AuthorTxt.setText(article.getAuthor());
        SourceTxt.setText(article.getSource());
        image.setImageResource(primes[article.retrieveIdImage()]);

    }


}