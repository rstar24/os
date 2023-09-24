import java.util.LinkedList;
import java.util.Queue;

class Task
{
  private String id;
  private int remainingTime;
  private int arrivalTime;

  public Task (String id, int remainingTime, int arrivalTime)
  {
    this.id = id;
    this.remainingTime = remainingTime;
    this.arrivalTime = arrivalTime;
  }

  public String getId ()
  {
    return id;
  }

  public int getRemainingTime ()
  {
    return remainingTime;
  }

  public void setRemainingTime (int remainingTime)
  {
    this.remainingTime = remainingTime;
  }

  public int getArrivalTime ()
  {
    return arrivalTime;
  }
}

class RoundRobinScheduler
{
  private Queue < Task > taskQueue;
  private int timeQuantum;

  public RoundRobinScheduler (int timeQuantum)
  {
    this.taskQueue = new LinkedList <> ();
    this.timeQuantum = timeQuantum;
  }

  public void enqueueTask (Task task)
  {
    taskQueue.add (task);
  }

  public void executeTasks ()
  {
    while (!taskQueue.isEmpty ())
      {
	Task currentTask = taskQueue.poll ();
	int executionTime =
	  Math.min (timeQuantum, currentTask.getRemainingTime ());

	System.out.println ("Executing task: " + currentTask.getId () +
			    " for " + executionTime + " units");

	currentTask.setRemainingTime (currentTask.getRemainingTime () -
				      executionTime);

	if (currentTask.getRemainingTime () > 0)
	  {
	    taskQueue.add (currentTask);
	  }
      }
  }
}

public class Main
{
  public static void main (String[] args)
  {
    RoundRobinScheduler scheduler = new RoundRobinScheduler (5);

    Task task1 = new Task ("Task 1", 10, 0);
    Task task2 = new Task ("Task 2", 20, 5);
    Task task3 = new Task ("Task 3", 30, 10);

      scheduler.enqueueTask (task1);
      scheduler.enqueueTask (task2);
      scheduler.enqueueTask (task3);

      scheduler.executeTasks ();
  }
}
