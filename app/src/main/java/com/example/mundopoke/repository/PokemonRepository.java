package com.example.mundopoke.repository;

import com.example.mundopoke.model.detalhes.DetalheResult;
import com.example.mundopoke.model.pokemons.PokemonsResult;

import static com.example.mundopoke.data.remote.RetrofitService.getApiService;

import io.reactivex.Observable;

public class PokemonRepository {

    public Observable<PokemonsResult> getPokemons(int pagina, int limite){
        return getApiService().getAllPokemons(pagina, limite);
    }

    public Observable<PokemonsResult> getPokemonsFiltro(int pagina, int limite){
        return getApiService().getAllPokemons(pagina, limite);
    }

/*    public Observable<DetalheResult> getDetalhesPokemons(int numeroPokemon){
        return  getApiService().getDetalhesPokemon(numeroPokemon);
    }*/

}
