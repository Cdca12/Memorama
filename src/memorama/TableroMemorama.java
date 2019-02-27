/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorama;

import java.awt.*;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author ADM
 */
public class TableroMemorama extends JFrame {
    
    public TableroMemorama() {
        super("Juego de Memorama");
        hazInterfaz();
        hazEscuchadores();
    }
    
    private void hazInterfaz() {
        for (int i = 0; i < 12; i++) {
//            add(new JButton(Rutinas));
        }
        
        
        setLayout(new GridLayout(0, 3));
        setSize(new Dimension(650, 650));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void hazEscuchadores() {
        
    }
}
