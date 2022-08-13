package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note.Note;

import java.io.Serializable;
import java.util.Date;

public class Page extends BaseObject implements Serializable {
    int id;
    String date;
    Note[] notes;
    
}

