package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumTest {

    @Test
    void testUmnozhenie() {
        int X1 = 5;
        int Y1 = 6;
        Num num = new Num(X1, Y1);
        int value = num.umnozhenie(X1, Y1);
        assertEquals(30, value);
    }
}