package com.example.performance.engine.Performance.Engine.notetakerTests.UtilsTests;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.ErrorCodes;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.ErrorCodesEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ErrorCodesTests {

    @Test
    public void testErrorCodes() {
        for (ErrorCodesEnum errorCodesEnum : ErrorCodesEnum.values()) {
            Assertions.assertTrue(ErrorCodes.getErrorCodes().containsKey(errorCodesEnum));
        }
    }
}
