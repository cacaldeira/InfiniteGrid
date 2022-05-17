package com.company;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;

        Coordinate objCoordinate = (Coordinate) obj;
        return objCoordinate.getX() == this.x && objCoordinate.getY() == this.y;
    }
}
