package com.ma21Sample.fileHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;

@Data
@AllArgsConstructor
public class ReadFileContent {
    private String path;

    /*
     * Reads a file and returns its content
     * returns the data from the file
     * */
    public String readContent() throws IOException {
        byte[] data;
        FileInputStream fileInputStream = new FileInputStream(this.path);
        data = fileInputStream.readAllBytes();
        fileInputStream.close();
        return new String(data);
    }
}
