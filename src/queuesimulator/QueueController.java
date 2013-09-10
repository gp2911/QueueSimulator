package queuesimulator;

/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 8:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class QueueController extends Thread {
    QueueSimulatorObject q;
    public void run(){
        System.out.println("Controller ready...");
        while (q.isActive ){
            if (q.entry.isEmpty())
                continue;
            try{
                QueueMember member = q.entry.remove();
                int numberBusy=0;
                int numberClosed = 0;
                for (int i=0; i < q.numberOfCounters; i++){
                    QueueCounter counter = q.counterList.get(i);
                    if(counter.open && counter.busy == false){
                        counter.service(member);
                        counter.busy=true;
                        break;
                    }

                    if(counter.open == false){
                        numberClosed++;
                        if(numberClosed == q.numberOfCounters){
                            q.isActive = false;
                            break;
                        }
                    }
                    else if (counter.busy == true){
                        numberBusy++;
                        if(numberBusy==q.numberOfCounters)
                            continue;
                    }

                }

            }
            catch (Exception e){
                System.out.println("Error removing from entry queue...: "+ e.toString());
                e.printStackTrace();
            }

        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("All counters out of stock. Queue no longer active...");
    }
    public QueueController( QueueSimulatorObject q1 ){
        q=q1;
    }

}