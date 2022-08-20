package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.UUID;

@Document("user")
@Setter@Getter
public class UserEntity extends BaseEntity {
    @Indexed(unique=true)
    private String email;
    private HashSet<String> noteBooks;
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
