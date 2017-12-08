package com.gmail.buckartz;

import java.util.LinkedList;
import java.util.List;

public class DanceProgram {

    private final int MIN_DANCE_SIZE = 2;
    private final int MAX_DANCE_SIZE = 49;
    private final int MIN_STEP_COUNT_IN_ACTION = 0;
    private final int MAX_STEP_COUNT_IN_ACTION = 49;
    private final String SPLITTER = " ";

    private List<Integer> program;

    public DanceProgram(boolean isAuto) {
        if (isAuto) {
            autoProgram();
        }
    }

    public void autoProgram() {
        program = new LinkedList<>();
        for (int i = 0; i < getIntRandom(MIN_DANCE_SIZE, MAX_DANCE_SIZE); i++) {
            program.add(getIntRandom(MAX_STEP_COUNT_IN_ACTION, MIN_STEP_COUNT_IN_ACTION));
        }
    }

    public List<Integer> getProgram() {
        return program;
    }

    public void setProgram(String stringProgram) {
        String[] arrayProgram = stringProgram.split(SPLITTER);
        if (arrayProgram.length >= MIN_DANCE_SIZE && arrayProgram.length <= MAX_DANCE_SIZE) {
            program = new LinkedList<>();
            for (String stepsInAction : arrayProgram) {
                program.add(Integer.parseInt(stepsInAction));
            }
        } else {
            System.err.println("Program size must be longer than " + MIN_DANCE_SIZE
                    + " and shorter than " + MIN_DANCE_SIZE
                    + "your size of program is: " + arrayProgram.length);
        }
    }

    public void setProgram(List<Integer> program) {
        this.program = program;
    }

    private int getIntRandom(int min, int max) {
        return (int) (Math.random() * (max + 1 - min) + min);
    }
}
