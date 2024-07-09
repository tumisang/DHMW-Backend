package com.dhmw.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhmw.dto.SongDto;
import com.dhmw.service.SongService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @GetMapping("/all")
    public List<SongDto> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/by-artist/{artist}")
    public SongDto getByArtist(@PathVariable String artist) {
        return songService.getByArtist(artist);
    }

    @GetMapping("/by-title/{title}")
    public SongDto getByTitle(@PathVariable String title) {
        return songService.getByTitle(title);
    }

    @GetMapping("/by-genre/{genre}")
    public SongDto getByGenre(@PathVariable String genre) {
        return songService.getByGenre(genre);
    }

    @GetMapping("/like/{title}")
    public void getLikeSong(@PathVariable String title) {
        songService.likeSong(title);
    }

    @PostMapping("/save")
    public void saveSong(@RequestBody SongDto songDto) {
        songService.saveSong(songDto);
    }

}
