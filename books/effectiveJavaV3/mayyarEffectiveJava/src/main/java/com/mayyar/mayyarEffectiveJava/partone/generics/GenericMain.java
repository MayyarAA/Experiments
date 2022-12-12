package com.mayyar.mayyarEffectiveJava.partone.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMain {
    interface Obj{

    }
    class ObjOne implements Obj{

    }
    class ObjTwo implements Obj{

    }

    class ObjThree extends ObjTwo{

    }
    public void test(){
        List<Obj> list = new ArrayList<>();
        list.add(new ObjOne());
        list.add(new ObjTwo());
        list.add(new ObjThree());

        System.out.println("index 0 "  + list.get(0).getClass());
        System.out.println("index 1 "  + list.get(1).getClass());
        System.out.println("index 2 "  + list.get(2).getClass());

    }
}
