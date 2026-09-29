package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    GradeCalculator calc = new GradeCalculator();

    @ParameterizedTest
    @DisplayName("Хязгаарын оноонууд зөв дүн өгөх ёстой")
    @CsvSource({
        "95, A",
        "90, A",
        "89.99, B",
        "85, B",
        "75, C",
        "60, D",
        "59.99, F",
        "0, F"
    })
    void letterGradeTest(double score, String expected) {
        assertEquals(expected, calc.letterGrade(score));
    }

    @Test
    @DisplayName("101 оноо буруу оролт байх ёстой")
    void invalidHighScore() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calc.letterGrade(101)
        );
    }

    @Test
    @DisplayName("-1 оноо буруу оролт байх ёстой")
    void invalidLowScore() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calc.letterGrade(-1)
        );
    }

    @Test
    @DisplayName("Бүх оноо хамгийн их байвал 100 гарах ёстой")
    void totalScore100() {
        assertEquals(
            100,
            calc.totalScore(10, 40, 10, 10, 30)
        );
    }

    @Test
    @DisplayName("Сөрөг оноо өгвөл exception шидэх ёстой")
    void negativeScoreThrows() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calc.totalScore(-5, 40, 10, 10, 30)
        );
    }

    @Test
    @DisplayName("Лабораторийн оноо 40-өөс их бол exception шидэх ёстой")
    void labOverLimitThrows() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calc.totalScore(10, 41, 10, 10, 30)
        );
    }

    @ParameterizedTest
    @DisplayName("Нийлбэр оноо зөв тооцогдох ёстой")
    @CsvSource({
        "10, 40, 10, 10, 30, 100",
        "10, 30, 10, 10, 30, 90",
        "5, 20, 5, 5, 15, 50"
    })
    void totalScoreTest(
            double att,
            double lab,
            double quiz1,
            double quiz2,
            double exam,
            double expected) {

        assertEquals(
            expected,
            calc.totalScore(att, lab, quiz1, quiz2, exam)
        );
    }
}