package pat.international.explosivepopcorn.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pat.international.explosivepopcorn.R;
import pat.international.explosivepopcorn.models.Category;
import pat.international.explosivepopcorn.models.CategoryViewModel;

public class CategoriesRecViewAdapter extends RecyclerView.Adapter<CategoriesRecViewAdapter.ViewHolder>  {

    private final List<Category> categories = new ArrayList<>();
    CategoryViewModel viewModel;

    public CategoriesRecViewAdapter(CategoryViewModel viewModel) {
        this.viewModel= viewModel;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_article,parent,false);
        return new CategoriesRecViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category cat = categories.get(position);
        holder.textHeader.setText(cat.getTitle());

        holder.parent.setOnClickListener(v -> {
                }
        );
    }


    @Override
    public int getItemCount() {
        return categories.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textHeader;
        private ConstraintLayout parent;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            textHeader = itemView.findViewById(R.id.text_tile);
            parent=itemView.findViewById(R.id.category_layout);
        }
    }

    public void setCategories(List<Category> categoriesReceived) {
        categories.clear();
        categories.addAll(categoriesReceived);
        notifyDataSetChanged();
    }
}