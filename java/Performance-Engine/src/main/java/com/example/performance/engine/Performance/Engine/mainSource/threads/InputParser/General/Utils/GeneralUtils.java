package com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser.General.Utils;

import com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser.InputLineMetrics;

import java.util.Comparator;
import java.util.PriorityQueue;
import com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser.WordObject;
public class GeneralUtils {

    public static PriorityQueue<WordObject> createWordOccurancesPQueue(){
        PriorityQueue<WordObject> pqueue = new PriorityQueue<>(new Comparator<WordObject>() {
            @Override
            public int compare(WordObject o1, WordObject o2) {
                return Integer.compare(o2.getNumOfOccurances(),o1.getNumOfOccurances());
            }
        });
        return pqueue;
    }
}
