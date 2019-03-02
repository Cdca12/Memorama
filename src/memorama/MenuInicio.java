package memorama;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras
 */
public class MenuInicio extends JFrame implements ActionListener {
    TableroMemorama tablero;
    JLabel texto;
    JButton btnNivelUno, btnNivelDos, btnNivelTres, btnSalir;

    public MenuInicio() {
        super("Juego Memorama");
        hazInterfaz();
        hazEscuchadores();
    }

    private void hazInterfaz() {
        setLayout(null);
        texto = new JLabel("Selecciona el número de pares");
        texto.setBounds(60, 20, 200, 20);
        add(texto);

        btnNivelUno = new JButton("8 cartas");
        btnNivelUno.setBounds(75, 70, 150, 40);
        add(btnNivelUno);

        btnNivelDos = new JButton("12 cartas");
        btnNivelDos.setBounds(75, 115, 150, 40);
        add(btnNivelDos);

        btnNivelTres = new JButton("20 cartas");
        btnNivelTres.setBounds(75, 160, 150, 40);
        add(btnNivelTres);

        btnSalir = new JButton("Salir del juego");
        btnSalir.setBounds(75, 205, 150, 40);
        add(btnSalir);

        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void hazEscuchadores() {
        btnNivelUno.addActionListener(this);
        btnNivelDos.addActionListener(this);
        btnNivelTres.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Me confío que solo necesito eventos ejecutados por botones 
        JButton botonPulsado = (JButton) evt.getSource();
        if (botonPulsado == btnNivelUno) {
        tablero = new TableroMemorama(8);
        }
        if (botonPulsado == btnNivelDos) {
        tablero = new TableroMemorama(12);
        }
        if (botonPulsado == btnNivelTres) {
        tablero = new TableroMemorama(20);
        }
        if (botonPulsado == btnSalir) {
            System.exit(0);
        }
        dispose();
    }

}
