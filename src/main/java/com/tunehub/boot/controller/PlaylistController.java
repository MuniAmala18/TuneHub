package com.tunehub.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.boot.entities.Playlist;
import com.tunehub.boot.entities.Song;
import com.tunehub.boot.entities.Users;
import com.tunehub.boot.services.PlaylistService;
import com.tunehub.boot.services.SongService;
import com.tunehub.boot.services.UsersService;

import jakarta.servlet.http.HttpSession;



@Controller
public class PlaylistController {
	@Autowired
	UsersService uservice;
	@Autowired
	SongService songService;
	@Autowired
	PlaylistService playlistService;
	
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		playlistService.addPlaylist(playlist);
		List<Song> songList=playlist.getSongs();
		for(Song s:songList) {
			s.getPlaylists().add(playlist);
			//update in the database
			songService.updateSong(s);
			
		}
		return "adminHome";
	}
	/*
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<Playlist> allPlaylists=playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists", allPlaylists);
		return "displayPlaylists";
	}*/
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model, HttpSession session) {
	    String email = (String) session.getAttribute("email");
	    Users user = uservice.getUser(email);

	    if (user != null) {
	        if (user.isPremium() || user.isAdmin()) {
	            List<Playlist> allPlaylists = playlistService.fetchAllPlaylists();
	            model.addAttribute("allPlaylists", allPlaylists);
	            return "displayPlaylists";
	        } else {
	            System.out.println("User is not premium or admin. Redirecting to payment page or access denied page.");
	            return "pay"; 
	        }
	    } else {
	        
	        return "login"; 
	    }
	}


	
	
}
