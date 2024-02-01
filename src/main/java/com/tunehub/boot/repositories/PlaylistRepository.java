package com.tunehub.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.boot.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
