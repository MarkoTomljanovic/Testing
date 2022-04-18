package hr.marko.junitfirst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void testEqualsAndNotEquals() {
        Utils utils = new Utils();

        assertEquals(6, utils.add(4, 2), "2 + 4 equals 6");
        assertNotEquals(6, utils.add(4, 4), "4 +  not equals 6");
    }

    @Test
    public void testNullAndNotNull() {
        Utils utils = new Utils();

        String nullString = null;
        String notNullString = "test";

        assertNull(utils.checkNull(nullString), "Object should be null");
        assertNotNull(utils.checkNull(notNullString), "Object should not be null");
    }

}
