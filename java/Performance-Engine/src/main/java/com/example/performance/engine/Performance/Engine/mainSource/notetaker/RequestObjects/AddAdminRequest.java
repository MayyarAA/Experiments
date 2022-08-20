package com.example.performance.engine.Performance.Engine.mainSource.notetaker.RequestObjects;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AddAdminRequest {
//    private NoteBook noteBook;
    private  String noteBookId;
    private String potentialNewAdminId;
//    private User requstingUser;
    private String requestCreaterUserId;
}
