package am.hitech.repository;

import am.hitech.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   User findById(int id);

   @Query(value = "select u from User u ",
           countQuery = "select count(u) from User u")
   Page<User> getAll(Pageable pageable);

   boolean existsByEmail(String email);

}
