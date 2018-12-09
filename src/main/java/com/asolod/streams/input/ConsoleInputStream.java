package com.asolod.streams.input;

import java.util.Scanner;

public class ConsoleInputStream implements CalculatorInputStream {

    private Scanner scan = new Scanner(System.in);

    @Override
    public void close() {
        this.scan.close();
    }

    @Override
    public boolean hasNext() {
        return this.scan.hasNext();
    }

    @Override
    public String next() {
        return this.scan.nextLine();
    }
}
