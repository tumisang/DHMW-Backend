package com.dhmw.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.dhmw.dao.SongDao;
import com.dhmw.dto.SongDto;
import com.dhmw.model.Song;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongDao songDao;

    public List<SongDto> getAllSongs() {
        return songDao.findAll().stream().map(song -> parseSongToSongDto(song)).toList();
    }

    public SongDto getByArtist(String artist) {
        return parseSongToSongDto(songDao.getByArtist(artist));
    }

    public void saveSong(SongDto song) {
        songDao.save(parseSongDtoToSong(song));
    }

    public SongDto getByTitle(String title) {
        return parseSongToSongDto(songDao.getByTitle(title));
    }

    public SongDto getByGenre(String genre) {
        return parseSongToSongDto(songDao.getByGenre(genre));
    }

    private SongDto parseSongToSongDto(Song song) {
        SongDto songDto = new SongDto();

        DateFormat parseFormat = new SimpleDateFormat("dd MMMM yyyy");        

        songDto.setArtist(song.getArtist());
        songDto.setDate(parseFormat.format(song.getDate()));
        songDto.setGenre(song.getGenre());
        songDto.setLocation(song.getLocation());
        songDto.setTitle(song.getTitle());
        songDto.setLikes(song.getLikes());

        return songDto;
    }

    private Song parseSongDtoToSong(SongDto songDto) {
        Song song = new Song();

        song.setArtist(songDto.getArtist());
        song.setDate(new Date());
        song.setGenre(songDto.getGenre());
        song.setLocation(songDto.getLocation());
        song.setTitle(songDto.getTitle());
        song.setLikes(0);

        return song;
    }

    public void likeSong(String title) {
        Song song = songDao.getByTitle(title);
        song.setLikes(song.getLikes()+1);
        songDao.save(song);
    }

}
