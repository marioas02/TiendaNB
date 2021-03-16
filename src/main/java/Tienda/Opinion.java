/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

/**
 *
 * @author MarioAguirre
 */
public class Opinion {
    private Usuario user;
    private ClassPuntuacion puntuacion;
    private String comentario;
    private int votoPositivo;
    private int votoNegativo;

    /**
     * Constructor vacío.
     */
    public Opinion() {
        votoPositivo=0;
        votoNegativo=0;
    }

    /**
     *
     * @param user
     * @param puntos
     * @param comentario
     */
    public Opinion(Usuario user, ClassPuntuacion puntos, String comentario) {
        this.user = user;
        this.puntuacion = puntos;
        this.comentario = comentario;
        this.votoPositivo = 0;
        this.votoNegativo = 0;
    }

    /**
     *
     * @param votoPositivo
     */
    public void votoPositivo(int votoPositivo) {
        this.votoPositivo++;
    }

    /**
     *
     * @param votoNegativo
     */
    public void votoNegativo(int votoNegativo) {
        this.votoNegativo++;
    }

    /**
     *
     * @return toString en el que te dice el Usuario, la Puntuación, Comentarios, total de votos negativos y positivos.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario = ").append(user);
        sb.append("\nPuntuacion = ").append(getPuntuacion());
        sb.append("\nComentarios = ").append(comentario);
        sb.append("\nPositivos = ").append(votoPositivo);
        sb.append("\nNegativos = ").append(votoNegativo);
        sb.append("\n").append(user);
        return sb.toString();        
    }

    /**
     * @return the puntuacion
     */
    public ClassPuntuacion getPuntuacion() {
        return puntuacion;
    }

    
}
