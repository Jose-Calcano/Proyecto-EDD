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

    public GrafoMA grafoGuardado;
    public ListaClientes clientesGuardado;
    public ListaRestaurantes restaurantesGuardado;
    public ListaPedidos pedidosGuardado;
    public boolean full;

    public Funciones() {
        this.clientesGuardado = new ListaClientes();
        this.restaurantesGuardado = new ListaRestaurantes();
        this.pedidosGuardado = new ListaPedidos();
        this.full = false;
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
                this.full = true;
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

    public void cargarArchivo() {
        String info_txt = "";
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        File archivo = jf.getSelectedFile();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    info_txt += line + "\n";
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de lectura");
        }
        if (!"".equals(info_txt)) {
            String[] arr_txt = info_txt.split("\n");
            int linea = 1;
            while (!arr_txt[linea].equals("Clientes")) {
                String[] atributos = arr_txt[linea].split(",");
                Restaurante newRest = new Restaurante(atributos[0].charAt(0), atributos[1], atributos[2]);
                this.restaurantesGuardado.addAtTheEnd(newRest);
                linea += 1;
            }
            linea += 1;
            while (!arr_txt[linea].equals("Pedidos")) {
                String[] atributos = arr_txt[linea].split(",");
                Cliente newClie = new Cliente(Integer.parseInt(atributos[0]), atributos[1], atributos[2], atributos[3]);
                this.clientesGuardado.addAtTheEnd(newClie);
                linea += 1;
            }
            linea += 1;
            while (!arr_txt[linea].equals("Rutas")) {
                String[] atributos = arr_txt[linea].split(",");
                Pedido newPedi = new Pedido(atributos[0], atributos[1], atributos[2]);
                this.pedidosGuardado.addAtTheEnd(newPedi);
                linea++;
            }
            linea += 1;
            int tamaño = clientesGuardado.size + restaurantesGuardado.size;
            this.grafoGuardado = new GrafoMA(tamaño);
            for (int i = linea; i < arr_txt.length; i++) {
                String[] atributos = arr_txt[i].split(",");
                int firstIndex;
                int secondIndex;
                try {
                    firstIndex = Integer.parseInt(atributos[0]) - 1;
                } catch (Exception e) {
                    firstIndex = this.clientesGuardado.size;
                    Restaurante temp = this.restaurantesGuardado.first;
                    while (temp.key != atributos[0].charAt(0)) {
                        firstIndex += 1;
                        temp = temp.next;
                    }
                }
                try {
                    secondIndex = Integer.parseInt(atributos[1]) - 1;
                } catch (Exception e) {
                    secondIndex = this.clientesGuardado.size;
                    Restaurante temp = this.restaurantesGuardado.first;
                    while (temp.key != atributos[1].charAt(0)) {
                        secondIndex += 1;
                        temp = temp.next;
                    }
                }
                this.grafoGuardado.añadirVertice(firstIndex, secondIndex, Integer.parseInt(atributos[2]));
            }
            JOptionPane.showMessageDialog(null, "Archivo cargado en el sistema.");
        } else {
            JOptionPane.showMessageDialog(null, "El archivo esta vacío");
        }

    }
}
