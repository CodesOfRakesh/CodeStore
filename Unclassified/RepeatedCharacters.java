package codestore.unclassified;

public class RepeatedCharacters {
    public static void main(String[] args) {
        String mStr = "CODESOFRAKESH/CODESTORE";

        // Array to store number of char repetitions
        int mVal[] = new int[256];
        boolean mRep = false;
        for (int i = 0; i < mStr.length(); i++) {
            mVal[mStr.charAt(i)]++;
            if (mVal[mStr.charAt(i)] > 1 && !mRep) {
                System.out.println(mStr.charAt(i) + " is first repeated character");
                mRep = true;
            }
        }

        // Print the number of repetitions
        for (int i = 0; i < 256; i++)
            if (mVal[i] > 1)
                System.out.println((char) i + " is repeated " + mVal[i] + " times");
    }
}
