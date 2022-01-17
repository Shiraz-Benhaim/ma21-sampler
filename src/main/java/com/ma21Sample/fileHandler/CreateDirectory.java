package com.ma21Sample.fileHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;

@Data
@AllArgsConstructor
public class CreateDirectory {
    private String dirName;

    /*
     * Function creates a directory if it does not exist
     * */
    public void createDirIfNotExisting() {
        File dir = new File(this.dirName);

        if (!dir.exists()) {
            dir.mkdir();
        }
    }
}
