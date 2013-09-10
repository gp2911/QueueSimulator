import queuesimulator.*;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.*;
/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 8:41 AM
 * To change this template use File | Settings | File Templates.
 *
 * TODO: Variable probability distribution function
 */

public class QueueSimulator {
    public static void main( String args[] ){
        int time=2;
        int numOfCounters=0;
        boolean repeat = false;
        Queue<QueueMember> entryList= new LinkedList<QueueMember>();
        Queue<QueueMember> exitList = new LinkedList<QueueMember>();
        BufferedReader inputBuffer = new BufferedReader( new InputStreamReader( System.in));
        System.out.print("How many counters?   ");
        try{
            numOfCounters = Integer.parseInt(inputBuffer.readLine());
        }
        catch ( Exception e ){
            System.out.println("I/O exception... "+ e.toString());
            e.printStackTrace();
        }
        List<QueueCounter> queueCounters = new ArrayList<QueueCounter>(numOfCounters);
        System.out.print("Initialise all counters?   ");
        char choice = 'x';
        do{
            repeat = false;
            try{
                choice = inputBuffer.readLine().charAt(0);
            }
            catch (Exception e){
                System.out.println( e.toString());
                e.printStackTrace();
            }
            if(choice == 'y'){
                for (int i=1; i <= numOfCounters; i++){
                    System.out.print("Stock to be filled in counter "+ i +" ?       ");
                    int stock = 0;
                    try{
                        stock = Integer.parseInt(inputBuffer.readLine());
                    }
                    catch (Exception e){
                        System.out.println(e.toString());
                        e.printStackTrace();
                    }
                    QueueCounter counter = new QueueCounter(stock, i);
                    queueCounters.add(counter);
                }
            }
            else if(choice == 'n'){
                for (int i=1; i <= numOfCounters; i++){
                    QueueCounter counter = new QueueCounter(20, i);
                    queueCounters.add(counter);
                }
            }
            else {
                System.out.println("Enter y or n only...");
                repeat = true;
            }
        } while (repeat == true);

        QueueSimulatorObject q = new QueueSimulatorObject( entryList, exitList, queueCounters);

        Simulator s = new Simulator(q);
        s.start();

    }
}
