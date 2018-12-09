package com.asolod.streams.output;

import java.io.IOException;
import java.io.PrintStream;

public class ConsoleOutputStream implements CalculatorOutputStream {

    private PrintStream out = System.out;

    @Override
    public void close() throws IOException {
        out.close();
    }

    @Override
    public void writeLine(Object object) {
        out.println(object);
    }
}
