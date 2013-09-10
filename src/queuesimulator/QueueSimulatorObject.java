package queuesimulator;

import java.util.*;
import java.io.*;


/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 8:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class QueueSimulatorObject {
    Queue<QueueMember> entry;
    Queue<QueueMember> exit;
    List<QueueCounter> counterList;
    int numberOfCounters;
    boolean isActive;
    int populationSleepTime;
    String probFile;
//    QueueController controller = new QueueController();

    public QueueSimulatorObject ( Queue<QueueMember> q1, Queue<QueueMember> q2, List<QueueCounter> cl){
        entry = q1;
        exit = q2;
        counterList = cl;
        numberOfCounters = counterList.size();
        System.out.println(numberOfCounters);
        for(int i=0; i< numberOfCounters; i++){
            counterList.get(i).queue = this;
        }
        isActive = true;
        System.out.println("Population sleep time? ");
        BufferedReader inputBuffer = new BufferedReader( new InputStreamReader( System.in));
        try{
            populationSleepTime = Integer.parseInt(inputBuffer.readLine());
        }
        catch (Exception e){
            System.out.println("I/O Error :" + e.toString());
            e.printStackTrace();
        }
    }

//    public  QueueSimulatorObject (){
//        entry = new LinkedList<QueueMember>();
//        exit= new LinkedList<QueueMember>();
//        counterList = new ArrayList<QueueCounter>(5);
//        for(int i=0; i<5; i++){
//            QueueCounter counter = new QueueCounter(20, i);
//            counterList.add(i,counter);
//        }
//        numberOfCounters = counterList.size();
//        System.out.println(numberOfCounters);
//        isActive = true;
//        populationSleepTime = 2;
//    }

//    public QueueSimulatorObject (int n){
//        entry = new LinkedList<QueueMember>();
//        exit = new LinkedList<QueueMember>();
//        counterList = new ArrayList<QueueCounter>(n);
//        for (QueueCounter counter : counterList ) {
//                   counter = new QueueCounter(20,1);
//        }
//        isActive=true;
//        populationSleepTime = 2;
//    }


}
