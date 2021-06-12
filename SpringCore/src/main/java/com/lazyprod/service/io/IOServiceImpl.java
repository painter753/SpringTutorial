package com.lazyprod.service.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOServiceImpl implements IOService {

    private PrintWriter writer;
    private BufferedReader reader;

    public IOServiceImpl() {
        //todo
        writer = new PrintWriter(System.out);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void write(String message) {
        writer.write(message);
        writer.flush();
    }

    @Override
    public String read() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}
