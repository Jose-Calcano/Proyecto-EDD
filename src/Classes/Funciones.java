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
    ListaClientes ListaDeClientes = new ListaClientes();
    ListaRestaurantes ListaDeRestaurantes = new ListaRestaurantes();
    ListaPedidos ListaDePedidos = new ListaPedidos();

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
                try ( PrintWriter pw = new PrintWriter(ruta)) {
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

        /*System.out.println(splitFinal[1]); //Restaurante

        System.out.println(splitPedidos[0]); //Clientes

        System.out.println(splitRutas[0]); //Pedidos

        System.out.println(splitRutas[1]); //Rutas*/

        Funciones test = new Funciones();

        test.crearClientes(splitPedidos[0]);
        System.out.println("\n");
        test.crearRestaurantes(splitFinal[1]);
        System.out.println("\n");
        test.crearPedidos(splitRutas[0]);
        System.out.println("\n");
        test.crearRutas(splitRutas[1]);

    }

    public void crearClientes(String clientes) {
        Funciones contar = new Funciones();
        int clientesIteracion = contar.countLines(clientes);
        String print = clientes.replace(",", "\n");
        //System.out.println(print);
        //for (int i = 0; i <= clientesIteracion; i++) {
         //   String e = String.valueOf(i);
            print = print.replace(".", "");
       // }
        try ( BufferedReader bufReader = new BufferedReader(new StringReader(print))) {
            String line;
            int contador = 0;
            int parametro1 = 0;
            int contador2 = 0;
            String parametro2 = "";
            String parametro3 = "";
            String parametro4 = "";
         
            
            while ((line = bufReader.readLine()) != null) {
                if(contador == 1){
                     parametro1 = Integer.parseInt(line);
                     System.out.println(parametro1);
                }
                if(contador != 0 && contador == 2){
                    parametro2 = line;
                     System.out.println(parametro2);
                }
                if(contador != 0 && contador == 3){
                    parametro3 = line;
                    System.out.println(parametro3);
                }
                if(contador != 0 && contador == 4){
                    ++contador2;
                    parametro4 = line;
                    Cliente nuevoCliente = new Cliente(parametro1, parametro2, parametro3, parametro4);
                    ListaDeClientes.addAtTheEnd(nuevoCliente);
                    contador = 0;
                    System.out.println(parametro4);
                }
              //  System.out.println(contador + ") " +  line);
                ++contador;
            }
        } catch (Exception e) {
        }
    }
    
        public void crearRestaurantes(String restaurantes) {
        Funciones contarRestaurantes = new Funciones();
        int RestauranteIteracion = contarRestaurantes.countLines(restaurantes);
        String printRestaurantes = restaurantes.replace(",", "\n");
            System.out.println(printRestaurantes);
        try ( BufferedReader bufReaderRestuarante = new BufferedReader(new StringReader(printRestaurantes))) {
            String lineR;
            int contador = 0;
            String parametro1 = "";
            int contador2 = 0;
            String parametro2 = "";
            String parametro3 = "";
            String parametro4 = "";
         
            
            while ((lineR = bufReaderRestuarante.readLine()) != null) {
                
                if(contador == 1){
                     parametro1 = lineR;
                     System.out.println(parametro1);
                }
                if(contador != 0 && contador == 2){
                    parametro2 = lineR;
                     System.out.println(parametro2);
                }
                if(contador != 0 && contador == 3){
                    ++contador2;
                    parametro4 = lineR;
                    Restaurante nuevoRestaurante = new Restaurante(parametro1.charAt(0), parametro2, parametro3);
                    ListaDeRestaurantes.addAtTheEnd(nuevoRestaurante);
                    contador = 0;
                    System.out.println(parametro4);
                }
              //  System.out.println(contador + ") " +  line);
                ++contador;
                ++contador2;
                if(contador2 == RestauranteIteracion){
                break;
                }
            }
        } catch (Exception e) {
        }
    }
        
            public void crearPedidos(String pedidos) {
        String printPedidos = pedidos.replace(",", "\n");
        System.out.println(printPedidos);
        Funciones contarPedidos = new Funciones();
        int pedidosIteracion = contarPedidos.countLines(pedidos);
        try ( BufferedReader bufReaderRestuarante = new BufferedReader(new StringReader(printPedidos))) {
            String lineR;
            int contador = 0;
            String parametro1 = "";
            int contador2 = 0;
            String parametro2 = "";
            String parametro3 = "";
            String parametro4 = "";
         
            
            while ((lineR = bufReaderRestuarante.readLine()) != null) {
                if(contador2 == pedidosIteracion){
                break;
                }
                if(contador == 1){
                     parametro1 = lineR;
                     System.out.println(parametro1);
                }
                if(contador != 0 && contador == 2){
                    parametro2 = lineR;
                     System.out.println(parametro2);
                }

                if(contador != 0 && contador == 3){
                    ++contador2;
                    parametro4 = lineR;
                    Pedido nuevoPedido = new Pedido(parametro1, parametro2, parametro3);
                    ListaDePedidos.addAtTheEnd(nuevoPedido);
                    contador = 0;
                    System.out.println(parametro4);
                }
              //  System.out.println(contador + ") " +  line);
                ++contador;
                ++contador2;
            }
        } catch (Exception e) {
        }
    }
    public void crearRutas(String rutas) {
        String printRutas = rutas.replace(",", "\n");
        System.out.println(printRutas);
        Funciones contarRutas = new Funciones();
        int pedidosIteracion = contarRutas.countLines(rutas);
        try ( BufferedReader bufReaderRutas = new BufferedReader(new StringReader(printRutas))) {
            String lineR;
            int contador = 0;
            String parametro1 = "";
            int contador2 = 0;
            int parametro2 = 0;
            int parametro3 = 0;
     
         
            
            while ((lineR = bufReaderRutas.readLine()) != null) {
                if(contador2 == pedidosIteracion){
                break;
                }
                if(contador == 1){
                     parametro1 = lineR;
                     System.out.println(parametro1);
                }
                if(contador != 0 && contador == 2){
                     parametro2 = Integer.parseInt(lineR);
                     System.out.println(parametro2);
                }

                if(contador != 0 && contador == 3){
                    ++contador2;
                    parametro3 = Integer.parseInt(lineR);
                    Pedido nuevoRutas = new Pedido(parametro1, parametro2, parametro3);
                    ListaDePedidos.addAtTheEnd(nuevoPedido);
                    contador = 0;
                    System.out.println(parametro4);
                }
              //  System.out.println(contador + ") " +  line);
                ++contador;
                ++contador2;
            }
        } catch (Exception e) {
        }
    }

    public int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }
}
