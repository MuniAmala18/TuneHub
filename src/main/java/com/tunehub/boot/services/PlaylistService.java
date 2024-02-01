package com.tunehub.boot.services;

import java.util.List;

import com.tunehub.boot.entities.Playlist;

public interface PlaylistService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();

}
