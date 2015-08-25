/*
 * BufferImpl.java
 *
 * A class to implement the Buffer interface.
 * It creates a circular buffer, using an array which can hold data objects.
 *
 * Note: this implementation is intentionally wrong, and is used to demonstrate the problems
 * that can arise when access is uncontrolled.
 *
 * Created on 09 October 2006, 14:13
 *
 * @author M362 Course Team.
 */

package act3_3;


public class BufferImpl implements Buffer
{
    private Object[] buf;		//the buffer, declared as an array of objects
    private int in = 0;			//index of the next place where an item can be added
    private int out= 0;			//index of the next item that can be removed
    private int count= 0;		//count of the number of items in the buffer
    private final int size;		//number of slots in the buffer
    
    public BufferImpl(int size)
    {
        this.size = size;
        buf = new Object[size];		
    }
    
    public void put(Object obj) throws InterruptedException
    {            
        System.out.println("Putting object " + obj);
        buf[in] = obj;                          //place object into buffer at index 'in'
        ++count;                                //increment count of number of items in buffer
        in = (in + 1) % size;                   //increment index 'in' using modulus operator     
    }
    
    public Object get() throws InterruptedException
    {
        Object obj = buf[out];                  //get object from buffer at index 'out'
        System.out.println("     Got object " + obj);
      
        --count;                                //decrement number of items in buffer
        out = (out + 1) % size;                 //increment index 'out'
       
        return (obj);
    }
}
