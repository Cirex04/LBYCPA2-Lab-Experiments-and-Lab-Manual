import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void not() {
        boolean x = Main.not(true);
        assertFalse(x);
        x = Main.not(false);
        assertTrue(x);
    }

    @Test
    void and() {
        boolean x = Main.and(true, true);
        assertTrue(x);
        x = Main.and(true, false);
        assertFalse(x);
        x = Main.and(false, true);
        assertFalse(x);
        x = Main.and(false, false);
        assertFalse(x);
    }

    @Test
    void or() {
        boolean x = Main.or(true, true);
        assertTrue(x);
        x = Main.or(true, false);
        assertTrue(x);
        x = Main.or(false, true);
        assertTrue(x);
        x = Main.or(false, false);
        assertFalse(x);
    }

    @Test
    void nand() {
        boolean x = Main.nand(true, true);
        assertFalse(x);
        x = Main.nand(false, true);
        assertTrue(x);
        x = Main.nand(true, false);
        assertTrue(x);
        x = Main.nand(false, false);
        assertTrue(x);
    }

    @Test
    void nor() {
        boolean x = Main.nor(true, true);
        assertFalse(x);
        x = Main.nor(false, true);
        assertFalse(x);
        x = Main.nor(true, false);
        assertFalse(x);
        x = Main.nor(false, false);
        assertTrue(x);
    }

    @Test
    void xor() {
        boolean x = Main.xor(true, true);
        assertFalse(x);
        x = Main.xor(true, false);
        assertTrue(x);
        x = Main.xor(false, true);
        assertTrue(x);
        x = Main.xor(false, false);
        assertFalse(x);
    }

    @Test
    void cond() {
        boolean x = Main.cond(true, true);
        assertTrue(x);
        x = Main.cond(false, true);
        assertTrue(x);
        x = Main.cond(true, false);
        assertFalse(x);
        x = Main.cond(false, false);
        assertTrue(x);
    }

    @Test
    void biCond() {
        boolean x = Main.biCond(true, true);
        assertTrue(x);
        x = Main.biCond(false, true);
        assertFalse(x);
        x = Main.biCond(true, false);
        assertFalse(x);
        x = Main.biCond(false, false);
        assertTrue(x);
    }
}