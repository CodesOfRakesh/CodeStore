package codestore.unclassified;

public class AverageASCII {
    public static void main(String[] args) {
        String mString = "CodesOfRakesh";
        int mAsciiSum = 0;
        for (int i = 0; i < mString.length(); i++)
            // Typecast char to int, this gives us the ascii value of char
            mAsciiSum += (int) mString.charAt(i);
        System.out.println("Average ASCII: " + mAsciiSum / mString.length());
    }
}
