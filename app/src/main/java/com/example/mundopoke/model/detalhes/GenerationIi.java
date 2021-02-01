
package com.example.mundopoke.model.detalhes;

import com.google.gson.annotations.Expose;

public class GenerationIi {

    @Expose
    private Crystal crystal;
    @Expose
    private Gold gold;
    @Expose
    private Silver silver;

    public Crystal getCrystal() {
        return crystal;
    }

    public void setCrystal(Crystal crystal) {
        this.crystal = crystal;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public Silver getSilver() {
        return silver;
    }

    public void setSilver(Silver silver) {
        this.silver = silver;
    }

}
