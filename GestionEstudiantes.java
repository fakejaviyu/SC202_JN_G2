/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Dimar
 */
public class GestionEstudiantes {

    private Estudiante[] estudiantes;
    private int cantidadEstudiantes;

    public GestionEstudiantes() {
        estudiantes = new Estudiante[100]; // Puedes cambiar el tamaño si necesitas más
        cantidadEstudiantes = 0;
    }

    public void registrarEstudiante(String nombre, double nota) {
        if (cantidadEstudiantes < estudiantes.length) {
            estudiantes[cantidadEstudiantes] = new Estudiante(nombre, nota);
            cantidadEstudiantes++;
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Limite de estudiantes alcanzado");
        }
    }

    public void mostrarLista() {
        if (cantidadEstudiantes == 0) {
            javax.swing.JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadEstudiantes; i++) {
            sb.append(estudiantes[i].mostrarInformacion()).append("\n");
        }
        javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
    }

    public double calcularPromedio() {
        if (cantidadEstudiantes == 0) {
            return 0;
        }
        double suma = 0;
        for (int i = 0; i < cantidadEstudiantes; i++) {
            suma += estudiantes[i].getNota();
        }
        return suma / cantidadEstudiantes;
    }

    public double obtenerNotaMasAlta() {
        if (cantidadEstudiantes == 0) {
            return 0;
        }
        double max = estudiantes[0].getNota();
        for (int i = 1; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].getNota() > max) {
                max = estudiantes[i].getNota();
            }
        }
        return max;
    }

    public double obtenerNotaMasBaja() {
        if (cantidadEstudiantes == 0) {
            return 0;
        }
        double min = estudiantes[0].getNota();
        for (int i = 1; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].getNota() < min) {
                min = estudiantes[i].getNota();
            }
        }
        return min;
    }

    public int contarAprobados() {
        int contador = 0;
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].getNota() >= 70) {
                contador++;
            }
        }
        return contador;
    }

    public int contarReprobados() {
        int contador = 0;
        for (int i = 0; i < cantidadEstudiantes; i++) {
            if (estudiantes[i].getNota() < 70) {
                contador++;
            }
        }
        return contador;
    }
}
