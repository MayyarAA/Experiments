package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("user")
public class UserEntity extends BaseEntity {
    @Indexed(unique=true)
    private String email;
    public UserEntity(){
        super("name");
    }
    public UserEntity(String name, String date, UUID id){
        super(name, date,id);
    }
    public UserEntity(String name, String email){
        super(name);
        setEmail(email);
    }
    public UserEntity(String name){
        super(name);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
