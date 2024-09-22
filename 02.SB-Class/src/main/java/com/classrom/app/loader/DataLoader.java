package com.classrom.app.loader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.classrom.app.entity.ClassRoom;
import com.classrom.app.repository.ClassRepository;

@Component
public class DataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	@Autowired
	private ClassRepository classRepository ;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		 List<ClassRoom> classRoms = List.of(
				 new ClassRoom(3001L,"X","SSC"),
				 new ClassRoom(3002L,"Intermediate","PUC"),
				 new ClassRoom(3003L,"ENGINEERING","GRADUATION"),
				 new ClassRoom(3004L,"MASTERS","POSTGRADUATION"),
				 new ClassRoom(3005L,"MEDICINE","MBBS"));
		 
		 //classRepository.saveAll(classRoms);
				 
		System.out.println("========================================= ClassRoom =DataLoader");
		
	}

}
