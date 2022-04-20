package hr.marko.junitfirst;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class ConditionalTest {

    @Test
    @Disabled("Don't run")
    void basicTest() {
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly() {
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testForMacAndWindowsOnly() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testOnlyForJava17() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testOnlyForJava8() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_18)
    void testOnlyForRange() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11)
    void testOnlyForRangeMin() {
    }
}
