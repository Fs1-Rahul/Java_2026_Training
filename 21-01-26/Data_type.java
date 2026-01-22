public class Data_type
{
    public static void main(String[] args){
        // Integer based variables
        byte byte_var=100;          // 1 byte
        short short_var=10000;      // 2 byte
        int int_var=10000000;       // 4 byte
        long long_var=1000000000L;  // 8 byte

        // Decimal Based numbers
        float float_var=10.09f;      // 4 byte
        double double_var=100.0863; // 8 byte

        // Single character (Unicode character)
        char char_var='a';          // 2 byte

        // True or False 
        boolean boolean_var=true;   // 1 bit

        // -------- Non-Primitive Data Types --------
        String string_var = "Hello, Java"; // String (class in Java)
        int[] array_var = {1, 2, 3, 4, 5}; // Array
        Integer wrapperInt = Integer.valueOf(50); // Wrapper class example
        StringBuilder sb = new StringBuilder("Java"); // Class object

        System.out.println("byte: " + byte_var);
        System.out.println("short: " + short_var);
        System.out.println("int: " + int_var);

    }
}