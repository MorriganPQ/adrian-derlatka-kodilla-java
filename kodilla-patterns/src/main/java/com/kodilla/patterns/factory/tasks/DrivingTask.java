package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {
    final private String taskName;
    final private String where;
    final private String using;
    private boolean isTaskExecuted = false;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("[Executing task] " + taskName + ": Driving to " + where + " using " + using);
        isTaskExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
