package pat.international.explosivepopcorn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pat.international.explosivepopcorn.ArticlesListDirections;
import pat.international.explosivepopcorn.R;
import pat.international.explosivepopcorn.models.Article;
import pat.international.explosivepopcorn.models.ArticleListViewModel;

public class ArticlesRecViewAdapter extends RecyclerView.Adapter<ArticlesRecViewAdapter.ViewHolder>  {

    private final List<Article> articles = new ArrayList<>();
    private final View viewFromHostingClass;
    NavController navController;
    ArticleListViewModel viewModel;
    private Context context;
    private final int[] primes = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7};


    public ArticlesRecViewAdapter(ArticleListViewModel viewModel, View viewFromHostingClass, Context context) {
        this.viewFromHostingClass = viewFromHostingClass;
        this.viewModel= viewModel;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        navController = Navigation.findNavController(viewFromHostingClass);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_article,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.textHeader.setText(article.getTitle());
        holder.topic.setText(article.getTopic());
        holder.image.setImageResource(primes[article.retrieveIdImage()]);
        holder.parent.setOnClickListener(v -> {
            ArticlesListDirections.ActionFirstFragmentToArticleView action = ArticlesListDirections.actionFirstFragmentToArticleView(article.getId());
            navController.navigate(action);
        }
        );

    }
    @Override
    public int getItemCount() {
        return articles.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textHeader;
        private ConstraintLayout parent;
        private TextView topic;
        private ImageView image;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            textHeader = itemView.findViewById(R.id.title_card);
            parent=itemView.findViewById(R.id.recView_item_articles);
            topic = itemView.findViewById(R.id.topic_card);
            image = itemView.findViewById(R.id.image_card);
        }
    }

    public void setArticles(List<Article> articlesReceived) {
        articles.clear();
        articles.addAll(articlesReceived);
        notifyDataSetChanged();
    }
}

