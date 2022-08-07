package com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser;

import java.io.File;
import java.util.*;

public class InputParserFileServices {
    File file;
    private HashMap<String, HashMap<String, String>> lineInFileMetricsMap = new HashMap<String, HashMap<String, String>>();

    public InputParserFileServices(File file){
        this.file = file;
    }
    public HashMap<String, HashMap<String, String>> parseAndReturnFileData() {
        String[] fakeData = new String[12];
        //parse file
        fillFakeData(fakeData);
        determineFileMetricsSync(fakeData);
        return lineInFileMetricsMap;
    }
    //return tot # of lines, tot # of chars, per line[tot # of chars, length of longests word]
    private void determineFileMetricsSync(String[] data) {
        HashMap<String, String> overAllFileData = new HashMap<>();
        int totNumOfLines=data.length;
        overAllFileData.put("TotNumOfLines", Integer.toString(totNumOfLines));
        int totNumOfChars = 0;
        for(int i=0;i<data.length;i++){
            String value =  data[i];
            totNumOfChars+=value.length();
            InputLineMetrics inputLineMetrics = new InputLineMetrics(value);
            inputLineMetrics.determineLineMetrics();
            HashMap<String, String> lineMetric = inputLineMetrics.getLineMetrics();
            lineInFileMetricsMap.put(""+i,lineMetric);
        }
        overAllFileData.put("TotNumOfChars", Integer.toString(totNumOfChars));
        lineInFileMetricsMap.put("OverAllFileData",overAllFileData);
    }

    void fillFakeData(String[] arr) {
        Random rand = new Random();
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        for (int j = 0; j < arr.length; j++) {
            StringBuilder sb = new StringBuilder(rand.nextInt(56));
            for (int i = 0; i < sb.length(); i++) {
                int index = (int) (AlphaNumericString.length()
                        * Math.random());

                // add Character one by one in end of sb
                sb.append(AlphaNumericString
                        .charAt(index));
            }
            arr[j] = sb.toString();

        }
    }
}
