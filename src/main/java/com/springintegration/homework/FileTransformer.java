package com.springintegration.homework;

import java.io.IOException;
import java.nio.file.Paths;

public class FileTransformer{
    public String fileNameList(String fileName) throws IOException {
        return Paths.get(fileName).toString();
    }

}
