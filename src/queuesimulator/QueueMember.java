package queuesimulator;

/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 8:31 AM
 * To change this template use File | Settings | File Templates.
 */


public class QueueMember {
    int time;
    int items;
    int custNo;
    public int getTime(){
        return time;
    }
    public  int getItems(){
        return items;
    }
    public QueueMember(int n, int c){
        time = n;
        custNo = c;
    }
}

