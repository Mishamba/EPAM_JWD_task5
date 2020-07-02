package com.mishamba.day5.reader;

import com.mishamba.day5.exception.ProgramException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadProcessor {
    public List<String> readLines(Path path) throws ProgramException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ProgramException("can't read from file", e);
        }
    }
}
