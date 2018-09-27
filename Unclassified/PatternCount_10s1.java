package codestore.unclassified;

public class PatternCount_10s1 {
    public static void main(String[] args) {
        String mInp = "1100010123011000450011101000";
        int mPatCount = 0;
        char mLast = mInp.charAt(0);
        for (int i = 1; i < mInp.length(); i++) {
            if (mLast == '1' && mInp.charAt(i) == '0') {
                // Start with 1, check all zeroes
                while (mInp.charAt(i) == '0' && i < mInp.length()-1)
                    i++;
                // If we end up with 1, pattern found
                if (mInp.charAt(i) == '1')
                    mPatCount++;
            }
            mLast = mInp.charAt(i);
        }
        System.out.println(mPatCount);
    }
}