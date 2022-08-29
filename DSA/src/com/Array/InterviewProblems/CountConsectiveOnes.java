package com.Array.InterviewProblems;

public class CountConsectiveOnes {
    public static int cntLeftOne(int crrIndex, int endIndex, String s) {
        int cnt = 0;
        for (int i=crrIndex; i>=0; i--) {
            if(s.charAt(i) == '0'){
                break;
            }
            cnt++;
        }
        return cnt;
    }
    public static int cntRightOne(int strIndex, int endIndex, String s) {
        int cnt = 0;
        for (int i=strIndex; i<endIndex; i++) {
            if(s.charAt(i) == '0'){
                break;
            }
            cnt++;
        }
        return cnt;
    }
    public static int countConsectiveOnesInStr(String s) {
        int n = s.length();
        int leftOneCnt = 0;
        int rightOnecnt = 0;
        int maxCnt = Integer.MIN_VALUE;
        int totalOnes = 0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '1'){
                totalOnes++;
            }
        }

        if(totalOnes == n) {
            return n;
        }
            for (int i = 0; i<n; i++) {
                char ch = s.charAt(i);
                if(ch == '0') {
                    leftOneCnt = cntLeftOne(i-1, 0, s);
                    rightOnecnt = cntRightOne(i+1, n, s);
                    int tlCnsOne = 0;

                    if(totalOnes > leftOneCnt + rightOnecnt) {
                        tlCnsOne = leftOneCnt + rightOnecnt + 1;
                    } else {
                        tlCnsOne = leftOneCnt + rightOnecnt;
                    }
                    
                    // if(rightOnecnt == 0) {
                    //     tlCnsOne = leftOneCnt + rightOnecnt;
                    // } else if (leftOneCnt == 0){
                    //     tlCnsOne = leftOneCnt + rightOnecnt;
                    // } else {
                    //     tlCnsOne = leftOneCnt + rightOnecnt + 1;
                    // }


                    if(tlCnsOne > maxCnt) {
                        maxCnt = tlCnsOne;
                    }
                }
            }
        return  maxCnt;
        
    }
    public static void main(String[] args) {
        String s = "00000";
        int rest = countConsectiveOnesInStr(s);
        System.out.println(rest);
    }
}
