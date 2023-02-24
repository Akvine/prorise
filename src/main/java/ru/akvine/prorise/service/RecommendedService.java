package ru.akvine.prorise.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.tech.NeuralNetwork;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RecommendedService {
    private final NeuralNetwork neuralNetwork;

    public List<Object> recommend() {
        return Stream
                .of()
                .collect(Collectors.toList());
    }
}
