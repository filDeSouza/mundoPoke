package com.example.mundopoke.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mundopoke.R;
import com.example.mundopoke.model.detalhes.DetalheResult;
import com.example.mundopoke.model.pokemons.Result;
import com.example.mundopoke.view.interfaces.PokemonsOnClick;

import java.util.List;

public class RecyclerViewPokemonAdapter extends RecyclerView.Adapter<RecyclerViewPokemonAdapter.ViewHolder> {

    private List<Result> pokemonList;
    private List<DetalheResult> detalhesPokemons;
    private PokemonsOnClick listener;
    private Context context;

    public RecyclerViewPokemonAdapter(List<Result> pokemonList, PokemonsOnClick listener, Context context){
        this.context = context;
        this.pokemonList = pokemonList;
        this.listener = listener;
        Log.i("LOG", "tamanho da lista dentro do RecyclerViewComicAdapter: " + pokemonList.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_pokemon, parent, false);
        Log.i("LOG", "tamanho da lista dentro do onCreateViewHolder: " + pokemonList.size());
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = pokemonList.get(position);
        //ResultDetalhes detalhesPokemonsResultDetalhes = detalhesPokemons.get(position);

        holder.onBind(result);
        Log.i("LOG", "tamanho da lista dentro do onBindViewHolder: " + pokemonList.size());
        holder.itemView.setOnClickListener(v -> listener.click(result));
    }

    @Override
    public int getItemCount() {
        Log.i("LOG", "tamanho da lista dentro do getItemCount(): " + pokemonList.size());
        return pokemonList.size();
    }

    public void atualizarLista(List<Result> novaLista){

        if (this.pokemonList.isEmpty()){
            this.pokemonList = novaLista;
            Log.i("LOG", "tamanho da lista dentro do atualizarLista: " + pokemonList.size());
        }else{
            this.pokemonList.addAll(novaLista);
            Log.i("LOG", "tamanho da lista dentro do atualizarLista2: " + pokemonList.size());
        }
        notifyDataSetChanged();
    }

    public void clear(){
        this.pokemonList.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageItem);
            textView = itemView.findViewById(R.id.textItem);

        }

        public void onBind(Result result){

            textView.setText(result.getName());
            String valorImagem =  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + result.getNumber() +".png";
            //Picasso.get().load(valorImagem+".png").into(imageView);
            Glide.with(context)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + result.getNumber() + ".png")
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
            Log.i("LOG", "tamanho da lista dentro do onBind: " + pokemonList.size());
            Log.i("LOG", "resultado do adapter dentro do onBind: " + result.getName());
            Log.i("LOG", "valor da imagem " + valorImagem);
        }
    }
}
