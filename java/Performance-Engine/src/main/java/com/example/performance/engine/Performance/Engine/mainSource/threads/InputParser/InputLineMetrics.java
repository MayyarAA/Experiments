package com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser.General.Utils.GeneralUtils;
public class InputLineMetrics {
    private int totNumOfChars;
    private int lengthOfLongestWord;
    private String mostCommonWord;
    private String line;
    private String[] words;
    private PriorityQueue<WordObject> orderNumOfWordOccurances;
    private  HashMap<String, String> lineMetrics = new HashMap<>();
    private HashMap<String, WordObject> wordObjMap = new HashMap<>();
    public InputLineMetrics(String line){
        words = line.split(" ");
        this.line = line;
        this.orderNumOfWordOccurances = GeneralUtils.createWordOccurancesPQueue();
    }

    public String getLine(){
        return this.line;
    }
    public void setLengthOfLongestWord(int lengthOfLongestWord) {
        this.lengthOfLongestWord = lengthOfLongestWord;
    }
    public void setLengthOfLongestWord(String newWord) {
        this.lengthOfLongestWord = Math.max(this.lengthOfLongestWord, newWord.length());
    }

    public void setMostCommonWord(String mostCommonWord) {
        this.mostCommonWord = mostCommonWord;
    }

    public void setTotNumOfChars(int totNumOfChars) {
        this.totNumOfChars = totNumOfChars;
    }

    public int getLengthOfLongestWord() {
        return lengthOfLongestWord;
    }


    public int getTotNumOfChars() {
        return totNumOfChars;
    }

    public HashMap<String, String> getLineMetrics() {
        return lineMetrics;
    }

    //per line[tot # of chars, length of longests word, most common word]
    public void determineLineMetrics(){
        for(String word: words){
            this.totNumOfChars += word.length();
            setLengthOfLongestWord(word);
            WordObject wordObject = wordObjMap.getOrDefault(word, new WordObject(word));
            wordObject.setNumOfOccurances( wordObject.getNumOfOccurances()+1);
            //TO:DO check if we need to put it back in map or it is still pointing to the memory location
            wordObjMap.put(word, wordObject);
            orderNumOfWordOccurances.add(wordObject);
        }
        lineMetrics.put("TotalNumOfCharsInLine", ""+this.totNumOfChars);
        lineMetrics.put("LengthOfLongestWord", ""+this.lengthOfLongestWord);
        lineMetrics.put("MostCommonWord", getMostCommonWord());

    }
    private String getMostCommonWord(){
        this.mostCommonWord = orderNumOfWordOccurances.poll().getWordValue();
        return mostCommonWord;
    }
}
