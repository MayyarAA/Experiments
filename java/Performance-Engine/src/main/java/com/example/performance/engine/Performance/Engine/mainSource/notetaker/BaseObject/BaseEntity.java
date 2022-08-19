package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.NoteTakerUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.bson.types.ObjectId;
import java.util.UUID;


public class BaseEntity {

    NoteTakerUtils noteTakerUtils;
    @Indexed(unique=true)
    private UUID customId;
    public ObjectId id;
    private String date;
    private String name;

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public BaseEntity(String name, String date, UUID id){
        setName(name);
        setCustomId(id);
        setDate(date);
    }
//    @Autowired
    public BaseEntity(NoteTakerUtils noteTakerUtils){
        this.noteTakerUtils = noteTakerUtils;
    }

    public void setNoteTakerUtils(NoteTakerUtils noteTakerUtils) {
        this.noteTakerUtils = noteTakerUtils;
    }

    public BaseEntity(){

    }
//    @Autowired
    public BaseEntity(String name){
        setName(name);
        setCustomId(UUID.randomUUID());
        if(noteTakerUtils!=null)setDate(noteTakerUtils.getCurrentTime());
    }
    public void setCustomId(UUID customId) {
        this.customId = customId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getCustomId() {
        return customId;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
