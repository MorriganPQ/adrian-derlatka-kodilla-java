package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task {
    final private String taskName;
    final private String color;
    final private String whatToPaint;
    private boolean isTaskExecuted = false;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("[Executing task] " + taskName + ": Painting " + whatToPaint + " using " + color + " dye");
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
