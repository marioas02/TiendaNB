/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import javax.lang.model.SourceVersion;

/**
 *
 * @author MarioAguirre
 */
public class Opinion implements Comparable<Opinion>{
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

    @Override
    public int compareTo(Opinion o) {

        int primerord = 0;
        int segunord = 0;
        if(this.puntuacion.equals(ClassPuntuacion.Mal)){
            primerord = 1;
        }
        if (this.puntuacion.equals(ClassPuntuacion.Regular)) {
            primerord = 2;
        }
        if (this.puntuacion.equals(ClassPuntuacion.Bien)) {
            primerord = 3;
        }
        if (this.puntuacion.equals(ClassPuntuacion.Perfecto)) {
            primerord = 4;
        }
        if (o.puntuacion.equals(ClassPuntuacion.Mal)) {
            segunord = 1;
        }
        if (o.puntuacion.equals(ClassPuntuacion.Regular)) {
            segunord = 2;
        }
        if (o.puntuacion.equals(ClassPuntuacion.Bien)) {
            segunord = 3;
        }
        if (o.puntuacion.equals(ClassPuntuacion.Perfecto)) {
            segunord = 4;
        }
        
        //Comparamos y retornamos las opiniones.
        if(this.puntuacion.equals(o.puntuacion)){
            return 0;
        }
        if(primerord < segunord){
            return 1;
        }else{
            return -1;
        }
    }
}
