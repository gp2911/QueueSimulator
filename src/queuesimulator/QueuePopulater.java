package queuesimulator;

import java.lang.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class QueuePopulater extends Thread{
    QueueSimulatorObject q;
    public void run(){
        System.out.println("Populater ready...");
        Random randomGenerator = new Random();
        for (int idx = 1; q.isActive == true ; ++idx){
            int randomInt = randomGenerator.nextInt(10);
            QueueMember newMember = new QueueMember(randomInt, idx);
            try{
                q.entry.add(newMember);
                System.out.println("Number added : "+ newMember.getTime());
            }
            catch (Exception e){
                System.out.println("Error adding to entry queue...: "+ e.toString());
            }
            try{
                sleep ( 1000*q.populationSleepTime );
            }
            catch (Exception e){
                System.out.println("Sleep Interrupted : "+ e.toString());
            }
        }

    }
    public QueuePopulater(QueueSimulatorObject q1){
        q=q1;
    }
}
