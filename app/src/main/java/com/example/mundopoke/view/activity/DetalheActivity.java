package com.example.mundopoke.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mundopoke.R;
import com.example.mundopoke.data.remote.PokemonAPI;
import com.example.mundopoke.model.detalhes.DetalheResult;
import com.example.mundopoke.model.pokemons.Result;
import com.example.mundopoke.view.viewmodel.PokemonViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetalheActivity extends AppCompatActivity {

    private static final String POKEMON_KEY = "pokemon";
    private ImageView imageViewFundo;
    private ImageView imageViewPokemon;
    private TextView textViewNome;
    private TextView textViewTipo;
    private TextView textViewHabilidade1;
    private TextView textViewHabilidade2;
    private TextView textViewHabilidade3;
    private PokemonViewModel viewModel;
    public Retrofit mRetrofit;
    private Context context;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        
        initViews();

        mRetrofit =new Retrofit.Builder().baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create()).build();

        if (getIntent() != null && getIntent().getExtras() != null){

            Result result = getIntent().getExtras().getParcelable(POKEMON_KEY);
            Log.i("LOG", "numero dentro do getExtras: " + result.getNumber());
            int valor = result.getNumber();

            Glide.with(context)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + result.getNumber() + ".png")
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageViewPokemon);

            progressBar.setVisibility(View.VISIBLE);



            PokemonAPI pokeAPI = mRetrofit.create(PokemonAPI.class);
            Call<DetalheResult> pokemonDetalheResult = pokeAPI.getDetalhesPokemon(valor);

            pokemonDetalheResult.enqueue(new Callback<DetalheResult>() {

                @Override
                public void onResponse(Call<DetalheResult> call, Response<DetalheResult> response) {
                    if (response.isSuccessful()){
                        progressBar.setVisibility(View.GONE);
                        DetalheResult resultDetalhes = response.body();
                        textViewNome.setText(resultDetalhes.getName());
                        Log.i("LOG", "Nome do pokemon no detalhe: " + resultDetalhes.getName());

                        if (resultDetalhes.getTypes().get(0).getType().getName().equals("grass")){
                            imageViewFundo.setBackgroundColor(Color.rgb(0, 204, 0));
                        } else if (resultDetalhes.getTypes().get(0).getType().getName().equals("fire")){
                            imageViewFundo.setBackgroundColor(Color.rgb(204, 0, 0));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("normal")){
                            imageViewFundo.setBackgroundColor(Color.rgb(203, 79, 1));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("fighting")){
                            imageViewFundo.setBackgroundColor(Color.rgb(231, 179, 0));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("flying")){
                            imageViewFundo.setBackgroundColor(Color.rgb(112, 204, 225));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("poison")){
                            imageViewFundo.setBackgroundColor(Color.rgb(158, 1, 162));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("ground")){
                            imageViewFundo.setBackgroundColor(Color.rgb(229, 109, 3));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("rock")){
                            imageViewFundo.setBackgroundColor(Color.rgb(128, 128, 128));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("bug")){
                            imageViewFundo.setBackgroundColor(Color.rgb(0, 102, 0 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("water")){
                            imageViewFundo.setBackgroundColor(Color.rgb(0, 0, 204 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("ghost")){
                            imageViewFundo.setBackgroundColor(Color.rgb(32, 32, 32 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("steel")){
                            imageViewFundo.setBackgroundColor(Color.rgb(192, 192, 192 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("electric")){
                            imageViewFundo.setBackgroundColor(Color.rgb(255, 255, 0 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("psychic")){
                            imageViewFundo.setBackgroundColor(Color.rgb(153, 153, 0 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("ice")){
                            imageViewFundo.setBackgroundColor(Color.rgb(204, 255, 255 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("dragon")){
                            imageViewFundo.setBackgroundColor(Color.rgb(255, 128, 0 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("dark")){
                            imageViewFundo.setBackgroundColor(Color.rgb(0, 0, 0 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("fairy")){
                            imageViewFundo.setBackgroundColor(Color.rgb(255, 51, 255 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("unknown")){
                            imageViewFundo.setBackgroundColor(Color.rgb(244, 244, 244 ));
                        }else if (resultDetalhes.getTypes().get(0).getType().getName().equals("shadow")){
                            imageViewFundo.setBackgroundColor(Color.rgb(64, 64, 64 ));
                        }

                        textViewTipo.setText(resultDetalhes.getTypes().get(0).getType().getName());

                        int tamanhoHabilidades = resultDetalhes.getAbilities().size();

                        if (tamanhoHabilidades == 1){
                            textViewHabilidade1.setText(resultDetalhes.getAbilities().get(0).getAbility().getName());
                            textViewHabilidade2.setVisibility(View.GONE);
                            textViewHabilidade3.setVisibility(View.GONE);
                        }else if (tamanhoHabilidades == 2){
                            textViewHabilidade1.setText(resultDetalhes.getAbilities().get(0).getAbility().getName());
                            textViewHabilidade2.setText(resultDetalhes.getAbilities().get(1).getAbility().getName());
                            textViewHabilidade3.setVisibility(View.GONE);
                        }else if (tamanhoHabilidades == 3){
                            textViewHabilidade1.setText(resultDetalhes.getAbilities().get(0).getAbility().getName());
                            textViewHabilidade2.setText(resultDetalhes.getAbilities().get(1).getAbility().getName());
                            textViewHabilidade3.setText(resultDetalhes.getAbilities().get(2).getAbility().getName());
                        }


                        String tipo = resultDetalhes.getTypes().get(0).getType().getName();
                        Log.i("LOG", "Tipo do pokemon: " + tipo);

                    }
                }

                @Override
                public void onFailure(Call<DetalheResult> call, Throwable t) {

                }
            });


        }

    }

    private void initViews() {

        imageViewFundo = findViewById(R.id.imageViewFundo);
        imageViewPokemon = findViewById(R.id.imageViewPokemon);
        textViewNome = findViewById(R.id.textViewNome);
        textViewTipo = findViewById(R.id.textViewTipo);
        textViewHabilidade1 = findViewById(R.id.textViewHabilidade1);
        textViewHabilidade2 = findViewById(R.id.textViewHabilidade2);
        textViewHabilidade3 = findViewById(R.id.textViewHabilidade3);
        viewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        progressBar = findViewById(R.id.progress_bar);
        context = this;

    }
}