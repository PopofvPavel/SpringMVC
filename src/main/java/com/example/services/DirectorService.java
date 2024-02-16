package com.example.services;

import com.example.model.Director;

public interface DirectorService {


    void createDirector(Director director);

    void updateDirector(Director director);

    Director getDirectorByFullName(String fullName);

    void deleteDirectorByFullName(String fullName);

    void getDirectors();
}
