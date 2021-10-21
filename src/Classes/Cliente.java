
package Classes;

/**
 *
 * @author juanc
 */
public class Cliente {
    int key;
    String firstName, lastName, ci;
    Cliente next;
    
    public Cliente(int key, String firstName, String lastName, String ci, Cliente nextClient) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ci = ci;
        this.next = nextClient;
    }
}
