package com.duoc.peliculas;

import com.duoc.peliculas.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> obtenerPeliculas() {
        return peliculaService.obtenerPeliculas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPeliculaPorId(
            @PathVariable int id
    ) {
        return peliculaService.obtenerPeliculaPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pelicula> crearPelicula(
            @RequestBody Pelicula pelicula
    ) {
        Pelicula peliculaCreada =
                peliculaService.crearPelicula(pelicula);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(peliculaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(
            @PathVariable int id,
            @RequestBody Pelicula pelicula
    ) {
        return peliculaService.actualizarPelicula(id, pelicula)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(
            @PathVariable int id
    ) {
        if (peliculaService.eliminarPelicula(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}