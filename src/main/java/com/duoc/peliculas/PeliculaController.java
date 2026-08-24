package com.duoc.peliculas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeliculaController {

    private List<Pelicula> peliculas = new ArrayList<>();

    public PeliculaController() {

        peliculas.add(new Pelicula(
                1,
                "Avengers: Infinity War",
                2018,
                "Anthony Russo y Joe Russo",
                "Acción / Ciencia ficción",
                "Los Vengadores y sus aliados intentan detener a Thanos antes de que reúna todas las Gemas del Infinito."
        ));

        peliculas.add(new Pelicula(
                2,
                "Spider-Man: No Way Home",
                2021,
                "Jon Watts",
                "Acción / Superhéroes",
                "Peter Parker busca ayuda para recuperar su identidad secreta, provocando consecuencias inesperadas en el multiverso."
        ));

        peliculas.add(new Pelicula(
                3,
                "Interstellar",
                2014,
                "Christopher Nolan",
                "Ciencia ficción",
                "Un grupo de astronautas viaja por el espacio en busca de un nuevo hogar para la humanidad."
        ));

        peliculas.add(new Pelicula(
                4,
                "El Señor de los Anillos: La Comunidad del Anillo",
                2001,
                "Peter Jackson",
                "Fantasía / Aventura",
                "Frodo Bolsón inicia un peligroso viaje para destruir el Anillo Único junto a la Comunidad del Anillo."
        ));

        peliculas.add(new Pelicula(
                5,
                "El Señor de los Anillos: Las Dos Torres",
                2002,
                "Peter Jackson",
                "Fantasía / Aventura",
                "La Comunidad se encuentra dividida mientras continúa la lucha contra las fuerzas de Sauron."
        ));
    }

    @GetMapping("/peliculas")
    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable int id) {

        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                return pelicula;
            }
        }

        return null;
    }
}