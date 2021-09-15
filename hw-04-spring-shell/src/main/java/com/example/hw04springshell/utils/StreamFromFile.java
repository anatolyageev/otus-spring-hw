package com.example.hw04springshell.utils;

import java.util.List;

public interface StreamFromFile {
    List<String[]> readFileAsStream(int skipLine) throws Exception;
}
