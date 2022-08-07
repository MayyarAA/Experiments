package com.example.performance.engine.Performance.Engine;

import com.example.performance.engine.Performance.Engine.mainSource.PerfomanceEngineSubClassOne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PerformanceEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceEngineApplication.class, args);
		PerfomanceEngineSubClassOne perfomanceEngineSubClassOne = new PerfomanceEngineSubClassOne();
		perfomanceEngineSubClassOne.start();
	}

}
