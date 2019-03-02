/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;

/**
 *
 * @author ADM
 */
public class TableroMemorama extends JFrame implements ActionListener {

    private final String[] CARTAS_MEMORAMA = {
        "Mario", "DK", "Samus", "Kirby", "Fox", "Captain Falcon", "Luigi", "Pacman", "Sonic", "Megaman"
    };

    private BotonCarta[] cartasMemorama;
    private BotonCarta cartaAuxiliar;
    private int puntuacion;
    private int numeroCartas;
    private int numeroPares;

    public TableroMemorama(int numeroCartas) {
        super("Memorama Super Smash Bros");
        this.numeroCartas = numeroCartas;
        puntuacion = 0;
        setLayout(new GridLayout(0, 4, 4, 4));
        setSize(650, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        generarCartas();
        setVisible(true);
    }
    
    public int getNumeroCartas() {
        return numeroCartas;
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
//        if (true) { // Test
        if (cartaAuxiliar.getNombre().compareTo(cartaPulsada.getNombre()) == 0) {
            puntuacion++;
            cartaAuxiliar = null;
            if (puntuacion == numeroPares) {
                Toolkit.getDefaultToolkit().beep(); // TODO: Sonido agradable de ganador
                new EndScreen(this);
//                JOptionPane.showMessageDialog(null,"¡Has Ganado!");
                return;
            }
            return;
        }
        update(getGraphics());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TableroMemorama.class.getName()).log(Level.SEVERE, null, ex);
        }
        cartaAuxiliar.ocultarCarta();
        cartaAuxiliar = null;
        cartaPulsada.ocultarCarta();
    }

    public void generarCartas() {
        numeroPares = numeroCartas / 2;
        cartasMemorama = new BotonCarta[numeroCartas];
        String nombreArchivo;
        ImageIcon imagenCarta;
        BotonCarta botonCarta;

//<editor-fold defaultstate="collapsed" desc="TODO: Añadir todos los personajes y añadir de forma aleatoria en las cartas">
//        int index;
//        for (int i = 0; i < numeroCartas; i++) {
////            index = new Random().nextInt((cartasMemorama.length - 1) + 0);
//            nombreArchivo = "./src/images/" + CARTAS_MEMORAMA[i] + ".png";
//            imagenCarta = Rutinas.AjustarImagen(nombreArchivo, 100, 100);
//            botonCarta = new BotonCarta(imagenCarta, CARTAS_MEMORAMA[i]);
//            botonCarta.addActionListener(this);
//            cartasMemorama[i] = botonCarta;
////
////            botonCarta = new BotonCarta(imagenCarta, CARTAS_MEMORAMA[index]);
////            botonCarta.addActionListener(this);
////            cartasMemorama[i + 1] = botonCarta;
//        }
//        int indexMemorama = 0;
//        for (int i = 0; i < (numeroPares - 1); i++) {
//            indexMemorama = new Random().nextInt((cartasMemorama.length - 1) + 1);
//            nombreArchivo = "./src/images/" + CARTAS_MEMORAMA[indexMemorama] + ".png";
//            imagenCarta = Rutinas.AjustarImagen(nombreArchivo, 100, 100);
//            botonCarta = new BotonCarta(imagenCarta, CARTAS_MEMORAMA[indexMemorama]);
//            botonCarta.addActionListener(this);
//            cartasMemorama[i] = botonCarta;
//
//            botonCarta = new BotonCarta(imagenCarta, CARTAS_MEMORAMA[indexMemorama]);
//            botonCarta.addActionListener(this);
//            cartasMemorama[i+1] = botonCarta;
//        }
//</editor-fold>
        
// Añadir 2 veces cada uno
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
        barajear(cartasMemorama);
        // Añade
        for (int i = 0; i < cartasMemorama.length; i++) {
            add(cartasMemorama[i]);
        }
    }

    private void barajear(BotonCarta[] cartasMemorama) {
        BotonCarta aux;
        int posicionA, posicionB;
        for (int i = 0; i < 50; i++) {
            posicionA = new Random().nextInt((cartasMemorama.length - 1) + 1); // new Random().nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
            posicionB = new Random().nextInt((cartasMemorama.length - 1) + 1);
            // Intercambia
            aux = cartasMemorama[posicionA];
            cartasMemorama[posicionA] = cartasMemorama[posicionB];
            cartasMemorama[posicionB] = aux;
        }
    }
}
