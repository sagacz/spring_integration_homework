package com.springintegration.homework;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

public class FileNameGeneratorImpl implements FileNameGenerator {
    @Override
    public String generateFileName(Message<?> message) {
        return "output.txt";
    }
}
