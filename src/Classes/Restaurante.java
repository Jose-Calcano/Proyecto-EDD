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
    char key;
    String name;
    String menu;
    
    public Restaurante(char key, String name, String menu) {
        this.key = key;
        this.name = name;
        this.menu = menu;
    }
    /**
     * Description: Adds a new dish to the menu
     * @param dish the name of the dish
     */
    public void addDish(String dish) {
        this.menu += "/" + dish;
    }
    
    public void removeDish(String dish) {
        this.menu = menu.replaceAll(dish + "/", "");
    }
    
    public static void main(String[] args) {
        
    }
}
