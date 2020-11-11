package com.netcracker.hwapp.dao.mapper;

import com.netcracker.hwapp.model.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setTaskId(rs.getInt("task_id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setDone(rs.getBoolean("done"));
        task.setCreatedAt(rs.getDate( "created_at"));
        return task;
    }
}
