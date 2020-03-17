package com.challange.reply;

public class Desk {
    private int row, place;
    private int type;
    private double deskScore;
    private boolean taken;

    public  Desk(int row, int place, int type){
        this.row = row;
        this.place = place;
        this.type = type;
        this.deskScore = 0;
        this.taken = false;
    }

    public Desk() {
    }

    public boolean nextTo(Desk desk){
        return ((row == desk.row+1 || row == desk.row-1 || row == desk.row)
                && (place == desk.place+1 || place == desk.place-1 || place == desk.place)
                && (place != desk.place && row != desk.row));
    }

    public double getDeskScore() {
        return deskScore;
    }

    public void setDeskScore(double deskScore) {
        this.deskScore = deskScore;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "row=" + (row+1) +
                ", place=" + (place+1) +
                ", type=" + type +
                ", taken=" + taken +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Desk desk = (Desk) o;

        if (row != desk.row) return false;
        if (place != desk.place) return false;
        if (type != desk.type) return false;
        return taken == desk.taken;
    }

}
