package com.asolod.streams.output;

import java.io.Closeable;

public interface CalculatorOutputStream extends Closeable {

    void writeLine(Object object);
}
