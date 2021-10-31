
package Classes;

/**
 *
 * @author juanc
 */
public class Cliente {
    public int key;
    public String firstName, lastName, ci;
    public Cliente next;
    
    public Cliente(int key, String firstName, String lastName, String ci) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ci = ci;
        this.next = null;
    }
}
