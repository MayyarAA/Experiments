package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Note")
@Setter@Getter
public class NoteEntity extends BaseEntity   {

    private String value;
    private  String ownerId;
    private String pageId;

    public NoteEntity(String name, String value, String ownerId, String pageId){
        super(name);
        setValue(value);
        setOwnerId(ownerId);
        setPageId(pageId);
    }
    public NoteEntity(){
        super("name");
    }
    public NoteEntity(String name){
        super(name);
    }
}
