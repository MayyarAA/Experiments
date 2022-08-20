package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.NoteTakerUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Setter
@Getter
public class BaseEntity {

    NoteTakerUtils noteTakerUtils;
    @Indexed(unique=true)
    private UUID customId;
//    @Id
//    public ObjectId id;
    @MongoId(FieldType.OBJECT_ID)
    public String id;
    private String date;
    private String name;



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
        setDate("date");
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
    public boolean isNull(){
        if(this.customId==null && this.id ==null){
            return true;
        }
        if(this.id == null){
            return true;
        }
        return false;
    }
}
