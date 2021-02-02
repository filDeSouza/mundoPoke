package com.example.mundopoke.data.remote;

import com.example.mundopoke.model.detalhes.DetalheResult;
import com.example.mundopoke.model.pokemons.PokemonsResult;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonAPI {

    @GET("pokemon")
    Observable<PokemonsResult> getAllPokemons(@Query("offset") int pagina,
                                              @Query("limit") int limite);

    @GET("pokemon/{pokemon}")
    Call<DetalheResult> getDetalhesPokemon(@Path(value = "pokemon") int pokemon);

}
