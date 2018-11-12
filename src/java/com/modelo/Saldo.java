
package com.modelo;

/**
 *
 * @author admin
 */
public class Saldo 
{
    private int idSaldo;
    private int anio;
    private double saldoInicial;
    private double saldoActual;
    private double saldoFinal;
    private int cuenta;
    private int periodo;

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
    
    
    
}
