package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Game {
    private Coordinate currCoordinate;
    private final List<Coordinate> pastCoordinates;

    private int counter;

    public Game() {
        currCoordinate = new Coordinate(0, 0);
        pastCoordinates = new ArrayList<>();
        pastCoordinates.add(currCoordinate);

        counter = 1;
    }

    public void play() {
        System.out.println("Movement (N S E O):");
        Scanner scanner = new Scanner(System.in);

        String directions = scanner.hasNextLine() ? scanner.nextLine() : "";

        scanner.close();

        directions = cleanDirections(directions);

        for (char c : directions.toCharArray())
            move(c);

        System.out.println("Caught: " + counter);
    }

    private String cleanDirections(String directions) {
        if (directions == null || directions.isBlank())
            return "";

        directions = directions.toUpperCase(Locale.ROOT);
        directions = directions.trim();

        return directions;
    }

    private void move(char direction) {
        int currX = currCoordinate.getX(), currY = currCoordinate.getY();

        switch (direction) {
            case 'N':
                currY++;
                break;

            case 'S':
                currY--;
                break;

            case 'E':
                currX++;
                break;

            case 'O':
                currX--;
                break;

            default:
                //System.out.println("Unexpected input: " + direction);
                return;
        }

        currCoordinate = findCoordinate(currX, currY);

        if (!pastCoordinates.contains(currCoordinate)) {
            pastCoordinates.add(currCoordinate);
            counter++;
        }

    }

    private Coordinate findCoordinate(int currX, int currY) {
        Coordinate coordinate = new Coordinate(currX, currY);
        for (Coordinate c : pastCoordinates)
            if (coordinate.equals(c))
                return c;

        return coordinate;
    }

}
