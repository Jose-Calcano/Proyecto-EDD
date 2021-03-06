/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author juanc
 */
public class Restaurante {
    public char key;
    public String name;
    public String menu;
    public Restaurante next;
    
    public Restaurante(char key, String name, String menu) {
        this.key = key;
        this.name = name;
        this.menu = menu;
        this.next = null;
    }
    /**
     * Description: Adds a new dish to the menu
     * @param dish the name of the dish
     */
    public void addDish(String dish) {
        this.menu += "/" + dish;
    }
    /**
     * Description: removes a dish from the menu
     * @param dish the name of the dish
     */
    public void removeDish(String dish) {
        this.menu = menu.replaceAll("/" + dish, "");
    }
    
}
