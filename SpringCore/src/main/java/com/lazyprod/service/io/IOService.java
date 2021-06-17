package com.lazyprod.service.io;

import java.util.Locale;

public interface IOService {

    void write(String message);
    void writeLocalized(String message, Locale locale, Object... args);

    String read();


}
