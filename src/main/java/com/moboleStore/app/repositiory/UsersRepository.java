package com.moboleStore.app.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moboleStore.app.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByEmailId(String emailId);;
}
