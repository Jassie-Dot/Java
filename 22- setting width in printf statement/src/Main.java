public class Main {
    public static void main(String[] args) {
        // Setting width in printf statement.
        /*
        0 = Zero padding.
        number = right justified padding.
        negative number = left justifies padding.
         */

        int id1=1;
        int id2=23;
        int id3=456;
        int id4=7890;

        System.out.printf("%04d\n",id1); // 04 padding.
        System.out.printf("%04d\n",id2); // 04 padding.
        System.out.printf("%04d\n",id3); // 04 padding.
        System.out.printf("%04d\n",id4); // 04 padding.
        System.out.println();
        System.out.printf("%4d\n",id1); // Padding of 4 digits.(right justified)
        System.out.printf("%4d\n",id2); // Padding of 4 digits.(right justified)
        System.out.printf("%4d\n",id3); // Padding of 4 digits.(right justified)
        System.out.printf("%4d\n",id4); // Padding of 4 digits.(right justified)

        
    }
}
