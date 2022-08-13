package com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser;


import com.example.performance.engine.Performance.Engine.mainSource.PerfomanceEngineSubClassOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser.InputParserFileServices.*;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/inputparser")
public class InputParserController {
    Logger logger = LoggerFactory.getLogger(InputParserController.class);
    InputParserFileServices inputParserFileService = new InputParserFileServices(new File(""));
    class InputParserOutput{
        String value;
        public  InputParserOutput(String value){
            this.value = value;
        }
    }
    class RunTimeResponse implements Serializable {
        long runTime;
        HashMap<String, HashMap<String,String>> fileMetrics;
        RunTimeResponse(long time, HashMap<String, HashMap<String,String>> fileMetrics){
            this.runTime = time;
            this.fileMetrics = fileMetrics;
        }
        public void setFileMetrics(HashMap<String, HashMap<String, String>> fileMetrics) {
            this.fileMetrics = fileMetrics;
        }
        public void setRunTime(long runTime) {
            this.runTime = runTime;
        }
        public HashMap<String, HashMap<String, String>> getFileMetrics() {
            return fileMetrics;
        }
        public long getRunTime() {
            return runTime;
        }
    }
    @PostMapping(path = "submit/file")
    public  ResponseEntity<RunTimeResponse> submitFilePost(){
        long startTime = System.nanoTime();
        HashMap<String, HashMap<String,String>> res = inputParserFileService.parseAndReturnFileData();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        RunTimeResponse runTimeResponse = new RunTimeResponse(duration, res);
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(runTimeResponse);
    }
    @GetMapping (path = "file")
    public  ResponseEntity<HashMap<String, String>> getFile(){
        InputParserOutput temp = new InputParserOutput("hello from getFile");
        logger.info("Request received to getFile");
        HashMap<String, String> map = new HashMap<>();
        map.put("key",temp.value);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(map);
    }
}
