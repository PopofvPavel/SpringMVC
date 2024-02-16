package com.example.services.implementation;

import com.example.model.Director;
import com.example.repository.DirectorsRepository;
import com.example.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

    DirectorsRepository directorsRepository;

    @Autowired
    public void setDirectorsRepository(DirectorsRepository directorsRepository) {
        this.directorsRepository = directorsRepository;
    }

    @Override
    public void createDirector(Director director) {
        directorsRepository.addDirector(director);
    }

    @Override
    public void updateDirector(Director director) {
        directorsRepository.updateDirector(director);
    }

    @Override
    public Director getDirectorByFullName(String fullName) {
        try {
            return directorsRepository.getDirectorByFullName(fullName);
        } catch (DirectorNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteDirectorByFullName(String fullName) {
        Director director = getDirectorByFullName(fullName);
        directorsRepository.deleteDirector(director);
    }

    @Override
    public void getDirectors() {

    }
}
