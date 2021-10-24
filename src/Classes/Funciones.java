package Classes;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author juanc
 */
public class Funciones {

    public Funciones() {

    }

    public void cargarTexto() {

    }

    public void actualizarTexto() {

    }

    public void scaleImage(JLabel frame, String imgName) {
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("build/classes/Images/" + imgName));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        frame.setIcon(scaledIcon);
    }
}
