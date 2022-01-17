package com.ma21Sample.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private final String csvRowSeparator = "\n";
    private final String csvFieldsSeparator = ",";

    /*
    * Splits a string that written in csv format, to list of items
    * content - the string in csv format
    * returns list of string arrays, that each of them is an item
    * */
    public List<String[]> splitStringInCsvFormat(String content) {
        List<String[]> result = new ArrayList<>();
        content = content.replace("\r", "");

        String[] lines = content.split(this.csvRowSeparator);
        Arrays.asList(lines).subList(1, lines.length - 1)
                .forEach(line -> result.add(line.split(csvFieldsSeparator)));

        return result;
    }
}
