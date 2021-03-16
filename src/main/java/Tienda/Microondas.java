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
public class Microondas extends Electrodomestico {

    private String marca;
    private String modelo;
    private int potencia;

    /**
     *
     * @param marca
     * @param modelo
     * @param potencia
     */
    public Microondas(String marca, String modelo, int potencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    /**
     *
     * @param marca
     * @param modelo
     * @param potencia
     * @param gama
     * @param clasificacionEnergetica
     * @param codigo
     * @param nombre
     * @param precio
     * @param stock
     */
    public Microondas(String marca, String modelo, int potencia, String gama, ClaseE clasificacionEnergetica, String codigo, String nombre, float precio, int stock) {
        super(gama, clasificacionEnergetica, codigo, nombre, precio, stock);
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the potencia
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * @param potencia the potencia to set
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    /**
     *
     * @return toString en el que te dice la Marca, Modelo y Potencia.
     */
    @Override
    public String toString() {
        return super.toString() + "Marca: " + getMarca() + "\nModelo: " + getModelo() + "\nPotencia: " + getPotencia() + " W\n";
    }

}
