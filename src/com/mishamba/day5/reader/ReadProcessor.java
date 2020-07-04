package com.mishamba.day5.reader;

import com.mishamba.day5.exception.ProgramException;

import java.nio.file.Path;
import java.util.List;

public interface ReadProcessor {
    List<String> readLines(Path path) throws ProgramException;
}
