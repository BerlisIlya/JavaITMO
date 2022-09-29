package JavaAdvanced.Lec01_05;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class BoxTest {

    @Before
    public void setUp() throws Exception {
        wb = new Box();
        array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    private Box wb;
    private int[] array;

    @Test
    public void numberLocatedInMiddlePositionOfArray() {
        assertEquals("Number which will be return is not equals to expected number (middle position)", 1, wb.search(array, 10, 5));
    }

    @Test
    public void numberLocatedInFirstPositionOfArray() {
        assertEquals("Number which will be return is not equals to expected number (first position)", 1, wb.search(array, 10, 0));
    }

    @Test
    public void numberLocatedInLastPositionOfArray() {
        assertEquals("Number which will be return is not equals to expected number (last position)", 1, wb.search(array, 10, 9));
    }

    @Test
    public void numberIsNotInArray() {
        assertEquals("The number isn't in the array, but it does not return -1", -1, wb.search(array, 10, 15));
    }

    @Test
    public void arrayIsNull() {
        assertEquals("The array is null, but it does not return -1", -1, wb.search(null, 10, 15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void lengthParameterMoreThanArrayLength() {
        wb.search(array, 5, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lengthParameterLessThanArrayLength() {
        wb.search(array, 15, 5);
    }

}