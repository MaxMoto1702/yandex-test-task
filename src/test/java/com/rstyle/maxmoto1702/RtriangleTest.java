package com.rstyle.maxmoto1702;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RtriangleTest {

    @Test
    public void testRtriangle() {
        Rtriangle rtriangle = RtriangleProvider().getRtriangle();

        // Is null ??? Yes, it's bug.
        assertThat(rtriangle, notNullValue());

        // Get lengths of the sides of the triangle
        double A = getLength(rtriangle.getApexX1(), rtriangle.getApexY1(),
                rtriangle.getApexX2(), rtriangle.getApexY2());
        double B = getLength(rtriangle.getApexX2(), rtriangle.getApexY2(),
                rtriangle.getApexX3(), rtriangle.getApexY3());
        double C = getLength(rtriangle.getApexX1(), rtriangle.getApexY1(),
                rtriangle.getApexX3(), rtriangle.getApexY3());

        // Sides of triangle is greater than zero.
        assertThat("Triangle hasn't zero length of the side", A > 0);
        assertThat("Triangle hasn't zero length of the side", B > 0);
        assertThat("Triangle hasn't zero length of the side", C > 0);

        // Find max length of the sides of the triangle
        if (A > B) {
            if (A > C) {
                // Is triangle ??? No, it's bug.
                assertThat("This isn't triangle", A > B + C);
                // Is rectangular triangle ??? No, it's bug.
                assertThat("This isn't rectangular triangle", A * A == B * B + C * C);
            } else {
                // Is triangle ??? No, it's bug.
                assertThat("This isn't triangle", C > A + B);
                // Is rectangular triangle ??? No, it's bug.
                assertThat("This isn't rectangular triangle", C * C == A * A + B * B);
            }
        } else {
            if (B > C) {
                // Is triangle ??? No, it's bug.
                assertThat("This isn't triangle", B > A + C);
                // Is rectangular triangle ??? No, it's bug.
                assertThat("This isn't rectangular triangle", B * B == A * A + C * C);
            } else {
                // Is triangle ??? No, it's bug.
                assertThat("This isn't triangle", C > A + B);
                // Is rectangular triangle ??? No, it's bug.
                assertThat("This isn't rectangular triangle", C * C == A * A + B * B);
            }
        }
    }

    private double getLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}