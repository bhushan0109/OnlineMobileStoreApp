package com.cg.oms.repositiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.Users;
@Repository
public interface IUserRepository  extends JpaRepository<Users, Integer> {
	
	Optional<Users> findByUsername(String username);

}
