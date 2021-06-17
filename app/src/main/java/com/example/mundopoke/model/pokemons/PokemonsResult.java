
package com.example.mundopoke.model.pokemons;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class PokemonsResult {

    @Expose
    private Long count;
    @Expose
    private String next;
    @Expose
    private Object previous;
    @Expose
    private List<Result> results;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
