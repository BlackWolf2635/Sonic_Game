## Muestra de como se implemento en Ventana_Juego el metodo resize para el ajuste del Hub
@Override
    public void resize(int width, int height) {
        
        // Ajuste de Hub Tiempo
        hub.getTiempoElement().setPosition(10, 700);
        hub.getTiempoElement().setPanelPequePosition(10, 685);
        hub.getTiempoElement().setPanelGrandeSize(160, 20);
        hub.getTiempoElement().setPanelPequeSize(120, 20);
        hub.getTiempoElement().setIconPosition(120, 660);
        hub.getTiempoElement().setIconSize(35, 30);
        hub.getTiempoElement().setEtiquetaPosition(70, 710);
        
        //Ajuste de Hub Anillos
        hub.getMonedasElement().setPosition(10, 640);
        hub.getMonedasElement().setPanelPequePosition(10, 625);
        hub.getMonedasElement().setPanelGrandeSize(160, 20);
        hub.getMonedasElement().setPanelPequeSize(120, 20);
        hub.getMonedasElement().setIconPosition(120, 600);
        hub.getMonedasElement().setIconSize(30, 35);
        hub.getMonedasElement().setEtiquetaPosition(70, 650);
        
        //Ajuste de Hub basura
        hub.getBasuraElement().setPosition(10, 580);
        hub.getBasuraElement().setPanelPequePosition(10, 565);
        hub.getBasuraElement().setPanelGrandeSize(160, 20);
        hub.getBasuraElement().setPanelPequeSize(120, 20);
        hub.getBasuraElement().setIconPosition(120, 547);
        hub.getBasuraElement().setIconSize(20, 20);
        hub.getBasuraElement().setEtiquetaPosition(70, 590);
        
        //Ajuste de Hub vidas 
        hub.getVidasElement().setPosition(10, 520);
        hub.getVidasElement().setPanelPequePosition(10, 505);
        hub.getVidasElement().setPanelGrandeSize(160, 20);
        hub.getVidasElement().setPanelPequeSize(120, 20);
        hub.getVidasElement().setIconPosition(120, 485);
        hub.getVidasElement().setIconSize(20, 20);
        hub.getVidasElement().setEtiquetaPosition(70, 530);
        
        //Ajuste de hub record 
        hub.getRecordElement().setPosition(10, 460);
        hub.getRecordElement().setPanelPequePosition(10, 445);
        hub.getRecordElement().setPanelGrandeSize(160, 20);
        hub.getRecordElement().setPanelPequeSize(120, 20);
        hub.getRecordElement().setIconPosition(120, 425);
        hub.getRecordElement().setIconSize(20, 20);
        hub.getRecordElement().setEtiquetaPosition(70, 470);
        
    }

# Diagrama de clases base

```mermaid
  classDiagram
    direction BT

    %% ------------------- CLASES PRINCIPALES -------------------
    class GameManager {
        - PantallaJuego pantallaActual
        - EstadisticasManager estadisticas
        - MultijugadorManager redLocal
        + iniciarPartida()
        + cambiarNivel()
        + finalizarJuego()
    }

    class Personaje {
        <<abstract>>
        # float velocidad
        # int vidas
        # int anillos
        # float energia
        + moverse()
        + usarHabilidadEspecial()*
        + recolectarObjeto()
        + recibirDano()
    }

    class Sonic {
        + usarHabilidadEspecial() "Tornado de Limpieza"
    }

    class Tails {
        + usarHabilidadEspecial() "Dron Reciclador"
    }

    class Knuckles {
        + usarHabilidadEspecial() "Golpe Potente"
    }

    class Nivel {
        - String nombre
        - float contaminacion
        - List~ObjetoRecolectable~ objetos
        - List~Zona~ zonas
        - List~Enemigo~ enemigos
        + actualizarContaminacion()
        + verificarVictoria()
    }

    class Robotnik {
        - int nivelAmenaza
        + sabotear()
        + lanzarTrampa()
    }

    class EstadisticasManager {
        - Map~Jugador, Puntaje~ puntajes
        + actualizarPuntaje()
        + generarRanking()
    }

    class Jugador {
        - String nombre
        - Personaje personaje
        + controlarPersonaje()
    }

    class ObjetoRecolectable {
        <<abstract>>
        - TipoObjeto tipo
        + recolectar()*
    }

    class Anillo {
        + recolectar()
    }

    class Plastico {
        + recolectar()
    }

    class EsmeraldaCaos {
        + recolectar()
    }

    class Zona {
        - boolean bloqueada
        - TipoHabilidad habilidadRequerida
        + desbloquear()
    }

    class MultijugadorManager {
        - List~Jugador~ jugadores
        + sincronizarEstado()
        + compartirRecursos()
    }

    class TipoHabilidad {
        <<enumeration>>
        CORRER
        VOLAR
        GOLPEAR
    }

    %% ------------------- RELACIONES -------------------
    GameManager "1" *-- "1" EstadisticasManager
    GameManager "1" *-- "1" MultijugadorManager
    GameManager "1" *-- "1..3" Nivel

    Personaje <|-- Sonic
    Personaje <|-- Tails
    Personaje <|-- Knuckles
    Personaje "1" -- "1" Jugador

    Nivel "1" *-- "1" Robotnik
    Nivel "1" *-- "0..*" Zona
    Nivel "1" *-- "0..*" ObjetoRecolectable

    ObjetoRecolectable <|-- Anillo
    ObjetoRecolectable <|-- Plastico
    ObjetoRecolectable <|-- EsmeraldaCaos

    MultijugadorManager "1" o-- "1..3" Jugador
    EstadisticasManager "1" *-- "1..3" Jugador

    Zona "1" --* "1" TipoHabilidad
```

# GameP

A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
