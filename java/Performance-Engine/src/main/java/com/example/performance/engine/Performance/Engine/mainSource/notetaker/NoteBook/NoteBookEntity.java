package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class NoteBookEntity extends BaseEntity implements Serializable {
    UUID ownerId;
    public NoteBookEntity(String name, UUID ownerId) {
        super(name);
        this.ownerId =ownerId;
    }
    public NoteBookEntity(String name) {
        super(name);
    }

    public UUID getOwnerId() {
        return ownerId;
    }
}
