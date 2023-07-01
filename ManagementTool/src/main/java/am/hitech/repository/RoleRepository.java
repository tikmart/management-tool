package am.hitech.repository;

import am.hitech.model.Role;
import am.hitech.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findById(int id);

    @Query(value = "select r from Role r ",
            countQuery = "select count(r) from Role r")
    Page<Role> getAll(Pageable pageable);
}
