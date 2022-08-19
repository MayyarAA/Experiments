package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Document("notebook")
public class NoteBookEntity extends BaseEntity implements Serializable {
//    UUID ownerId;
    String ownerId;
    public NoteBookEntity(){
        super("name");
    }
    public NoteBookEntity(String name, String ownerId) {
        super(name);
        this.ownerId =ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
