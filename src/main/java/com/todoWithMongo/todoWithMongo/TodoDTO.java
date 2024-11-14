package com.todoWithMongo.todoWithMongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="tododatabase")
public class TodoDTO {
@Id
private String id;
private String todo;
private String description;
private String completed;
private String createdAt;
private String updatedAt;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getTodo() {
	return todo;
}

public void setTodo(String todo) {
	this.todo = todo;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getCompleted() {
	return completed;
}

public void setCompleted(String completed) {
	this.completed = completed;
}

public String getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}

public String getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
}

@Override
public String toString() {
	return "TodoDTO [id=" + id + ", todo=" + todo + ", description=" + description + ", completed=" + completed
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
}
}
