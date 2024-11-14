package com.todoWithMongo.todoWithMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoDTO,String>{
	
}
