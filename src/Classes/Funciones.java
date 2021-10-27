package Classes;
       

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
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

    public void cargarTexto() {

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
                        String newLine = temp.llegada + "," + temp.salida+ "," + temp.pedido + "\n";
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
    
    public void lecturaArchivo(String rutaCarga){
        try {
            File file = new File(rutaCarga);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                 if (!line.isEmpty()) {
                    clientes_txt += line + "\n";

                 }
             }
        } catch(Exception e){
            
        } 
        String[] splitRestaurantes = clientes_txt.split("Clientes"); 
        
        String[] splitPedidos = splitRestaurantes[1].split("Pedidos"); 
        
        String[] splitRutas = splitPedidos[1].split("Rutas"); 
        
        String[] splitFinal = splitRestaurantes[0].split("Restaurantes"); 
        
        System.out.println(splitFinal[1]); //Restaurante

        System.out.println(splitPedidos[0]); //Clientes
        
        System.out.println(splitRutas[0]); //Pedidos
        
        System.out.println(splitRutas[1]); //Rutas
        
    }

    
//    public void creacionObjetosClientes(){
//        for (int i = 0, i <= archivo.lenght, i++){
//            
//    }
    
    public static void main(String[] args) {
        Funciones a = new Funciones();
        ListaClientes clientes = new ListaClientes();
        Cliente clinet = new Cliente(1, "Pedro", "Jose", "01830128u");
        clientes.addAtTheEnd(clinet);
        ListaRestaurantes restaurantes = new ListaRestaurantes();
        Restaurante rest = new Restaurante('A', "Juanchis Burgers", "Papas/queso/paloma");
        restaurantes.addAtTheEnd(rest);
        ListaPedidos pedidos = new ListaPedidos();
        Pedido ped = new Pedido("1", "A", "4-Papas/2-queso");
        pedidos.addAtTheEnd(ped);
        GrafoMA rutas = new GrafoMA(5);
        rutas.numVertices += 1;
        
        a.actualizarTexto(clientes, restaurantes, pedidos, rutas);
    }
    
    }

