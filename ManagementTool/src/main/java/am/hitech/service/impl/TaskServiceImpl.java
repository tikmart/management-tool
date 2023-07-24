package am.hitech.service.impl;

import am.hitech.model.Task;
import am.hitech.repository.TaskRepository;
import am.hitech.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task findById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public Page<Task> getAll(Pageable pageable) {
        return taskRepository.getAll(pageable);
    }
}
