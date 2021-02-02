package com.example.mundopoke.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mundopoke.R;
import com.example.mundopoke.model.pokemons.Result;
import com.example.mundopoke.view.adapter.RecyclerViewPokemonAdapter;
import com.example.mundopoke.view.interfaces.PokemonsOnClick;
import com.example.mundopoke.view.viewmodel.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PokemonsOnClick {

    public static final String POKEMON_KEY = "pokemon";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerViewPokemonAdapter adapter;
    private List<Result> listaPokemons = new ArrayList<>();
    private PokemonViewModel viewModel;
    private SearchView searchView;
    private String bandName = "bulbasaur";

    private int pagina = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        setScrollView();

        viewModel.getAllPokemons(pagina);

        viewModel.getListaPokemons().observe(this, resultadoLista -> {
            adapter.atualizarLista(resultadoLista);
            Log.i("LOG", "resultado do adapter: " + resultadoLista);
        });

        viewModel.getLoading().observe(this, loading -> {
            if (loading){
                progressBar.setVisibility(View.VISIBLE);
            }else {
                progressBar.setVisibility(View.GONE);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                bandName = text;
                adapter.clear();
                viewModel.getAllPokemons(bandName);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() > 2){
                    bandName = newText;
                    adapter.clear();
                    viewModel.getAllPokemons(bandName);
                }
                return false;
            }
        });
    }

    private void initViews() {

        recyclerView = findViewById(R.id.recyclerPrincipal);
        progressBar = findViewById(R.id.progress_bar);
        adapter = new RecyclerViewPokemonAdapter(listaPokemons, this, this);
        viewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        searchView = findViewById(R.id.searchView);
    }

    @Override
    public void click(Result result) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("pokemon", result);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setScrollView(){

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();

                int totalItemCount = gridLayoutManager.getItemCount();

                int lastVisible = gridLayoutManager.findLastVisibleItemPosition();

                boolean ultimoItem = lastVisible + 5 >= totalItemCount;

                if (totalItemCount > 0 && ultimoItem) {
                    pagina = pagina + 20;
                    Log.i("LOG", "valor da pagina dentro da soma " + pagina);
                    viewModel.getAllPokemons(pagina);
                }

            }
        });
    }

}