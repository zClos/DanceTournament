package com.gmail.buckartz;

import java.util.ArrayList;
import java.util.List;

public class Dancer {

    private String name;
    private List<Integer> danceProgram;
    private int danceStepCount;
    private int danceFloorSize;

    public String getName() {
        return name;
    }

    public List<Integer> getDanceProgram() {
        return danceProgram;
    }

    public int getDanceStepCount() {
        return danceStepCount;
    }

    public int getDanceFloorSize() {
        return danceFloorSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDanceProgram(DanceProgram danceProgram) {
        this.danceProgram = danceProgram.getProgram();
    }

    public void setDanceFloorSize(DanceFloor danceFloor) {
        this.danceFloorSize = danceFloor.getSize();
    }

    public int dance() {
        if (danceProgram == null) {
            System.err.println("You don't set to the dancer dance program");
            return -1;
        } else {
            ArrayList<Integer> list = new ArrayList<>(danceProgram);
            int index = 0;
            long startTime = System.currentTimeMillis();

            while (true) {
                int stepsToMove = list.get(index);

                if (stepsToMove % 2 == 0) {

                    if (stepsToMove == 0) {

                        if (danceStepCount == 0) {
                            return 0;
                        } else {
                            return danceStepCount += index;
                        }

                    } else if (stepsToMove + index < danceProgram.size()) {
                        danceStepCount += stepsToMove;
                        index += stepsToMove;
                    } else if (stepsToMove + index >= danceProgram.size()) {
                        return danceStepCount += index;
                    }

                } else {
                    if (danceStepCount == 0) {
                        return 0;
                    } else if (index - stepsToMove < 0) {
                        return danceStepCount += index;
                    } else {
                        danceStepCount += stepsToMove;
                        index -= stepsToMove;
                        if (System.currentTimeMillis() - startTime >= 1500) {
                            return -1;
                        }
                    }
                }
            }
        }
    }
}
