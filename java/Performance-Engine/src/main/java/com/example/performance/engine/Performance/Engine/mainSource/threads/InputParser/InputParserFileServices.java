package com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser;

import java.io.File;
import java.util.*;

public class InputParserFileServices {
    File file;
    private HashMap<String, HashMap<String, String>> lineInFileMetricsMap = new HashMap<String, HashMap<String, String>>();
    public static class TaskThread1 extends Thread{
        private volatile String name;
        public TaskThread1(String name){
            super.setName(name);
        }
        @Override
        public void run(){

        }
    }
    public InputParserFileServices(File file){
        this.file = file;
    }
    public HashMap<String, HashMap<String, String>> parseAndReturnFileData() {
        String[] fakeData = new String[100];
        //parse file
        fillFakeData(fakeData);
        determineFileMetricsSync(fakeData);
//        HashMap<String, HashMap<String, String>> res = determineFileMetricsASync(fakeData);
        return lineInFileMetricsMap;
//        return res;
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

//    private HashMap<String, HashMap<String, String>> determineFileMetricsASync(String[] data){
//        HashMap<String, HashMap<String, String>> res = new HashMap<>();
//        TaskThread1 taskThread1 = new TaskThread1("taskThread1");
//        TaskThread1 taskThread2 = new TaskThread1("taskThread2");
//        taskThread1.start();
//        taskThread2.start();
//
//    }

    void fillFakeData(String[] arr) {
        Random rand = new Random();
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        for (int j = 0; j < arr.length; j++) {
            int lengthOfWord = rand.nextInt(56);
            StringBuilder sb = new StringBuilder(lengthOfWord);
            for (int i = 0; i < lengthOfWord; i++) {
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
