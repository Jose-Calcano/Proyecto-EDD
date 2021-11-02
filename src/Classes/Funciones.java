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
    /**
     * Description: Actualiza el texto del txt con la información almacenada en los atributos
     */
    public void actualizarTexto() {
        if (!(this.clientesGuardado.isEmpty() || this.restaurantesGuardado.isEmpty() || this.grafoGuardado.isEmpty() || this.pedidosGuardado.isEmpty())) {
            try {
                String newTxt = "";
                newTxt += "Restaurantes \n";
                Restaurante temp1 = this.restaurantesGuardado.first;
                while (temp1 != null) {
                    String newLine = Character.toString(temp1.key) + "," + temp1.name + "," + temp1.menu + "\n";
                    newTxt += newLine;
                    temp1 = temp1.next;
                }
                newTxt += "Clientes \n";
                Cliente temp2 = this.clientesGuardado.first;
                while (temp2 != null) {
                    String newLine = Integer.toString(temp2.key) + "," + temp2.firstName + "," + temp2.lastName + "," + temp2.ci + "\n";
                    newTxt += newLine;
                    temp2 = temp2.next;
                }
                newTxt += "Pedidos \n";
                Pedido temp3 = this.pedidosGuardado.first;
                while (temp3 != null) {
                    String newLine = temp3.llegada + "," + temp3.salida + "," + temp3.pedido + "\n";
                    newTxt += newLine;
                    temp3 = temp3.next;
                }
                newTxt += "Rutas \n";
                String textoRutas = this.grafoGuardado.rutasString(clientesGuardado, restaurantesGuardado);
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
    /**
     * Description: Acomida el tamaño de una imagen ubicada en "test/Resources" al tamaño de un label
     * @param frame Label que tiene el tamaño deseado
     * @param imgName el nombre de la imagen
     */
    public void scaleImage(JLabel frame, String imgName) {
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Test/Resources/" + imgName));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        frame.setIcon(scaledIcon);
    }
    /**
     * Description: Escoge un archivo txt y carga sus datos en los atributos de la clase
     */
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
        try {
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
                this.full = true;
            } else {
                JOptionPane.showMessageDialog(null, "El archivo esta vacío");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de lectura");
        }

    }
    /**
     * Description: Actualiza el valor del grafo atributo en base a una serie de rutas dadas de la forma del txt
     * @param nuevasRutas String con las rutas (misma forma del txt)
     */
    public void actualiarGrafo(String nuevasRutas) {
        int tamaño = clientesGuardado.size + restaurantesGuardado.size;
        this.grafoGuardado = new GrafoMA(tamaño);
        String[] arr = nuevasRutas.split("\n");
        for (int i = 0; i < arr.length; i++) {
            String[] atributos = arr[i].split(",");
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
    }
    /**
     * Description: Crea un array con los platos de un restaurante
     * @param restKey la key del restaurante deseado
     * @return el array de los platos
     */
    public String[] arrayDePlatos(String restKey) {
        Restaurante temp = this.restaurantesGuardado.first;
        while (!restKey.equals(Character.toString(temp.key))) {
            temp = temp.next;
        }
        String[] arr = temp.menu.split("/");
        return arr;
    }
    /**
     * Description: Transforma una key en su respectivo indice del grafo
     * @param key key del cliente o del restaurante
     * @return indice del grafo correspondiente
     */
    public int transformToValidIndex(String key) {
        int index;
        try {
            index = Integer.parseInt(key) - 1;
        } catch (Exception e) {
            Restaurante temp = this.restaurantesGuardado.first;
            index = this.clientesGuardado.size;
            while (!key.equals(Character.toString(temp.key))) {
                index++;
                temp = temp.next;
            }
        }
        return index;
    }
    /**
     * Description: Transforma un string con la ruta mas corta entre dos nodos (separados por comas y representados por sus indices) a su version real
     * @param route String de la ruta representado con los indices del grafo
     * @return String con la ruta más corata con las keys de cada nodo
     */
    public String transformToRealRoute(String route) {
        String solution = "";
        String[] arr = route.split(",");
        for (int i = 0; i < arr.length; i++) {
            int index = Integer.parseInt(arr[i]);
            if (i == 0) {
                if (!(index >= this.clientesGuardado.size)) {
                    solution += String.valueOf(index + 1);
                } else {
                    Restaurante temp = this.restaurantesGuardado.first;
                    while (index != this.clientesGuardado.size) {
                        temp = temp.next;
                        index--;
                    }
                    solution += Character.toString(temp.key);
                }
            } else {
                if (!(index >= this.clientesGuardado.size)) {
                    solution += " --> " + String.valueOf(index + 1);
                } else {
                    Restaurante temp = this.restaurantesGuardado.first;
                    while (index != this.clientesGuardado.size) {
                        temp = temp.next;
                        index--;
                    }
                    solution += " --> " + Character.toString(temp.key);
                }
            }

        }
        return solution;
    }
}
