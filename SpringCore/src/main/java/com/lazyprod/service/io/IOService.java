package com.lazyprod.service.io;

public interface IOService {

    void writeMessage(String message);
    void writeLocalizedMessage(String message, Object... args);

    String read();

}
