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

    @Test
    void testEqualsAndNotEquals() {
        assertEquals(6, utils.add(4, 2), "2 + 4 equals 6");
        assertNotEquals(6, utils.add(4, 4), "4 + 4 not equals 6");
    }

    @Test
    void testNullAndNotNull() {
        String nullString = null;
        String notNullString = "test";

        assertNull(utils.checkNull(nullString), "Object should be null");
        assertNotNull(utils.checkNull(notNullString), "Object should not be null");
    }

    @Test
    void testSameAndNotSame() {
        String test = "test";

        assertSame(utils.getTestString(), utils.getTestStringDuplicate(), "Objects should refer to the same object");
        assertNotSame(test, utils.getTestStringDuplicate(), "Objects should not refer to the same object");
    }

    @Test
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(utils.isGreater(gradeOne, gradeTwo), "Should return true");
        assertFalse(utils.isGreater(gradeTwo, gradeOne), "Should return false");
    }

    @Test
    void testArrayEquals() {
        String[] array = {"A", "B", "C"};

        assertArrayEquals(array, utils.getFirstThreeLettersOfAlphabet(), "Arrays should be equal");
    }

    @Test
    void testIterableEquals() {
        List<String> testList = Arrays.asList("test", "demo", "marko");

        assertIterableEquals(testList, utils.getTestStringInList(), "Lists should be equal");
    }

    @Test
    void testLinesMatch() {
        List<String> testList = Arrays.asList("test", "demo", "marko");

        assertLinesMatch(testList, utils.getTestStringInList(), "Lines should match");
    }

    @Test
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> {
            utils.throwException(-1);
        }, "Should throw exception");

        assertDoesNotThrow(() -> {
            utils.throwException(9);
        }, "Should not throw exception");
    }

    @Test
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> utils.checkTimeout(), "Should execute in 3 seconds");
    }

}
