package Classes;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class Funciones {

    String line;
    String clientes_txt;

    public Funciones() {

    }

    public void actualizarTexto(ListaClientes clientes, ListaRestaurantes restaurantes, ListaPedidos pedidos, GrafoMA rutas) {
        if (!(clientes.isEmpty() || restaurantes.isEmpty() || rutas.isEmpty() || pedidos.isEmpty())) {
            try {
                String newTxt = "";
                newTxt += "Restaurantes \n";
                for (int i = 0; i < restaurantes.size; i++) {
                    Restaurante temp = restaurantes.first;
                    while (temp != null) {
                        String newLine = Character.toString(temp.key) + "," + temp.name + "," + temp.menu + "\n";
                        newTxt += newLine;
                        temp = temp.next;
                    }
                }
                newTxt += "Clientes \n";
                for (int i = 0; i < clientes.size; i++) {
                    Cliente temp = clientes.first;
                    while (temp != null) {
                        String newLine = Integer.toString(temp.key) + "," + temp.firstName + "," + temp.lastName + "," + temp.ci + "\n";
                        newTxt += newLine;
                        temp = temp.next;
                    }
                }
                newTxt += "Pedidos \n";
                for (int i = 0; i < pedidos.size; i++) {
                    Pedido temp = pedidos.first;
                    while (temp != null) {
                        String newLine = temp.llegada + "," + temp.salida + "," + temp.pedido + "\n";
                        newTxt += newLine;
                        temp = temp.next;
                    }
                }
                newTxt += "Rutas \n";
                String textoRutas = rutas.rutasString(clientes, restaurantes);
                newTxt += textoRutas;
                JFileChooser jf = new JFileChooser();
                jf.showOpenDialog(null);
                File archivo = jf.getSelectedFile();
                String ruta = archivo.getAbsolutePath();
                try (PrintWriter pw = new PrintWriter(ruta)) {
                    pw.print(newTxt);
                }
                JOptionPane.showMessageDialog(null, "Actualización exitosa.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en el catch");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error, una de las estructuras no tiene información");
        }
    }

    public void scaleImage(JLabel frame, String imgName) {
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Test/Resources/" + imgName));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        frame.setIcon(scaledIcon);
    }
    
    public void lecturaArchivo(String rutaCarga) {
        try {
            File file = new File(rutaCarga);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    clientes_txt += line + "\n";

                }
            }
        } catch (Exception e) {
   
        }
        String[] splitRestaurantes = clientes_txt.split("Clientes");
    
        String[] splitPedidos = splitRestaurantes[1].split("Pedidos");
    
        String[] splitRutas = splitPedidos[1].split("Rutas");
    
        String[] splitFinal = splitRestaurantes[0].split("Restaurantes");
    
        System.out.println(splitFinal[1]); //Restaurante
                        
        System.out.println(splitPedidos[0]); //Clientes

        System.out.println(splitRutas[0]); //Pedidos

        System.out.println(splitRutas[1]); //Rutas
        
        Funciones test = new Funciones();
        
        test.crearClientes(splitPedidos[0]);

    }

    public void crearClientes(String clientes) {
        Funciones contar = new Funciones();
        int clientesIteracion = contar.countLines(clientes);
        String print = clientes.replace(",", "\n");
        System.out.println(print);
        for (int i = 0; i <= clientesIteracion; i++) {
        }
            try ( BufferedReader bufReader = new BufferedReader(new StringReader(print))) {
                String line;
                while ((line = bufReader.readLine()) != null) {
                    System.out.println(line);
                    System.out.println("Prueba");
                }
            } catch (Exception e) {
            }
    }

    public int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }
}
