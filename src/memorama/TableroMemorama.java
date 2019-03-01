/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ADM
 */
public class TableroMemorama extends JFrame implements ActionListener {

    private final String[] CARTAS_MEMORAMA = {
        "Mario", "Luigi", "Samus", "Kirby", "Fox", "Captain Falcon"
    };

    private BotonCarta[] cartasMemorama;
    private BotonCarta cartaAuxiliar;
    private int puntuacion = 0;
    private int numeroCartas = 12; // Iniciaré con 6 cartas, o sea, 3 pares
    private int numeroPares;

    public TableroMemorama() {
        super("Memorama Super Smash Bros");

        generarCartas();
        setLayout(new GridLayout(0, 4, 4, 4));
        setSize(650, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Me confío que solo necesito eventos ejecutados por botones 
        BotonCarta cartaPulsada = (BotonCarta) evt.getSource();
        cartaPulsada.mostrarCarta();
        if (cartaAuxiliar == null) {
            cartaAuxiliar = cartaPulsada;
            return;
        }
        if (cartaAuxiliar.getNombre().compareTo(cartaPulsada.getNombre()) == 0) {
            System.out.println("Iguales");
            puntuacion++;
            cartaAuxiliar = null;
            if (puntuacion == numeroCartas / 2) {
                new EndScreen();
                return;
            }
            return;
        }
        this.update(getGraphics());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TableroMemorama.class.getName()).log(Level.SEVERE, null, ex);
        }
        cartaAuxiliar.ocultarCarta();
        cartaAuxiliar = null;
        cartaPulsada.ocultarCarta();
    }
    // TODO: Usar menú para iniciar el juego. Ver clase: MenuInicio

    private void generarCartas() {
        numeroPares = numeroCartas / 2;

//      Test todas las cartas
//            String nombreArchivo;
//            ImageIcon imagenCarta;
//            BotonCarta botonCarta;
//
//            for (int i = 0; i < CARTAS_MEMORAMA.length; i++) {
//                nombreArchivo = "./src/images/" + CARTAS_MEMORAMA[i] + ".png";
//                imagenCarta = Rutinas.AjustarImagen(nombreArchivo, 100, 100);
//                botonCarta = new BotonCarta(imagenCarta, CARTAS_MEMORAMA[i]);
//                botonCarta.addActionListener(this);
//                add(botonCarta);
//            }
        cartasMemorama = new BotonCarta[numeroCartas];
        String nombreArchivo;
        ImageIcon imagenCarta;
        BotonCarta botonCarta;
        int indexMemorama = 0;
        for (int i = 0; i < numeroPares; i++, indexMemorama++) {
            nombreArchivo = "./src/images/" + CARTAS_MEMORAMA[i] + ".png";
            imagenCarta = Rutinas.AjustarImagen(nombreArchivo, 100, 100);
            botonCarta = new BotonCarta(imagenCarta, CARTAS_MEMORAMA[i]);
            botonCarta.addActionListener(this);
            cartasMemorama[indexMemorama] = botonCarta;
        }
        for (int i = 0; i < numeroPares; i++, indexMemorama++) {
            nombreArchivo = "./src/images/" + CARTAS_MEMORAMA[i] + ".png";
            imagenCarta = Rutinas.AjustarImagen(nombreArchivo, 100, 100);
            botonCarta = new BotonCarta(imagenCarta, CARTAS_MEMORAMA[i]);
            botonCarta.addActionListener(this);
            cartasMemorama[indexMemorama] = botonCarta;
        }
        // Desordena
        // Añade
        for (int i = 0; i < cartasMemorama.length; i++) {
            add(cartasMemorama[i]);
        }
    }

    private class EndScreen extends JDialog {

        JButton botonSalir;
        JLabel texto;

        private EndScreen() {
            setSize(200, 200);
            setLayout(null);
            setLocationRelativeTo(null);
            texto = new JLabel("¡Has ganado!", SwingConstants.CENTER);
            texto.setBounds(40, 40, 100, 20);
            add(texto);
            botonSalir = new JButton("Salir del juego");
            botonSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    System.exit(0); // Salir del juego
                }
            });
            botonSalir.setBounds(35, 90, 120, 40);
            add(botonSalir);
//            pack();
            setModal(true);
            setVisible(true);
        }
    }
}
