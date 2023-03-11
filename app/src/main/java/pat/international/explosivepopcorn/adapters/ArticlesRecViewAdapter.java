package pat.international.explosivepopcorn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pat.international.explosivepopcorn.R;
import pat.international.explosivepopcorn.models.Article;
import pat.international.explosivepopcorn.models.ArticleListViewModel;

public class ArticlesRecViewAdapter extends RecyclerView.Adapter<ArticlesRecViewAdapter.ViewHolder>  {

    private final List<Article> articles = new ArrayList<>();
    private final View viewFromHostingClass;
    NavController navController;
    ArticleListViewModel viewModel;

    public ArticlesRecViewAdapter(ArticleListViewModel viewModel,View viewFromHostingClass) {
        this.viewFromHostingClass = viewFromHostingClass;
        this.viewModel= viewModel;
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

        holder.parent.setOnClickListener(v -> {
                    //navController.navigate(R.id.action_accounts_to_allTransactions2);
                }
        );

    }
    @Override
    public int getItemCount() {
        return articles.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textHeader;
        private TextView textSummary;
        private ConstraintLayout parent;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            textHeader = itemView.findViewById(R.id.title_card);
            parent=itemView.findViewById(R.id.recView_item_articles);
        }
    }

    public void setArticles(List<Article> articlesReceived) {
        articles.clear();
        articles.addAll(articlesReceived);
        notifyDataSetChanged();
    }
}

