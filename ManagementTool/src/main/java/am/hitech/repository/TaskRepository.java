package am.hitech.repository;

import am.hitech.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {


    Task findById(int id);

    @Query(value = "select t from Task t ",
            countQuery = "select count(t) from Task t")
    Page<Task> getAll(Pageable pageable);

}
