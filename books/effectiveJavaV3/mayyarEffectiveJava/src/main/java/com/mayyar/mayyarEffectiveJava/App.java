package com.mayyar.mayyarEffectiveJava;

import com.mayyar.mayyarEffectiveJava.partone.EventObjectClonableConstructor;
import com.mayyar.mayyarEffectiveJava.partone.singleton.DBConnectionSingleton;
import com.mayyar.mayyarEffectiveJava.utils.Logger.LoggerBase;
import com.mayyar.mayyarEffectiveJava.utils.Logger.LoggerImpl;

/**
 * Hello world!
 *
 */
public class App {
    static LoggerBase logger = new LoggerImpl();
    public static void main(String[] args) {
        System.out.println("Hello World!");

        /***
         *  testing singleton
         */
        DBConnectionSingleton dBConnectionSingleton = DBConnectionSingleton.INSTANCE;
        DBConnectionSingleton dBConnectionSingleton2 = DBConnectionSingleton.INSTANCE;
        logger.log( String.valueOf(dBConnectionSingleton.getClass().hashCode()));
        logger.log( String.valueOf(dBConnectionSingleton2.getClass().hashCode()));
        logger.log(String.format("checking if both singletons are the same obj result: %s" , dBConnectionSingleton == dBConnectionSingleton2));

        /***
         *  testing cloneable
         */

        EventObjectClonableConstructor eventObj1 = new EventObjectClonableConstructor(1, "message1");
        EventObjectClonableConstructor eventObj2 = new EventObjectClonableConstructor(eventObj1);
        EventObjectClonableConstructor eventObj3 = EventObjectClonableConstructor.newInstance(eventObj1);

        logger.log( String.valueOf("eventObj1: " + eventObj1.getClass().hashCode()));
        logger.log( String.valueOf("eventObj2: " + eventObj2.getClass().hashCode()));
        logger.log( String.valueOf("eventObj3: " + eventObj3.getClass().hashCode()));
        logger.log(String.format("checking if both eventObj1 & eventObj2 are the same obj result: %s" , eventObj1 == eventObj2));
        logger.log(String.format("checking if both eventObj2 & eventObj3 are the same obj result: %s" , eventObj2 == eventObj3));
    }
}
