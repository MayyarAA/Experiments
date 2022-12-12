package com.mayyar.mayyarEffectiveJava.partone.compositionoverinhertance;

import java.util.Collection;
import java.util.HashSet;

//compositionoverinhertance
public class InstrumentalHashSet<E> extends HashSet<E> {
    private int totalValuesAdded;

    @Override
    public boolean add(E value){
        totalValuesAdded++;
        return super.add(value);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        totalValuesAdded += c.size();
        return super.addAll(c);
    }

    public int getTotalValuesAdded(){
        return totalValuesAdded;
    }
}
