public class Lc00393Utf8Validation {
  
    public static void main(String[] args) {
        System.out.println(validUtf8(new int[]{197, 130, 1}));
        System.out.println(validUtf8(new int[]{235, 140, 4}));
    }

    public static boolean validUtf8(int[] data) {
        int i = 0;
        int count = 0;
        while (i < data.length) {
            int value = data[i];
            if (count == 0) {
                if ((value & 0b11110000) == 0b11110000 && (value & 0b11111000) == 0b11110000) {
                    count = 3;
                } else if ((value & 0b11100000) == 0b11100000 && (value & 0b11110000) == 0b11100000) {
                    count = 2;
                } else if ((value & 0b11000000) == 0b11000000 && (value & 0b11100000) == 0b11000000) {
                    count = 1;
                } else if ((value | 0b01111111) == 0b01111111) {
                    count = 0;
                } else {
                    return false;
                }
            } else {
                if ((value & 0b10000000) == 0b10000000 && (value & 0b11000000) == 0b10000000) {
                    count--;
                } else {
                    return false;
                }
            }
            i++;
        }
        return count==0;
    }
}
