package com.tunehub.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.boot.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByEmail(String email);
}
