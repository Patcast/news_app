package pat.international.explosivepopcorn;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pat.international.explosivepopcorn.adapters.CategoriesRecViewAdapter;
import pat.international.explosivepopcorn.models.Category;
import pat.international.explosivepopcorn.models.CategoryViewModel;


public class CategoriesList extends Fragment {

    private static final String TAG = "CategoriesList";
    RecyclerView recyclerArticles;
    CategoriesRecViewAdapter adapter;
    View view;
    NavController navController;
    CategoryViewModel viewModel;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_categories, container, false);
        startRecyclerView(view);
        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        viewModel.requestListOfCategories();
        viewModel.getListOfCategories().observe(getViewLifecycleOwner(), i->adapter.setCategories(i));

    }


    private void startRecyclerView(View view){
        recyclerArticles = view.findViewById(R.id.rec_categories);
        recyclerArticles.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new CategoriesRecViewAdapter(viewModel,getContext());
        recyclerArticles.setAdapter(adapter);
    }







}