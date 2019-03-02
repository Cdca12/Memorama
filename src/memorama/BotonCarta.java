package memorama;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import utils.Rutinas;

/**
 *
 * @author Carlos Contreras Botón que representa una carta del memorama.
 * Contiene una imagen y un nombre, que es el título de la imagen.
 */
public class BotonCarta extends JButton {

    static final private ImageIcon IMAGEN_DEFAULT = Rutinas.AjustarImagen("./src/images/Signo.png", 100, 100);
    private ImageIcon imagen;
    private String nombre;

    public BotonCarta(ImageIcon imagen, String nombre) {
        setIcon(IMAGEN_DEFAULT);
        this.imagen = imagen;
        this.nombre = nombre;
    }

    // Tentativo a quitar
    public ImageIcon getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarCarta() {
//        setIcon(imagen);
        setEnabled(false);
        setDisabledIcon(imagen);
    }
    
    public void ocultarCarta() {
        setIcon(IMAGEN_DEFAULT);
        setEnabled(true);
    }

}
