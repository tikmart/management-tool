package am.hitech.service;


import am.hitech.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    Task findById(int id);

    Page<Task> getAll(Pageable pageable);


}
