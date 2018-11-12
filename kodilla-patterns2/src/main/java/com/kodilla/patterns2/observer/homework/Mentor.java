package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(ExerciseQueue exerciseQueue) {
        System.out.println(name + ": New exercise in " + exerciseQueue.getName() + "'s queue\n(total: " + exerciseQueue.getExercises().size() + ((exerciseQueue.getExercises().size() == 1) ? " exercise" : " exercises") + ")");
        updateCount++;
    }
}
