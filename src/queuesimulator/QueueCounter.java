package queuesimulator;

import queuesimulator.*;
import java.lang.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: GP
 * Date: 07/09/13
 * Time: 8:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class QueueCounter {
    boolean open;
    boolean busy;
    int index;
    int stock;
    QueueSimulatorObject queue;


    public QueueCounter(int s, int i){
        busy = false;
        open = true;
        stock = s;
        index = i;
        queue = null;
    }


    void service(QueueMember member){
        QueueServiceManager serviceManager = new QueueServiceManager( this, member, this.queue);
        serviceManager.start();
    }
}
