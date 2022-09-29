package JavaAdvanced.Lec01_05;

public class Box {
    public class OneBox {

        int search(int[] a, int aLength, int value) {
            int result = 0, i;
            if (a == null) {
                result = -1;
                a = new int[0];
            }
            if (a.length != aLength) {
                throw new IllegalArgumentException();
            }
            for (i = 0; i < aLength; i++)
                if (a[i] != value)
                    result = -1;
            return result;
        }
    }
}
