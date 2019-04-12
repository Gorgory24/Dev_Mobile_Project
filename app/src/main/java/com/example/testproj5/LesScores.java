package com.example.testproj5;


public class LesScores {

    private String Nom;
    private int Score;

    public LesScores(String Nom, int Score) {
        this.Nom = Nom;
        this.Score = Score;
    }

    public String getNom() { return Nom; }

    public int getScore() { return Score; }

    public void setNom(String Nom) { this.Nom = Nom; }

    public void setScore(int Score) { this.Score = Score; }
}
