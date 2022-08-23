package com.example.performance.engine.Performance.Engine.notetakerTests.NoteBookTests;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBook;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookEntity;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookService;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Secuirty.NoteTakerAuthorizationService;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NoteBookServiceTests {
    NoteTakerAuthorizationService noteTakerAuthorizationService;
    NoteBookRepository noteBookRepository;
    CustomLogger customLogger;
    NoteBookService noteBookService;
    final String mockedNoteBookId = "mockedNoteBookId";
    final String mockedOwnerId = "mockedOwnerId";
    final String mockedNoteBookName = "mockedNoteBookName";
    NoteBookEntity mockedNoteBookEntity = new NoteBookEntity(mockedNoteBookName, mockedNoteBookId, mockedOwnerId, null, null);


    @BeforeEach
    public void setup() {
        noteTakerAuthorizationService = mock(NoteTakerAuthorizationService.class);
        noteBookRepository = mock(NoteBookRepository.class);
        customLogger = mock(CustomLogger.class);
        noteBookService = new NoteBookService(customLogger, noteBookRepository, noteTakerAuthorizationService);
    }

    private boolean isEqual(NoteBook n1, NoteBook n2) {
        if (n1.getName().compareTo(n2.getName()) != 0) return false;
        return true;
    }

    @Test
    public void getNoteBookByIdTest() {
        NoteBook noteBookMocked = new NoteBook(mockedNoteBookName, "descr");
        //arr
        when(noteBookRepository.findById(mockedNoteBookId)).thenReturn(Optional.of(mockedNoteBookEntity));
        //act
        NoteBook noteBook = noteBookService.getNoteBookById(mockedNoteBookId);
        //asr
        Assertions.assertInstanceOf(NoteBook.class, noteBook);
        Assertions.assertTrue(noteBook.getName().compareTo(mockedNoteBookName) == 0);
    }

    @Test
    public void getAllNoteBooksOwnedByUserIdTests() {
        //arr
        List<NoteBookEntity> mockedListOfNoteBooks = new ArrayList<>();
        mockedListOfNoteBooks.add(new NoteBookEntity(mockedNoteBookName, mockedOwnerId));
        when(noteBookRepository.findAllByOwnerId(mockedOwnerId)).thenReturn(mockedListOfNoteBooks);
        //act
        List<NoteBook> noteBookList = noteBookService.getAllNoteBooksOwnedByUserId(mockedOwnerId);
        //asr
        Assertions.assertEquals(noteBookList.size(), mockedListOfNoteBooks.size());
    }
}
