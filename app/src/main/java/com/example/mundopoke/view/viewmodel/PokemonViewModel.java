package com.example.mundopoke.view.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mundopoke.model.detalhes.DetalheResult;
import com.example.mundopoke.model.pokemons.Result;
import com.example.mundopoke.repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PokemonViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> listaPokemons = new MutableLiveData<>();
    private MutableLiveData<DetalheResult> detalhePokemon = new MutableLiveData<>();
    private DetalheResult detalheResult = new DetalheResult();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private PokemonRepository repository = new PokemonRepository();

    public PokemonViewModel(@NonNull Application application){
        super(application);
    }

    public LiveData<List<Result>> getListaPokemons(){
        return this.listaPokemons;
    }

    public LiveData<DetalheResult> getDetalhePokemon(){
        return this.detalhePokemon;
    }

    public LiveData<Boolean> getLoading(){
        return this.loading;
    }

    public void getAllPokemons(int pagina){
        disposable.add(
                repository.getPokemons(pagina, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> loading.setValue(true))
                .doOnTerminate(() -> loading.setValue(false))
                .subscribe(response -> {

                    listaPokemons.setValue(response.getResults());
/*                    for (int valor = 1; valor <= 1118; valor++){
                        getDetalhePokemon(valor);
                    }*/
                     Log.i("LOG", "API: " + response.getResults() );

                }, throwable -> {
                            Log.i("LOG", "Error: " + throwable.getMessage());
                })
        );
    }

    public void getAllPokemons(String texto){
        disposable.add(
                repository.getPokemonsFiltro(0, 1118)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(response -> {

                            List<Result> listaFiltrada = new ArrayList<>();
                            for (Result result : response.getResults()){
                                String _name = result.getName().toLowerCase();
                                String _texto = texto.toLowerCase();
                                if (_name.contains(_texto)){
                                    listaFiltrada.add(result);
                                }
                            }

                            listaPokemons.setValue(listaFiltrada);
                            Log.i("LOG", "Resultado da busca: " + listaFiltrada.size());
                            Log.i("LOG", "Resultado da lista filtrada: " + listaFiltrada );

                        }, throwable -> {
                            Log.i("LOG", "Error: " + throwable.getMessage());
                        })
        );
    }

/*    public void getDetalhePokemon(int numeroPokemon){
        disposable.add(
                repository.getDetalhesPokemons(numeroPokemon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> loading.setValue(true))
                .doOnTerminate(() -> loading.setValue(false))
                .subscribe(response -> {
                    detalheResult.setName(response.getName());
                    Log.i("LOG", "API detalhes: " + detalheResult.getName());
                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                })
        );
    }*/

}
