/*
 * Consumer.java
 *
 * A consumer is part of the producer consumer problem, and takes items out of the data structure.
 * The run method loops around a number of times, can sleep to simulate it working slower or faster.
 *
 * @author M362 Course Team.
 *
 */

package act3_3;

class Consumer extends Thread
{
    private Buffer buf;
    private final int NUM_TO_READ;
    private int read;
    
    Consumer(Buffer b,int n)
    {
        buf = b;
        NUM_TO_READ = n;
        read = 0;
    }
    
    public void run()
    {
        try
        {
            while (read < NUM_TO_READ)
            {
                try 
                {                    
                    Thread.sleep(100);
                } 
                catch (InterruptedException ex) 
                {
                    ex.printStackTrace();
                }
                int next = ((Integer)buf.get()).intValue();
                System.out.println(" read value " + next);
                read++;
            }
        }
        catch(InterruptedException e )
        {
            System.out.println("Thread interrupted: exiting without performing get");
        }
    }
}
