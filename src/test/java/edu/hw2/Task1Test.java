package edu.hw2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static edu.hw2.Task1.Expr.*;
import static org.assertj.core.api.Assertions.*;

public class Task1Test {
    @ParameterizedTest(name = "{index} - check get constant with {0}")
    @ValueSource(doubles = {0.0, 0.1, 100})
    public void checkConstant(double constant) {
        assertThat(Double.valueOf(constant).equals((new Constant(constant)).evaluate())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check negate with {0}")
    @ValueSource(doubles = {0.0, 0.1, 100})
    public void checkNegate(double constant) {
        assertThat(Double.valueOf(-constant)
            .equals((new Negate(new Constant(constant))).evaluate())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check negate with {0}")
    @CsvSource({
        "10.0, 2.0",
        "16.0, -1.0",
        "100.0, 0.5"
    })
    public void checkExponent(double base, double power) {
        assertThat(Double.valueOf(Math.pow(base, power))
            .equals(new Exponent(new Constant(base), new Constant(power)).evaluate())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check negate with {0}")
    @CsvSource({
        "10.0, 2.0",
        "16.0, -1.0",
        "100.0, 0.5"
    })
    public void checkAddition(double base, double power) {
        assertThat(Double.valueOf(base + power)
            .equals(new Exponent(new Constant(base), new Constant(power)).evaluate())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check negate with {0}")
    @CsvSource({
        "10.0, 2.0",
        "16.0, -1.0",
        "100.0, 0.5",
        "123.123, 0.0"
    })
    public void checkMultiplication(double base, double power) {
        assertThat(Double.valueOf(base * power)
            .equals(new Exponent(new Constant(base), new Constant(power)).evaluate())).isTrue();
    }
}
