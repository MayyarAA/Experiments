package com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser;

import java.io.File;
import  java.util.*;

public class InputParserFileServices {
    public void parseAndReturnFileData(File file){
        String[] fakeData = new String[12];
        //parse file
        fillFakeData(fakeData);
        String res = determineFileMetrics(fakeData)

    }



    void fillFakeData(String [] arr){
        Random rand = new Random();
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        for(int j=0;j<arr.length;j++){
            StringBuilder sb = new StringBuilder(rand.nextInt(56));
            for (int i = 0; i < sb.length(); i++) {
                int index = (int)(AlphaNumericString.length()
                        * Math.random());

                // add Character one by one in end of sb
                sb.append(AlphaNumericString
                        .charAt(index));
            }
            arr[j]  = sb.toString();

        }
    }
}
