package com.example.performance.engine.Performance.Engine.mainSource.notetaker.DataStores;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note.Note;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.NoteTakerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class JSONDataStore {
    File file;
    @Autowired
    private NoteTakerUtils noteTakerUtils;

    void createFileNow(String fileName){
        file = createFile(fileName);
    }
    public void saveNote(Note note ){
        writeToJSONFile(note);
    }

    public void writeToJSONFile(BaseObject baseObject, String fileName){
        writeToFile(baseObject, fileName);
    }
    public void writeToFile(BaseObject baseObject, String fileName){
//        String fullFilePathName = new File("").getAbsolutePath();

//        String outputFileName= fullFilePathName.concat("/src/main/mainsource/notetaker/Output/").concat(fileName);
        String outputFileName = "/Users/mayyaral-atari/Desktop/work/experiments/java/Performance-Engine/src/main/java/com/example/performance/engine/Performance/Engine/mainSource/notetaker/output/".concat(fileName);
        try{
            FileWriter fileWriter = new FileWriter(outputFileName);
            BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
            String value = noteTakerUtils.convertToJSON(baseObject);
            System.out.println("value " + value);
            //start writing
            bufferedWriter.newLine();
            bufferedWriter.write(value);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        }catch(Exception e){
            System.out.println("Error " +e);
        }
    }
    public void writeToJSONFile(BaseObject baseObject){
        if(file.getAbsolutePath() == null || file.getAbsolutePath().isEmpty() ){
            System.out.println("Please give file name first");
        }
        writeToFile(baseObject, this.file.getAbsolutePath());

    }

    public void readJSONFile(){

    };

    public  File createFile(String filePathName){
        String fullFilePathName = new File("").getAbsolutePath();
        System.out.println(fullFilePathName);
        fullFilePathName.concat("/src/main/mainsource/notetaker/Output/");
        try{
            File file = new File(fullFilePathName+filePathName);
            if(file.createNewFile()){
                System.out.println("File created");
                return file;
            }
            System.out.println("File already exits");
            return file;
        }catch(IOException e){
            System.out.println("Error file not created due to IOException");
            e.printStackTrace();
            return null;
        }
    }
}
