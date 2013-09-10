package queuesimulator;

/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueueServiceManager extends Thread {
    QueueCounter counter;
    QueueMember member;
    QueueSimulatorObject queue;
    public QueueServiceManager ( QueueCounter c, QueueMember m, QueueSimulatorObject q){
        counter = c;
        member = m;
        queue = q;
    }
    public void run(){
        System.out.println("Serving customer "+ member.custNo + " at counter " + counter.index +" for "+ member.time + "s..." );
        System.out.println();
        System.out.println("Transaction successful for customer "+ member.custNo);
        System.out.println();
        counter.busy=true;
        try{
        sleep(1000 * member.time);
        }
        catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        if(counter.stock >= member.time){
            counter.stock = counter.stock - member.time;
            member.items = member.time;
            member.time=0;
            queue.exit.add(member);
            System.out.println();
            System.out.println("Transaction complete for customer "+ member.custNo + " at counter "+ counter.index+" !!");
            System.out.println();
            if(counter.stock==0){
                counter.open=false;
                System.out.println();
                System.out.println();
                System.out.println("Counter "+ counter.index+1 + " out of stock! Closing down now...");
                System.out.println();
                System.out.println();
            }
        }
        else{
            member.items = counter.stock;
            counter.stock = 0;
            counter.open = false;
            member.time = 0;
            queue.exit.add(member);
            System.out.println();
            System.out.println("Transaction incomplete for customer "+ member.custNo + " at counter "+ counter.index+" !!");
            System.out.println();
            System.out.println();
            System.out.println("Counter "+ counter.index + " out of stock! Closing down now...");
            System.out.println();
            System.out.println();
        }
        counter.busy = false;
        if(counter.open==true){
            System.out.println();
            System.out.println("Counter "+ counter.index + " free !");
            System.out.println("Stock left at counter "+ counter.index + "  :   "+ counter.stock);
            System.out.println();
        }

    }
}
