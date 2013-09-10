package queuesimulator;

import queuesimulator.*;

/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class Simulator extends Thread{
    QueueSimulatorObject q;
    QueuePopulater populater;
    QueueController controller;
    ExitQueueHandler exitGuard;
    public void run(){
        System.out.println("Simulating queue...");
        populater.start();
        controller.start();
        exitGuard.start();
    }
    public Simulator( QueueSimulatorObject q1){
        q=q1;
        populater = new QueuePopulater(q);
        controller = new QueueController(q);
        exitGuard = new ExitQueueHandler(q);
    }

}
