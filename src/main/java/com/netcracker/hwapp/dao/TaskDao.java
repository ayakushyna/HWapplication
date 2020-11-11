package com.netcracker.hwapp.dao;

import com.netcracker.hwapp.model.Task;

import java.util.List;

public interface TaskDao {
    List<Task> list();

    void save(Task task);

    Task get(Long id);

    void update(Task task);

    void delete(Long id);
}
