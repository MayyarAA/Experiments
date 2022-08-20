package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ErrorCodes {
    private   static final HashMap<ErrorCodesEnum, String > errorCodesMap = new HashMap<>();
//    public static enum ErrorCodesEnum{
//        ERROR_USER_NOT_AUTHORIZED_TO_ADD_NEW_ADMIN,
//        ERROR_NOT_POSSIBLE,
//    }
    static {
        errorCodesMap.put(ErrorCodesEnum.ERROR_USER_NOT_AUTHORIZED_TO_ADD_NEW_ADMIN, "User is not authorized to add new admin");
        errorCodesMap.put(ErrorCodesEnum.ERROR_NOT_POSSIBLE, "Not possible");
    }

    public static HashMap<ErrorCodesEnum, String> getErrorCodes(){
        return errorCodesMap;
    }

}
