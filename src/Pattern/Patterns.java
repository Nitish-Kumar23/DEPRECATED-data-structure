package Pattern;

public class Patterns {
    public static void main(String[] args) {
        pattern(4);
        System.out.println("-------pattern2 --------");
        pattern2(5);
        System.out.println("-------pattern3 --------");
        pattern3(5);
        System.out.println("-------pattern4 --------");
        pattern4(5);
        System.out.println("-------pattern5 --------");
        pattern5(5);
        System.out.println("-------pattern5V2 --------");
        pattern5V2(5);
        System.out.println("-------pattern6 --------");
        pattern6(5);
        System.out.println("-------pattern7 --------");
        pattern7(5);
        System.out.println("-------pattern8 --------");
        pattern8(5);
    }

    private static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            //when one row is printed we need to add a new line
            System.out.println();
        }
    }

    private static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                System.out.print("* ");
            }
            //when one row is printed we need to add a new line
            System.out.println();
        }
    }

    private static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= (n - row + 1); col++) {
                System.out.print("* ");
            }
            //when one row is printed we need to add a new line
            System.out.println();
        }
    }

    private static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            //when one row is printed we need to add a new line
            System.out.println();
        }
    }

    private static void pattern5(int input) {
        int n = 2 * input - 1;
        int mid = n / 2;
        for (int row = 1; row <= mid + 1; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            //when one row is printed we need to add a new line
            System.out.println();
        }

        for (int row = 1; row <= mid; row++) {
            for (int col = 1; col <= mid - row + 1; col++) {
                System.out.print("* ");
            }
            //when one row is printed we need to add a new line
            System.out.println();
        }
    }

    private static void pattern5V2(int n) {
        for (int row = 0; row < 2 * n - 1; row++) {
            int totalCols = row < n ? row : (2 * n - row - 2);
            for (int col = 0; col <= totalCols; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern6(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int totalCols = row <= n ? row : (2 * n - row);
            int totalSpaces = row <= n ? n - row : row - n;
            for (int space = 1; space <= totalSpaces; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= totalCols; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern7(int n) {
        for (int row = 1; row <= n; row++) {
            int totalSpaces = n - row;
            for (int space = 1; space <= totalSpaces; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static void pattern8(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int totalSpaces = row <= n ? n - row : row - n;
            int colStart = row <= n ? row : 2 * n - row;
            for (int space = 1; space <= totalSpaces; space++) {
                System.out.print("  ");
            }
            for (int col = colStart; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= colStart; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
