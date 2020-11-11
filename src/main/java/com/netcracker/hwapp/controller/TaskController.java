package com.netcracker.hwapp.controller;

import com.netcracker.hwapp.dao.TaskDao;
import com.netcracker.hwapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskDao taskDao;

    @GetMapping()
    public String index(Model model) {
        List<Task> tasks = taskDao.list();
        model.addAttribute("tasks", tasks);

        return "tasks/task-index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        Task task = taskDao.get(id);
        model.addAttribute("task", task);

        return "tasks/task-show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("task", new Task());

        return "tasks/task-create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("task") Task task) {
        taskDao.save(task);

        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Task task = taskDao.get(id);
        model.addAttribute("task", task);

        return "tasks/task-edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("task") Task task) {
        taskDao.update(task);

        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        taskDao.delete(id);

        return "redirect:/tasks";
    }
}

