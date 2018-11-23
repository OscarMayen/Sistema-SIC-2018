
package com.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Saldo implements Serializable
{
    private int idSaldo;
    private int anio;
    private double saldoInicial;
    private double saldoActual;
    private double saldoFinal;
    private int cuenta;
    private int periodo;

    private String cuenta2;
    private String periodo2;
    
    public Saldo() {
    }

    public Saldo(int idSaldo, int anio, double saldoInicial, double saldoActual, double saldoFinal, int cuenta, int periodo) {
        this.idSaldo = idSaldo;
        this.anio = anio;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
        this.saldoFinal = saldoFinal;
        this.cuenta = cuenta;
        this.periodo = periodo;
    }

    //Solo para mostrar los datos

    public Saldo(int idSaldo, int anio, double saldoInicial, double saldoActual, double saldoFinal, String cuenta2, String periodo2) {
        this.idSaldo = idSaldo;
        this.anio = anio;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
        this.saldoFinal = saldoFinal;
        this.cuenta2 = cuenta2;
        this.periodo2 = periodo2;
    }
    
    
    public int getIdSaldo() {
        return idSaldo;
    }

    public void setIdSaldo(int idSaldo) {
        this.idSaldo = idSaldo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getCuenta2() {
        return cuenta2;
    }

    public void setCuenta2(String cuenta2) {
        this.cuenta2 = cuenta2;
    }

    public String getPeriodo2() {
        return periodo2;
    }

    public void setPeriodo2(String periodo2) {
        this.periodo2 = periodo2;
    }

        
}
