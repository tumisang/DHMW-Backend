package com.dhmw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dhmw.dto.SongDto;
import com.dhmw.service.SongService;

@SpringBootTest
class DhmwApplicationTests {

	@Autowired
	private SongService songService;

	@Test
	// @Ignore
	void getAllSongs() {
		songService.getAllSongs();
	}

	@Test
	void saveSongs() {
		SongDto song = new SongDto();

		song.setArtist("Hellen");
		song.setGenre("House");
		song.setLocation("c:music/DHMW-9\"");
		song.setTitle("DHMW-9");

		songService.saveSong(song);
	}

}
