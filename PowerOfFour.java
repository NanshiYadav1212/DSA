class PowerOfFour{
    boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();
        System.out.println(powerOfFour.isPowerOfFour(16)); // true
        System.out.println(powerOfFour.isPowerOfFour(5));  // false
        System.out.println(powerOfFour.isPowerOfFour(1));  // true
       // System.out.println(powerOfFour.isPowerOfFour(264));  // false
    }
}
