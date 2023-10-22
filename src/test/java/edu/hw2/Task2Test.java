package edu.hw2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static edu.hw2.Task2.*;

public class Task2Test {
    @ParameterizedTest(name = "{index} - check default constructor of rectangle with h: {0} w: {1}")
    @CsvSource({
        "100, 100",
        "10, 20",
        "20, 10"
    })
    public void checkRectangleConstructor(int height, int width) {
        assertThat(Integer.valueOf(height * width).equals(new Task2.Rectangle(height, width).area())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check heightSetter with height = {0} and newHeight = {2}")
    @CsvSource({
        "100, 100, 20",
        "10, 20, 100",
        "20, 10, 1",
        "0, 1, 2"
    })
    public void checkRectangleHeightSetter(int height, int width, int newHeight) {
        assertThat(Integer.valueOf(newHeight * width)
            .equals(new Rectangle(height, width).setHeight(newHeight).area())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check widthSetter with height = {0} and newHeight = {2}")
    @CsvSource({
        "100, 100, 20",
        "10, 20, 100",
        "20, 10, 1",
        "0, 1, 2"
    })
    public void checkRectangleWidthSetter(int height, int width, int newWidth) {
        assertThat(Integer.valueOf(height * newWidth)
            .equals(new Rectangle(height, width).setWidth(newWidth).area())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check square constructor with {0}")
    @ValueSource(ints = {0, 1, 2, 10})
    public void checkSquareConstructor(int side) {
        assertThat(Integer.valueOf(side * side).equals(new Square(side).area())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check widthSetter with height = {0} and newHeight = {2}")
    @CsvSource({
        "100, 100",
        "10, 20",
        "20, 10",
        "0, 1"
    })
    public void checkSquareWidthSetter(int oldSide, int newSide) {
        assertThat(Integer.valueOf(newSide * newSide).equals(new Square(oldSide).setWidth(newSide).area())).isTrue();
    }

    @ParameterizedTest(name = "{index} - check heightSetter with height = {0} and newHeight = {2}")
    @CsvSource({
        "100, 100",
        "10, 20",
        "20, 10",
        "0, 1"
    })
    public void checkSquareHeightSetter(int oldSide, int newSide) {
        assertThat(Integer.valueOf(newSide * newSide).equals(new Square(oldSide).setHeight(newSide).area())).isTrue();
    }
}
