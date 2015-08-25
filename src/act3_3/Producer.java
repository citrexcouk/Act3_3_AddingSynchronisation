/*
 * Producer.java
 *
 * A producer is part of the producer consumer problem, and puts items into the data structure.
 * The run method loops around a number of times, and can sleep to simulate it working slower or faster.
 *
 *
 * @author M362 Course Team.
 */

package act3_3;


public class Producer extends Thread
{
    Buffer buf;		// the buffer used by the producer
    private int read;
    final int NUM_TO_WRITE;
    int value;
    
    Producer(Buffer b, int n)
    {
        buf = b;
        NUM_TO_WRITE = n;
        read = 0;
        value = 10;
    }
    
    public void run()
    {
        while (read < NUM_TO_WRITE)
        {
            try 
            {               
                Thread.sleep(100);
            } 
            catch (InterruptedException ex) 
            {
                ex.printStackTrace();
            }
            try
            {
                buf.put(value);	//place integer object into buffer
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            value++;            //in real life,something more important might happen
            read++;             //keep count of how many have been written
        }
    }
}
