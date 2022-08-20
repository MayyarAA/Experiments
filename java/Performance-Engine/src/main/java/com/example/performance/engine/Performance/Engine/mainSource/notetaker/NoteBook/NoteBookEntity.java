package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseEntity;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.User;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Document("notebook")
@Setter@Getter
public class NoteBookEntity extends BaseEntity implements Serializable {
//    UUID ownerId;
    String ownerId;
    private HashSet<String> admins;
    private HashSet<String> viewers;
    public NoteBookEntity(){
        super("name");
    }
    public NoteBookEntity(String name, String id, String ownerId, HashSet<String> admins, HashSet<String> viewers){
        super(name, id);
        setOwnerId(ownerId);
        setAdmins(admins);
        setViewers(viewers);
    }
    public NoteBookEntity(String name, String ownerId) {
        super(name);
        this.ownerId =ownerId;
    }

    public void addAdmin(String potentialAdminId){
        admins.add(potentialAdminId);
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
