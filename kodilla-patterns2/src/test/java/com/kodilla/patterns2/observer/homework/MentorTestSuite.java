package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import static org.junit.Assert.*;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        // Given
        Mentor kasiaCzechowicz = new Mentor("Kasia Czechowicz");
        Mentor andrzejJaromin = new Mentor("Andrzej Jaromin");
        Mentor mateuszRyndak = new Mentor("Mateusz Ryndak");

        ExerciseQueue adrianQueue = new ExerciseQueue(kasiaCzechowicz, "Adrian");
        ExerciseQueue piotrekQueue = new ExerciseQueue(andrzejJaromin, "Piotrek");
        ExerciseQueue aniaQueue = new ExerciseQueue(kasiaCzechowicz, "Ania");
        ExerciseQueue sylwiaQueue = new ExerciseQueue(kasiaCzechowicz, "Sylwia");
        ExerciseQueue arekQueue = new ExerciseQueue(andrzejJaromin, "Arek");
        ExerciseQueue paulinaQueue = new ExerciseQueue(mateuszRyndak, "Paulina");

        // When
        adrianQueue.addExercise("Module 5.7");
        piotrekQueue.addExercise("Module 3.4");
        aniaQueue.addExercise("Module 3.5");
        sylwiaQueue.addExercise("Module 6.8");
        arekQueue.addExercise("Module 1.4");
        paulinaQueue.addExercise("Module 3.3");
        adrianQueue.addExercise("Module 6.8");
        piotrekQueue.addExercise("Module 5.4");
        adrianQueue.addExercise("Module 12.2");
        aniaQueue.addExercise("Module 11.1");
        paulinaQueue.addExercise("Module 7.4");
        piotrekQueue.addExercise("Module 16.2");
        adrianQueue.addExercise("Module 19.3");
        adrianQueue.addExercise("Module 22.2");
        arekQueue.addExercise("Module 7.6");

        // Then
        assertEquals(8, kasiaCzechowicz.getUpdateCount());
        assertEquals(5, andrzejJaromin.getUpdateCount());
        assertEquals(2, mateuszRyndak.getUpdateCount());
    }
}
