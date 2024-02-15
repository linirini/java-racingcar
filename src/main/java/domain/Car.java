package domain;

import util.Constants;

import java.util.Comparator;

import static util.Constants.MIN_FORWARD_NUMBER;
import static util.Exceptions.MAX_NAME_EXCEPTION;
import static util.Exceptions.NAME_FORMAT_EXCEPTION;

public class Car implements Comparable<Car> {
    private final String name;
    private int forward;

    public Car(String name) {
        validateCarNameLength(name);
        validateNameFormat(name);
        this.name = name;
        this.forward = 0;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_EXCEPTION.getMessage());
        }
    }

    private void validateNameFormat(String name) {
        if(name.contains(" ")) {
            throw new IllegalArgumentException(NAME_FORMAT_EXCEPTION.getMessage());
        }
    }

    // TODO: getName 삭제 제거 고려해보기
    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

    public void drive(int randomNumber) {
        if (checkForward(randomNumber)) {
            forward += 1;
        }
    }

    private boolean checkForward(int randomNumber) {
        return randomNumber >= MIN_FORWARD_NUMBER;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(forward);
    }

    @Override
    public int compareTo(Car c) {
        return Integer.compare(c.forward, forward);
    }
}
