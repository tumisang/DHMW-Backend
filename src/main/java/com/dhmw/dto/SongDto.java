package com.dhmw.dto;

import lombok.Data;

@Data
public class SongDto {

    private String title;
    private String artist;
    private String date;
    private String genre;
    private String location;
    private int likes;

}
