package todo.service;

import java.sql.ResultSet;
import java.util.List;

import todo.DAO.TodoDAO;
import todo.DTO.TodoDTO;

public class TodoService {
	
	public List<TodoDTO> getList(){
		
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.selectAll();
		
	}
	public TodoDTO getLisTodo(TodoDTO todoDTO){
		
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.selectTodo(todoDTO);
		
	}
	
	public int addTodo(TodoDTO todoDTO) {
		// 검열 조작 하는 기능
		if(todoDTO.getTitle() == null) {
			return -1;
		}
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.insert(todoDTO);
	}
	
	
	public int removeTodo(TodoDTO todoDTO) {
		// 검열 조작 하는 기능

		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.delete(todoDTO);
	}
	
	public int modifyTodo(TodoDTO todoDTO) {
		TodoDAO todoDAO = new TodoDAO();
		return todoDAO.updateTodo(todoDTO);
	}
	
	
}
