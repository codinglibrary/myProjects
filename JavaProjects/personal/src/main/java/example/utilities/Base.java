package example.utilities;

public class Base {
    private static int[] randomArr;

    private static void generateIntArray(int multiple, int add, int length) {
        //Check input.
        int argErrorState = 0;
        if (length < -1 || (length > -1 && length < 0)) {
            System.out.println("The argument 'length' committed is false." +
                    "It must be greater than (or equal) zero.");
            argErrorState = 1;
        }
        if (add <= 0 || add % 1 != 0) {
            System.out.println("The argument 'add' committed is false." +
                    "It must be greater than zero.");
            argErrorState = 1;
        }
        if (multiple <= 0 || multiple % 10 != 0) {
            System.out.println("The argument 'multiple' committed is false." +
                    "It must be greater than zero,and is 10 times.");
            argErrorState = 1;
        }
        if (argErrorState == 1) {
            randomArr = null;
            return;
        }

        //Generate a random number(>0).
        int n;
        if (length == -1) {
            //If length don't be set,it would be limited [5,15].
            n = (int) (Math.random() * 10) + 5;
        } else {
            n = length;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = (int) (Math.random() * multiple) + add;
            arr[i] = temp;
        }
        randomArr = arr;
    }

    private static void generateIntArray(int multiple, int add) {
        generateIntArray(multiple, add, -1);
    }

    private static void generateIntArray(int multiple) {
        //item >= 1
        generateIntArray(multiple, 1, -1);
    }

    private static void generateIntArray() {
        //1 <= item <= 10
        generateIntArray(10, 1, -1);
    }

//=====================================================================

    public static int[] getRandomIntArr() {
        generateIntArray();
        return randomArr;
    }

    public static int[] getRandomIntArr(int multiple) {
        generateIntArray(multiple);
        return randomArr;
    }

    public static int[] getRandomIntArr(int multiple, int add) {
        generateIntArray(multiple, add);
        return randomArr;
    }

    public static int[] getRandomIntArr(int multiple, int add, int length) {
        generateIntArray(multiple, add, length);
        return randomArr;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("arr is equal null , error!");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                i++;
                break;
            }
            System.out.print(arr[i]);
            System.out.print(",");
        }
        System.out.print("]");
        System.out.println();
    }
}
