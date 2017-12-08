package com.gmail.buckartz;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DanceTournament {

    private Producer producer;
    private DanceFloor danceFloor;
    private boolean begin;
    private Map<Integer, Dancer> rankMap;

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public boolean startTournament() {
        this.begin = true;
        rankMap = new HashMap<>();
        return begin;
    }

    public Integer nextDancer() {
        if (isBegun()) {
            DanceProgram danceProgram = new DanceProgram(true);
            Dancer dancer = configureDancerShow(danceProgram);
            Integer stepCount = dancer.dance();
            rankMap.put(stepCount, dancer);
            return stepCount;
        }
        return -2;
    }

    public Integer nextDancer(String program) {
        if (isBegun()) {
            DanceProgram danceProgram = new DanceProgram(false);
            danceProgram.setProgram(program);
            Dancer dancer = configureDancerShow(danceProgram);
            Integer stepCount = dancer.dance();
            rankMap.put(stepCount, dancer);
            return stepCount;
        }
        return -2;
    }

    private Dancer configureDancerShow(DanceProgram program) {
        DanceFloor danceFloor = new DanceFloor();
        danceFloor.setSize(program.getProgram().size());

        Dancer dancer = new Dancer();
        dancer.setDanceProgram(program);
        dancer.setDanceFloorSize(danceFloor);
        return dancer;
    }

    public Dancer getWinner() {
        if (isBegun()) {
            SortedSet<Integer> set = new TreeSet<>(rankMap.keySet());
            return rankMap.get(set.first());
        } else {
            System.err.println("Tournament hasn't begun");
            return null;
        }
    }

    public boolean isBegun() {
        return begin;
    }


    public boolean endTournament() {
        this.begin = false;
        rankMap = null;
        return begin;
    }
}
