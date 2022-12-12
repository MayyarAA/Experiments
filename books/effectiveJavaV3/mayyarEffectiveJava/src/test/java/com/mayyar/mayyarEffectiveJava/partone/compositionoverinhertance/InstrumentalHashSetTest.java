package com.mayyar.mayyarEffectiveJava.partone.compositionoverinhertance;



import com.mayyar.mayyarEffectiveJava.partone.generics.GenericMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstrumentalHashSetTest  {

    @Test
    void isValid(){
        InstrumentalHashSet<Integer> instrumentalHashSet = new InstrumentalHashSet();
        instrumentalHashSet.add(1);

        assertEquals(instrumentalHashSet.getTotalValuesAdded(), 1);
        instrumentalHashSet.addAll(List.of(5,2,3));

        assertEquals(instrumentalHashSet.getTotalValuesAdded(), 4);
    }


    @Test
    void testGenericMain(){
        GenericMain genericMain = new GenericMain();
        genericMain.test();
    }

}