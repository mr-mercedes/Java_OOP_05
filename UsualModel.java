package ru.geekbrains.oop05.mvp.homework.calculator;

import java.util.ArrayList;
import java.util.List;

public class UsualModel implements Sum, Multiplication, Diff, Division {
    private int first;
    private int second;
    private ArrayList<Character> operations =  new ArrayList<>(List.of('+', '-', '/', '*'));

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public ArrayList<Character> getOperations() {
        return operations;
    }

    @Override
    public int getDiff() {
        return this.first - this.second;
    }

    @Override
    public int getDiv() {
        return this.first / this.second;
    }

    @Override
    public int getMultiplication() {
        return this.first * this.second;
    }

    @Override
    public int getSum() {
        return this.first + this.second;
    }
}
