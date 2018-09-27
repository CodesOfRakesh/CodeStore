package codestore.unclassified;

public class NextPalindrome {
    public static void main(String[] args) {
        int mNum[] = new int[]{2,1,9,9,1,8};

        // Case 1 - All 9's, if yes print 1 + n-1(9) + 1
        if (isAllNine(mNum)) {
            System.out.print("1");
            for (int k = 0; k < mNum.length - 1; k++)
                System.out.print("0");
            System.out.print("1");
        }

        // Case 2 - Not palindrome
        int mMid = mNum.length / 2;
        int mLef = mMid - 1;
        int mRig = (mNum.length % 2 == 0) ? mMid : mMid + 1;
        boolean mLefSml = false;
        while (mLef >= 0 && mNum[mLef] == mNum[mRig]) {
            mLef--;
            mRig++;
        }

        if (mLef < 0 || mNum[mLef] < mNum[mRig]) mLefSml = true;

        while (mLef >= 0) {
            mNum[mRig] = mNum[mLef];
            mLef--;
            mRig++;
        }

        if (mLefSml) {
            int mCarry = 1;
            if (mNum.length % 2 == 1) {
                mNum[mMid] += 1;
                mCarry = mNum[mMid] / 10;
                mNum[mMid] %= 10;
            }
            mLef = mMid - 1;
            mRig = (mNum.length % 2 == 0) ? mMid : mMid + 1;

            while(mLef>=0){
                mNum[mLef] = mNum[mLef] + mCarry;
                mCarry = mNum[mLef]/10;
                mNum[mLef] %= 10;
                mNum[mRig] = mNum[mLef];
                mLef--;
                mRig++;
            }
        }

        System.out.println("\n");
        for (int k = 0; k < mNum.length; k++)
        System.out.print(mNum[k]);

    }

    static boolean isAllNine(int[] mNum) {
        for (int i = 0; i < mNum.length; i++)
            if (mNum[i] != 9) return false;
        return true;
    }
}