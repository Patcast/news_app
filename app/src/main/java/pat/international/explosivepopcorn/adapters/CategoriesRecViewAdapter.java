package pat.international.explosivepopcorn.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pat.international.explosivepopcorn.R;
import pat.international.explosivepopcorn.models.Category;
import pat.international.explosivepopcorn.models.CategoryViewModel;

public class CategoriesRecViewAdapter extends RecyclerView.Adapter<CategoriesRecViewAdapter.ViewHolder>  {

    private final List<Category> categories = new ArrayList<>();
    CategoryViewModel viewModel;
    Context context;
    public CategoriesRecViewAdapter(CategoryViewModel viewModel,Context context) {
        this.viewModel= viewModel;
        this.context=context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_category,parent,false);
        return new CategoriesRecViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category cat = categories.get(position);
        holder.textHeader.setText(cat.getTitle());
        if(!cat.isSelected())holder.textHeader.setTextColor(ContextCompat.getColor(context, R.color.white));

        holder.parent.setEnabled(cat.isSelected());
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
            parent=itemView.findViewById(R.id.rec_chosen);
        }
    }

    public void setCategories(List<Category> categoriesReceived) {
        categories.clear();
        categories.addAll(categoriesReceived);
        notifyDataSetChanged();
    }
}