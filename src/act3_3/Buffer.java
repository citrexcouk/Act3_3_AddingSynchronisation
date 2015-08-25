/*
 * Buffer.java
 *
 * An interface for a buffer.
 * Created on 09 October 2006, 14:10
 * 
 * @author M362 Course Team.
 */

package act3_3;

public interface Buffer 
{
    public void put(Object obj)
       throws InterruptedException;		//put object into buffer
	
    public Object get()
       throws InterruptedException;             //get an object from buffer
}
