package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
    public Team(Team<T> originalTeam) {
        this.name = originalTeam.name;
        for(T participant : originalTeam.participants) {
            T clonedParticipant = (T) participant.clone();
            participants.add(clonedParticipant);
        }
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + participant.getName());
    }

    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if(i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("The team " + winnerName + " is the winner!");
    }

    public String getName() {
        return name;
    }

    public List<T> getParticipants() {
        return participants;
    }

    public T getParticipant(int i) {
        return participants.get(i);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Team{" + "name='" + name + '\'' + ", participants=" + participants + '}';
    }

}
