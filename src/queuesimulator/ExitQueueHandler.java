package queuesimulator;

/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExitQueueHandler extends Thread {
    QueueSimulatorObject q;
    public void run(){
        System.out.println("ExitQueueHandler started...");
        while ( q.isActive || !q.exit.isEmpty() ){
            if(q.exit.isEmpty())
                continue;
            QueueMember member = q.exit.peek();
            try{
            sleep( member.items * 1000);
            }
            catch ( Exception e){
                System.out.println(e.toString());
                e.printStackTrace();
            }
            q.exit.remove();
            System.out.println("Customer "+member.custNo+" with "+member.items+" items has left the exit queue...");
        }
    }
    public ExitQueueHandler( QueueSimulatorObject q1){
        q=q1;
    }
}
