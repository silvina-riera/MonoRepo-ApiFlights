package com.ar.bootcampJava.ApiMilesProgram.repositories;

import com.ar.bootcampJava.ApiMilesProgram.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
