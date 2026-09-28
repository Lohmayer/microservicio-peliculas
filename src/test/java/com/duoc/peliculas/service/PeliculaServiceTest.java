package com.duoc.peliculas.service;

import com.duoc.peliculas.Pelicula;
import com.duoc.peliculas.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PeliculaServiceTest {

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private PeliculaService peliculaService;

    @Test
    void obtenerPeliculasDevuelveListado() {
        Pelicula pelicula = new Pelicula(
                1, "Avengers: Infinity War", 2018,
                "Anthony Russo y Joe Russo",
                "Acción / Ciencia ficción",
                "Los Vengadores intentan detener a Thanos."
        );

        when(peliculaRepository.findAll())
                .thenReturn(List.of(pelicula));

        List<Pelicula> resultado = peliculaService.obtenerPeliculas();

        assertEquals(1, resultado.size());
        assertEquals("Avengers: Infinity War", resultado.get(0).getTitulo());
    }

    @Test
    void obtenerPeliculaPorIdExistente() {
        Pelicula pelicula = new Pelicula(
                1, "Avengers: Infinity War", 2018,
                "Anthony Russo y Joe Russo",
                "Acción / Ciencia ficción",
                "Los Vengadores intentan detener a Thanos."
        );

        when(peliculaRepository.findById(1))
                .thenReturn(Optional.of(pelicula));

        Optional<Pelicula> resultado =
                peliculaService.obtenerPeliculaPorId(1);

        assertTrue(resultado.isPresent());
        assertEquals("Avengers: Infinity War",
                resultado.get().getTitulo());
    }
}