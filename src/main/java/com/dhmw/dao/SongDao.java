package com.dhmw.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhmw.model.Song;

public interface SongDao extends JpaRepository<Song, Long>{

    Song getByArtist(String artist);
    Song getByGenre(String genre);
    Song getByTitle(String title);
    
}
