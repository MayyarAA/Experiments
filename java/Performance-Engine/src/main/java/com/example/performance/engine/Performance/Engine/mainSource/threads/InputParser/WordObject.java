package com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser;

public class WordObject {

    private String wordValue;
    private int numOfOccurances = 0;
    public WordObject(String wordValue){
        this.wordValue = wordValue;
    }

    public void setNumOfOccurances() {
        this.numOfOccurances = this.wordValue.length();
    }
    public void setNumOfOccurances(int numOfOccurances) {
        this.numOfOccurances = numOfOccurances;
    }

    public void setWordValue(String wordValue) {
        this.wordValue = wordValue;
    }

    public int getNumOfOccurances() {
        return numOfOccurances;
    }

    public String getWordValue() {
        return wordValue;
    }
}
