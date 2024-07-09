package com.dhmw.model;

import java.util.Date;
import com.dhmw.setup.Genre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="song", schema="dhmw")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="title", nullable=false, unique=true)
    private String title;
    @Column(name="artist", nullable=false, unique=false)
    private String artist;
    @Column(name="date", nullable=false, unique=false)
    private Date date;
    @Column(name="genre", nullable=false, unique=false)
    private String genre;
    @Column(name="location", nullable=false, unique=false)
    private String location;
    @Column(name="likes", nullable=true, unique=false)
    private int likes;

}
