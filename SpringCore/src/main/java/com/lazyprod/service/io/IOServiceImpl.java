package com.lazyprod.service.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

@Service
public class IOServiceImpl implements IOService {

    private PrintWriter writer;
    private BufferedReader reader;
    private MessageSource messageSource;
    private Locale locale;

    @Autowired
    public IOServiceImpl(MessageSource messageSource, @Qualifier("locale") Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
        //todo change to DI
        this.writer = new PrintWriter(System.out);
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void writeMessage(String message) {
        writer.write(message);
        writer.flush();
    }

    @Override
    public void writeLocalizedMessage(String message, Object... args) {
        String finalMessage = messageSource.getMessage(message, args, this.locale);
        writer.write(finalMessage);
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
