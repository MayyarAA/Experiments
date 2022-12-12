package com.mayyar.mayyarEffectiveJava.partone;

public class EventObjectClonableConstructor {
    private final int id;
    private final String message;


    public EventObjectClonableConstructor(final int id, final String message ) {
        this.id = id;
        this.message = message;
    }

    public EventObjectClonableConstructor(EventObjectClonableConstructor obj){
        this.id = obj.id;
        this.message = obj.message;;
    }

    public static EventObjectClonableConstructor newInstance(EventObjectClonableConstructor obj){
        return new EventObjectClonableConstructor(obj.id, obj.message);
    }
}
