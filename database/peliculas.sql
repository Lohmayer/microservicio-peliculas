-- Base de datos del microservicio de películas

-- Ejecutar conectado al usuario DSY2201_PELICULAS
-- de Oracle Database.

CREATE TABLE peliculas (
    id        NUMBER(10) PRIMARY KEY,
    titulo    VARCHAR2(150 CHAR) NOT NULL,
    anio      NUMBER(4) NOT NULL,
    director  VARCHAR2(120 CHAR) NOT NULL,
    genero    VARCHAR2(100 CHAR) NOT NULL,
    sinopsis  VARCHAR2(1000 CHAR) NOT NULL
);

INSERT ALL
    INTO peliculas VALUES (
        1,
        'Avengers: Infinity War',
        2018,
        'Anthony Russo y Joe Russo',
        'Acción / Ciencia ficción',
        'Los Vengadores y sus aliados intentan detener a Thanos antes de que reúna todas las Gemas del Infinito.'
    )
    INTO peliculas VALUES (
        2,
        'Spider-Man: No Way Home',
        2021,
        'Jon Watts',
        'Acción / Superhéroes',
        'Peter Parker busca ayuda para recuperar su identidad secreta, provocando consecuencias inesperadas en el multiverso.'
    )
    INTO peliculas VALUES (
        3,
        'Interstellar',
        2014,
        'Christopher Nolan',
        'Ciencia ficción',
        'Un grupo de astronautas viaja por el espacio en busca de un nuevo hogar para la humanidad.'
    )
    INTO peliculas VALUES (
        4,
        'El Señor de los Anillos: La Comunidad del Anillo',
        2001,
        'Peter Jackson',
        'Fantasía / Aventura',
        'Frodo Bolsón inicia un peligroso viaje para destruir el Anillo Único junto a la Comunidad del Anillo.'
    )
    INTO peliculas VALUES (
        5,
        'El Señor de los Anillos: Las Dos Torres',
        2002,
        'Peter Jackson',
        'Fantasía / Aventura',
        'La Comunidad se encuentra dividida mientras continúa la lucha contra las fuerzas de Sauron.'
    )
SELECT 1 FROM dual;

COMMIT;

SELECT *
FROM peliculas
ORDER BY id;