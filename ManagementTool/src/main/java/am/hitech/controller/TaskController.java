package am.hitech.controller;

import am.hitech.model.Task;
import am.hitech.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Task> getById(@RequestParam int id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        Page<Task> tasks = taskService.getAll(pageable);
        return ResponseEntity.ok(tasks);
    }

}
