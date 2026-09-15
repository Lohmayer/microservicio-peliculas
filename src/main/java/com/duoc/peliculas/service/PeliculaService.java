package com.duoc.peliculas.service;

import com.duoc.peliculas.Pelicula;
import com.duoc.peliculas.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> obtenerPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> obtenerPeliculaPorId(int id) {
        return peliculaRepository.findById(id);
    }

    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Optional<Pelicula> actualizarPelicula(
            int id,
            Pelicula pelicula
    ) {
        if (peliculaRepository.existsById(id)) {
            pelicula.setId(id);
            return Optional.of(peliculaRepository.save(pelicula));
        }

        return Optional.empty();
    }

    public boolean eliminarPelicula(int id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}