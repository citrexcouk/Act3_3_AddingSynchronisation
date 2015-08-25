/*
 * Main.java
 * 
 * Creates a buffer, and a producer and consumer which are started to work on the buffer.
 *
 * Created on 09 October 2006, 13:41
 *
 * @author M362 Course Team.
 */

package act3_3;


public class Main 
{    
    public static void main(String[] args) 
    {
        Buffer b = new BufferImpl(10);     // buffer size
        Thread prod = new Producer(b, 20); // number of items to be wrriten to b
        Thread cons = new Consumer(b, 20); // number of items to be read from b

        //launches producer and consumer
        prod.start();
        cons.start();
     }
}
