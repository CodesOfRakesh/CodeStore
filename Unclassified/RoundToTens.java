package codestore.unclassified;

public class RoundToTens {
    public static void main(String[] args) {
        int mNum = 3554;
        int mSml = mNum/10 * 10;
        int mLar = mSml + 10;
        if (mNum - mSml > mLar - mNum)
            System.out.println(mLar);
        else System.out.print(mSml);
    }
}
