package com.example.performance.engine.Performance.Engine;

import com.example.performance.engine.Performance.Engine.mainSource.PerfomanceEngineSubClassOne;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note.NoteRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PerformanceEngineApplication {
	@Autowired
	UserRepository userRepository;
	@Autowired
	NoteRepository noteRepository;
	@Autowired
	NoteBookRepository noteBookRepository;
	public static void main(String[] args) {
		SpringApplication.run(PerformanceEngineApplication.class, args);
		PerfomanceEngineSubClassOne perfomanceEngineSubClassOne = new PerfomanceEngineSubClassOne();
		perfomanceEngineSubClassOne.start();
	}

}
