/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;

/**
 *
 * @author Dimar
 */
import javax.swing.JOptionPane;

public class Proyecto {

    public static void main(String[] args) {
        GestionEstudiantes gestion = new GestionEstudiantes();
        int opcion;

        do {
            String menu = """
                    * MENÚ DE OPCIONES *
                    1. Registrar estudiante
                    2. Mostrar lista de estudiantes
                    3. Calcular promedio general
                    4. Nota más alta
                    5. Nota más baja
                    6. Cantidad de aprobados
                    7. Cantidad de reprobados
                    8. Salir
                    """;

            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
                    double nota;
                    try {
                        nota = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota (0 a 100):"));
                        if (nota < 0 || nota > 100) {
                            JOptionPane.showMessageDialog(null, "La nota ingresada no es valid. Debe estar entre 0 y 100.");
                        } else {
                            gestion.registrarEstudiante(nombre, nota);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Nota inválida. Intente de nuevo.");
                    }
                }
                case 2 ->
                    gestion.mostrarLista();
                case 3 -> {
                    double promedio = gestion.calcularPromedio();
                    JOptionPane.showMessageDialog(null, "Promedio general: " + promedio);
                }
                case 4 -> {
                    double notaAlta = gestion.obtenerNotaMasAlta();
                    JOptionPane.showMessageDialog(null, "Nota más alta: " + notaAlta);
                }
                case 5 -> {
                    double notaBaja = gestion.obtenerNotaMasBaja();
                    JOptionPane.showMessageDialog(null, "Nota más baja: " + notaBaja);
                }
                case 6 -> {
                    int aprobados = gestion.contarAprobados();
                    JOptionPane.showMessageDialog(null, "Cantidad de aprobados: " + aprobados);
                }
                case 7 -> {
                    int reprobados = gestion.contarReprobados();
                    JOptionPane.showMessageDialog(null, "Cantidad de reprobados: " + reprobados);
                }
                case 8 ->
                    JOptionPane.showMessageDialog(null, "Gracias por preferirnos.");
                default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 8);
    }
}