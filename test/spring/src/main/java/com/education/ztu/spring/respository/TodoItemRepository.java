package com.education.ztu.spring.respository;

import com.education.ztu.spring.entity.TodoItem;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

    @Query("SELECT * FROM todo_items WHERE is_completed = :is_completed")
    List<TodoItem> findAllWhereCompleted(@Param("is_completed") boolean isCompleted);

    @Modifying
    @Query("DELETE FROM todo_items WHERE id = :todo_id")
    void deleteTodoItemById(@Param("todo_id") Long id);

    @Query("SELECT * FROM todo_items WHERE id = :id")
    TodoItem findByTodoId(@Param("id") Long id);

    @Modifying
    @Query("UPDATE todo_items SET name = :data, is_completed = :completed WHERE id = :id")
    void updateTodoItem(@Param("id") Long id, @Param("data") String data, @Param("completed") Boolean completed);
}
