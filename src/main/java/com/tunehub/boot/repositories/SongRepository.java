package com.tunehub.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.boot.entities.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {
	
	public Song findByName(String name);
}
