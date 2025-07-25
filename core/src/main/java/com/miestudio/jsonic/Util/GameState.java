package com.miestudio.jsonic.Util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa el estado completo del juego en un momento específico,
 * incluyendo tanto el estado de los jugadores como el estado de la contaminación.
 * Esta clase es serializable para poder ser enviada desde el servidor a los clientes.
 */
public class GameState implements Serializable {

    /**
     * Número de versión para la serialización. Incrementado a 2L debido a la adición
     * del estado de contaminación. Esto asegura compatibilidad entre versiones.
     */
    private static final long serialVersionUID = 3L; // Incrementado por la adición de sequenceNumber

    /** La lista de los estados de cada jugador en la partida. */
    private List<PlayerState> players;

    /** La lista de los estados de contaminación en el mapa. */
    private List<CorruptionState> corruptionStates;

    /** Número de secuencia para la versión del estado del juego. */
    private long sequenceNumber;

    /**
     * Constructor para el estado del juego.
     *
     * @param players Lista de estados de los jugadores
     * @param corruptionStates Lista de estados de contaminación (puede ser null)
     * @param sequenceNumber Número de secuencia de esta actualización del estado del juego
     */
    public GameState(List<PlayerState> players, List<CorruptionState> corruptionStates, long sequenceNumber) {
        this.players = players;
        this.corruptionStates = corruptionStates;
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * Constructor para compatibilidad con versiones anteriores.
     *
     * @param players Lista de estados de los jugadores
     */
    public GameState(List<PlayerState> players) {
        this(players, null, 0); // Valor por defecto para sequenceNumber
    }

    public List<PlayerState> getPlayers() {
        return players;
    }

    public List<CorruptionState> getCorruptionStates() {
        return corruptionStates;
    }

    public void setCorruptionStates(List<CorruptionState> corruptionStates) {
        this.corruptionStates = corruptionStates;
    }

    public long getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Representa el estado de un punto de contaminación en el mapa.
     */
    public static class CorruptionState implements Serializable {
        private int tileX;
        private int tileY;
        private int nivel;

        public CorruptionState() {
            // Constructor vacío necesario para serialización
        }

        public CorruptionState(int tileX, int tileY, int nivel) {
            this.tileX = tileX;
            this.tileY = tileY;
            this.nivel = nivel;
        }

        public int getTileX() {
            return tileX;
        }

        public void setTileX(int tileX) {
            this.tileX = tileX;
        }

        public int getTileY() {
            return tileY;
        }

        public void setTileY(int tileY) {
            this.tileY = tileY;
        }

        public int getNivel() {
            return nivel;
        }

        public void setNivel(int nivel) {
            this.nivel = nivel;
        }
    }
}
