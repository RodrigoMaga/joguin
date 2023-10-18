package br.com.ragnainterprise.domain;

public class Player {

    public int id;

    public String name;

    public int hand;

    public int winningCount;

    @Override
    public String toString() {
        return "{" + "ID: " + id + " Name: " + name + " Hand: " + hand + " Vitórias: " + winningCount + "}";
    }

}