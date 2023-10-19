package br.com.ragnainterprise.domain;

public class Player {

    private int id;

    private String name;

    private int hand;

    private int winningCount;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHand() {
        return hand;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setHand(final int hand) {
        this.hand = hand;
    }

    public void setWinningCount(int winningCount) {
        this.winningCount = winningCount;
    }

    @Override
    public String toString() {
        return "{" + "ID: " + id + " Name: " + name + " Hand: " + hand + " Vitórias: " + winningCount + "}";
    }

}