package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Secuirty;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBook;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.Page;
import org.springframework.stereotype.Component;

@Component
public class NoteTakerAuthorizationService {
    public boolean isAllowedToAddNewAdmin(String newAdminId, String currentAdminMakingRequestId, NoteBook noteBook) {
        if (!isAdminOnNoteBook(currentAdminMakingRequestId, noteBook)) {
            return false;
        }
        return true;
    }

    public boolean isAdminOnNoteBook(String potentialAdminId, NoteBook noteBook) {
        if (noteBook.isEmpty() || !noteBook.isAdmin(potentialAdminId)) return false;
        return true;
    }

    public boolean isAllowedToAddNoteToPage(String requesterUserId, Page page) {
        return true;
    }
}
