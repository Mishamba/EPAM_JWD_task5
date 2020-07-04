package com.mishamba.day5.reader.impl;

import com.mishamba.day5.exception.ProgramException;
import com.mishamba.day5.reader.ReadProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadProcessorImpl implements ReadProcessor {
    public List<String> readLines(Path path) throws ProgramException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ProgramException("can't read from file", e);
        }
    }
}
