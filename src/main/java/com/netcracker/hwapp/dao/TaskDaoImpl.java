package com.netcracker.hwapp.dao;

import com.netcracker.hwapp.dao.mapper.TaskMapper;
import com.netcracker.hwapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Task> list() {
        String query = "select * from tasks";
        List<Task> tasks = jdbcTemplate.query(query, new TaskMapper());

        return tasks;
    }

    @Override
    public void save(Task task) {
        String query = "insert into tasks (title, description) values (?, ?)";

        jdbcTemplate.update(query,
                task.getTitle(),
                task.getDescription());
    }

    @Override
    public Task get(Long id) {
        String query = "select * from tasks where task_id = ?";
        Task task = jdbcTemplate.queryForObject(query, new Object[] {id}, new TaskMapper());

        return task;
    }

    @Override
    public void update(Task task) {
        String query = "update tasks set title = ?, description = ?, done = ? where task_id = ?";

        jdbcTemplate.update(query,
                task.getTitle(),
                task.getDescription(),
                task.isDone(),
                task.getTaskId());
    }

    @Override
    public void delete(Long id) {
        String query = "delete from tasks where task_id = ?";

        jdbcTemplate.update(query, id);
    }
}
