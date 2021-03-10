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

    private ClassPuntuacion puntuacion;
    private String comentario;
    private int votopositivo;
    private int votonegativo;

    public Opinion() {

    }
/////////hjloas
    public Opinion(ClassPuntuacion puntuacion, String comentario) {
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.votopositivo = 0;
        this.votonegativo = 0;
    }

    public int darVotoPositivo(int votopositivo) {
        return votopositivo++;
    }

    public int darVotoNegativo(int votopositivo) {
        return votopositivo--;
    }

}
