package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;

@Document("notebook")
@Setter
@Getter
public class NoteBookEntity extends BaseEntity implements Serializable {
    //    UUID ownerId;
    String ownerId;
    private HashSet<String> admins;
    private HashSet<String> viewers;
    private HashSet<String> pages;

    public NoteBookEntity() {
        super("name");
    }

    public NoteBookEntity(String name, String id, String ownerId, HashSet<String> admins, HashSet<String> viewers) {
        super(name, id);
        setOwnerId(ownerId);
        setAdmins(admins);
        setViewers(viewers);
    }

    public NoteBookEntity(String name, String ownerId) {
        super(name);
        this.ownerId = ownerId;
    }

    public void addAdmin(String potentialAdminId) {
        admins.add(potentialAdminId);
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
