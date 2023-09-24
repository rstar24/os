class Task{
    private String id;
    private int remainingTime;

    public Task(String id, int remainingTime){
        this.id = id;
        this.remainingTime = remainingTime;
    }

    public String getId(){
        return id;
    }

    public int getRemainingTime(){
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime){
        this.remainingTime=remainingTime;
    }

    public void executeTasks() {
        while (!taskQueue.isEmpty()){
            Task currentTask = taskQueue.poll();
            int executionTime = Math.min(timeQuantum, currentTask.getRemainingTime());

            System.out.println("Executing Task :" + currentTask.getId() + " for " + executionTime + 
            currentTask.setRemainingTime(currentTask.getRemainingTime()-executionTime));
        
            if (currentTask.getRemainingTime() > 0){
                taskQueue.add(currentTask);
            }
        }

    }
}
