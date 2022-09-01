package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;

@Document("page")
@Setter
@Getter
public class PageEntity extends BaseEntity {
    String ownerId;
    String noteBookId;
    HashSet<String> notes;

    public PageEntity() {

    }

    public PageEntity(String pageName, String ownerId, String noteBookId) {
        super(pageName);
        setOwnerId(ownerId);
        setNoteBookId(noteBookId);
    }

}
