package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note.Note;

public interface ObjectHolder {
    public BaseObject getById(int id);
    public BaseObject getByName(String name);
    public void removeById(int id);
    public  void removeByName(String name);
    public void removeFull(BaseObject baseObject);
}
