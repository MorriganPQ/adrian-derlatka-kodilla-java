package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class ExerciseQueue implements Observable {
    private final Observer observer;
    private final List<String> exercises;
    private final String name;

    public ExerciseQueue(final Observer observer, final String name) {
        this.observer = observer;
        this.exercises = new ArrayList<>();
        this.name = name;
    }

    public List<String> getExercises() {
        return exercises;
    }

    public String getName() {
        return name;
    }

    public void addExercise(String exercise) {
        exercises.add(exercise);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observer.update(this);
    }
}
