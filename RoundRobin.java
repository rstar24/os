import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
    private Queue<Task> taskQueue;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQunatum){
        this.taskQueue = new LinkedList<>();
        this.timeQuantum = timeQunatum;
    }

    public void enqueueTask(Task task){
        taskQueue.add(task);
    }

    public void executeTasks(){
        while(!taskQueue.isEmpty()){
            Task currentTask = taskQueue.poll();
            int executionTime = Math.min(timeQuantum,currentTask.getRemainingTime());

            System.out.println("Executing task" + currentTask.getId() + " for " + executionTime + currentTask.setRemainingTime(currentTask.getRemainingTime() - executionTime));
        }
    }
}
