package queuesimulator;

/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 23/09/13
 * Time: 2:42 AM
 */

/**
 *  Class       : Timer
 *  Package     : queuesimulator
 *
 *  Class Description:
 *             Timer is the thread which is used to simulate a real-time clock.
 *             Its run() is just one stmt : q.time++
 *  Scope for Implementation and Modification:
 *              User just needs to extend this class and use it. It is problem-generic and trivial.
 *              There is a huge scope for modification. However any modification will make the resulting class more
 *              problem oriented.
 */

public class Timer implements Runnable{
    QueueSimulatorObject q;
    public Timer(QueueSimulatorObject  q1){
        q=q1;
    }

    public void run(){
        //increment q.time
        q.time++;
    }

    public void resetTime(){
        q.time=0;
    }
}
