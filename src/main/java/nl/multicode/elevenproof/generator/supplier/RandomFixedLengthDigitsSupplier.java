package nl.multicode.elevenproof.generator.supplier;

import lombok.RequiredArgsConstructor;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class RandomFixedLengthDigitsSupplier implements ObjectSupplier<String> {

    private final int digitsLength;

    @Override
    public String supply() {
        final var random = new Random();
        return IntStream.rangeClosed(0, digitsLength - 1).boxed()
                .map(r -> Integer.toString(random.nextInt(9)))
                .collect(Collectors.joining());
    }
}