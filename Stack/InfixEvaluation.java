package codestore.stack;

import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String mExp = "2 + ( 3 * 4 ) + 5";
        char[] mTokens = mExp.toCharArray();
        Stack<Integer> mValStk = new Stack<>();
        Stack<Character> mChrStk = new Stack<>();

        for (int i = 0; i < mTokens.length; i++) {
            if (mTokens[i] == ' ') continue;
            if (mTokens[i] >= '0' && mTokens[i] <= '9') {
                // Numbers could be multiple digit
                StringBuffer mBuf = new StringBuffer();
                while (i < mTokens.length && mTokens[i] >= '0' && mTokens[i] <= '9') {
                    mBuf.append(mTokens[i]);
                    i++;
                }
                mValStk.push(Integer.parseInt(mBuf.toString()));
            }

            else if (mTokens[i] == '(')
                mChrStk.push(mTokens[i]);

            else if (mTokens[i] == ')') {
                while (mChrStk.peek() != '(')
                    mValStk.push(applyOperation(mChrStk.pop(), mValStk.pop(), mValStk.pop()));
                mChrStk.pop();
            }

            else if (mTokens[i] == '+' || mTokens[i] == '-' || mTokens[i] == '*' || mTokens[i] == '/'){
                while (!mChrStk.isEmpty() && hasPrecedence(mTokens[i], mChrStk.peek())){
                    mValStk.push(applyOperation(mChrStk.pop(), mValStk.pop(), mValStk.pop()));
                }
                mChrStk.push(mTokens[i]);
            }
        }

        while (!mChrStk.isEmpty()){
            mValStk.push(applyOperation(mChrStk.pop(), mValStk.pop(), mValStk.pop()));
        }

        System.out.println(mValStk.pop());
    }

    private static int applyOperation(char mOpr, int mFir, int mSec) {
        switch (mOpr) {
            case '+':
                return mFir + mSec;
            case '-':
                return mFir - mSec;
            case '*':
                return mFir * mSec;
            case '/':
                if (mSec == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return mFir / mSec;
            default:
                return 0;
        }
    }

    private static boolean hasPrecedence(char mOp1, char mOp2)
    {
        if (mOp2 == '(' || mOp2 == ')')
            return false;
        if ((mOp1 == '*' || mOp1 == '/') && (mOp2 == '+' || mOp2 == '-'))
            return false;
        else
            return true;
    }
}
