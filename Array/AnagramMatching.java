package codestore.array;

import java.util.Arrays;

public class AnagramMatching {
    public static void main(String[] args) {
        String mTxt = "CODESSTORESHTHTSHICRUEWLTHSISHIT";
        String mPat = "THIS";
        
        // Calculate the hash of pattern and hash of text upto pattern length
        int mPatHash = 0, mTxtHash = 0;
        int mPatValue[] = new int[256];
        for (int i = 0; i < mPat.length(); i++) {
            mPatHash += (int) mPat.charAt(i);
            mPatValue[(int) mPat.charAt(i)] += 1;
            mTxtHash += (int) mTxt.charAt(i);
        }
        
        // Check if text hash and pattern hash matches, if yes then check for anagram
        if (mTxtHash == mPatHash)
            isAnagram(mTxt, 0, mPat.length(), mPatValue);

        // Slide over text, calculate new hash and check for anagram.
        for (int i = mPat.length(); i < mTxt.length(); i++) {
            mTxtHash = mTxtHash + (int) mTxt.charAt(i) - (int) mTxt.charAt(i - mPat.length());
            if (mTxtHash == mPatHash) {
                isAnagram(mTxt, i - mPat.length() + 1, mPat.length(), mPatValue);
            }
        }
    }

    private static void isAnagram(String mTxt, int mTxtIndex, int mPatLength, int[] mPatValue) {
        int mTxtValue[] = new int[256];
        for (int i = mTxtIndex; i < mTxtIndex + mPatLength; i++)
            mTxtValue[(int) mTxt.charAt(i)] += 1;
        if (Arrays.equals(mTxtValue, mPatValue))
            System.out.println("Anagram at index: " + mTxtIndex);
    }
}