package hr.marko.junitfirst;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class UtilsTest {

    Utils utils;

    @BeforeEach
    void beforeEach() {
        utils = new Utils();
    }

    @AfterEach
    void afterEach() {
    }

    @DisplayName("Multiply")
    @Test
    void testMultiply() {

        assertEquals(12, utils.multiply(4, 3), "4*3 must be 12");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals() {
        assertEquals(6, utils.add(4, 2), "2 + 4 equals 6");
        assertNotEquals(6, utils.add(4, 4), "4 + 4 not equals 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {
        String nullString = null;
        String notNullString = "test";

        assertNull(utils.checkNull(nullString), "Object should be null");
        assertNotNull(utils.checkNull(notNullString), "Object should not be null");
    }

    @Test
    @DisplayName("Same and Not Same")
    void testSameAndNotSame() {
        String test = "test";

        assertSame(utils.getTestString(), utils.getTestStringDuplicate(), "Objects should refer to the same object");
        assertNotSame(test, utils.getTestStringDuplicate(), "Objects should not refer to the same object");
    }

    @Test
    @DisplayName("True and False")
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(utils.isGreater(gradeOne, gradeTwo), "Should return true");
        assertFalse(utils.isGreater(gradeTwo, gradeOne), "Should return false");
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
        String[] array = {"A", "B", "C"};

        assertArrayEquals(array, utils.getFirstThreeLettersOfAlphabet(), "Arrays should be equal");
    }

    @Test
    @DisplayName("Iterable equals")
    void testIterableEquals() {
        List<String> testList = Arrays.asList("test", "demo", "marko");

        assertIterableEquals(testList, utils.getTestStringInList(), "Lists should be equal");
    }

    @Test
    @DisplayName("Lines match")
    void testLinesMatch() {
        List<String> testList = Arrays.asList("test", "demo", "marko");

        assertLinesMatch(testList, utils.getTestStringInList(), "Lines should match");
    }

    @Test
    @DisplayName("Throws and Does Not Throw")
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> {
            utils.throwException(-1);
        }, "Should throw exception");

        assertDoesNotThrow(() -> {
            utils.throwException(9);
        }, "Should not throw exception");
    }

    @Test
    @DisplayName("Timeout")
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> utils.checkTimeout(), "Should execute in 3 seconds");
    }

}
