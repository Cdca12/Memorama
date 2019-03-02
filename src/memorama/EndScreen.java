package memorama;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Carlos Contreras
 */
public class EndScreen extends JDialog implements ActionListener {

    TableroMemorama tablero;
    JButton botonMenuPrincipal, botonReiniciar, botonSalir;
    JLabel texto;

    public EndScreen(TableroMemorama tablero) {
        this.tablero = tablero;
        setSize(300, 300);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        texto = new JLabel("¡Juego completado!", SwingConstants.CENTER);
        texto.setBounds(40, 20, 200, 20);
        add(texto);

        botonMenuPrincipal = new JButton("Menú Principal");
        botonMenuPrincipal.addActionListener(this);
        botonMenuPrincipal.setBounds(70, 70, 150, 40);
        add(botonMenuPrincipal);

        botonReiniciar = new JButton("Reiniciar juego");
        botonReiniciar.addActionListener(this);
        botonReiniciar.setBounds(70, 120, 150, 40);
        add(botonReiniciar);

        botonSalir = new JButton("Salir del juego");
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        botonSalir.setBounds(70, 170, 150, 40);
        add(botonSalir);

        setModal(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JButton botonPulsado = (JButton) evt.getSource();
        if (botonPulsado == botonMenuPrincipal) {
            dispose();
            tablero.dispose();
            new MenuInicio();
            dispose();
            return;
        }
        if (botonPulsado == botonReiniciar) {
            dispose();
            tablero.dispose();
            new TableroMemorama(tablero.getNumeroCartas());
            return;
        }

    }

}
