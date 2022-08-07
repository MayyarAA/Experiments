package com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser;


import com.example.performance.engine.Performance.Engine.mainSource.PerfomanceEngineSubClassOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.performance.engine.Performance.Engine.mainSource.threads.InputParser.InputParserFileServices.*;
import java.io.File;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/inputparser")
public class InputParserController {
    Logger logger = LoggerFactory.getLogger(InputParserController.class);
    InputParserFileServices inputParserFileService = new InputParserFileServices();
    class InputParserOutput{
        String value;
        public  InputParserOutput(String value){
            this.value = value;
        }
    }
    @PostMapping(path = "submit/file")
    public  InputParserOutput submitFilePost(){
        inputParserFileService.parseAndReturnFileData(new File("file"));
        InputParserOutput temp = new InputParserOutput("hello from inputparser");
        logger.info("Request received to submitFilePost");
        return temp;
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
