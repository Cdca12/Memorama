package memorama;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Carlos Contreras
 */
public class MenuInicio extends JDialog implements ActionListener {

        JButton btnNivelUno, btnNivelDos, btnNivelTres, btnSalir;

        public MenuInicio() {
            hazInterfaz();
            hazEscuchadores();
        }

        private void hazInterfaz() {
            btnNivelUno = new JButton("12 pares");
            btnNivelDos = new JButton("16 pares");
            btnNivelTres = new JButton("20 pares");
            btnSalir = new JButton("Salir del juego");
            add(new JLabel("Selecciona el número de pares"), BorderLayout.NORTH);

            JPanel opciones = new JPanel();
            opciones.setLayout(new GridLayout(0, 1));
            opciones.add(btnNivelUno);
            opciones.add(btnNivelDos);
            opciones.add(btnNivelTres);
            opciones.add(btnSalir);
            add(opciones, BorderLayout.CENTER);

//            setLocationRelativeTo(null);
            setSize(300, 300);
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
                System.out.println("Nivel 1");
                dispose();
                return;
            }
            if (botonPulsado == btnNivelDos) {
                System.out.println("Nivel 2");
                return;
            }
            if (botonPulsado == btnNivelTres) {
                System.out.println("Nivel 3");
                return;
            }
            if (botonPulsado == btnSalir) {
                System.out.println("Salir del juego");
                System.exit(0);
            }
        }

    }


