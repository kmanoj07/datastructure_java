package com.String;

public class AmazingSubStrings {
    public static boolean isStartsWithVowel(String str) {
        if(str.charAt(0) == 'a'||
             str.charAt(0) == 'e' ||
             str.charAt(0) == 'i' ||
             str.charAt(0) == 'o'||
             str.charAt(0) == 'u'||
             str.charAt(0) == 'A'||
             str.charAt(0) == 'E'||
             str.charAt(0) == 'I'||
             str.charAt(0) == 'O'||
             str.charAt(0) == 'U') {
                 return true;
             }
             return false;
    }
    public static int solve(String A) {
        int n = A.length();
        long cnt = 0;
        for (int i=0;i<n;i++) {
            for (int j=i;j<n;j++) {
                StringBuilder sb = new StringBuilder();
                for (int k=i;k<=j;k++) {
                    sb.append(A.charAt(k));
                }
                if(isStartsWithVowel(sb.toString())) {
                    cnt = (cnt + 1 ) % 10003;
                }
            }
        }
        return (int)cnt;
    }

    public static boolean isStartsWithVowel(char str) {
        if(str == 'a'||
             str == 'e' ||
             str == 'i' ||
             str == 'o'||
             str == 'u'||
             str == 'A'||
             str == 'E'||
             str == 'I'||
             str == 'O'||
             str == 'U') {
                 return true;
             }
             return false;
    }

    public static int solveOpt(String str) {
        int n = str.length();
        int cnt=0;
        if(n == 1){
            if(isStartsWithVowel(str.charAt(0))){
                return 1;
            }
        }

        for (int i =0;i<n; i++) {
            char ch = str.charAt(i);
            if(isStartsWithVowel(ch)){
                
                cnt = (cnt + ((n- 1 - i) + 1)) % 10003;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String str = "xIOPYCHpQNLyIdeFIYVojbccFLnWrJcwougkVYUTXvSWLXPEMjoIXWDLJnslpMVEyrLWFvNvteWgfTvTUboqaPEUCuldrbHAPpyvEMjUKslmCmZHDEsnhhcwgzvBNtabMWHykYsOAUHAaDMcuXMyqtXHpVVRydXcmJVCjrSITpFydNDGOVrJDWYcJcVaWdoshbaPXAFOtgtCvtqeGlaYoycQQJrcGseoYEPBqrCrKdRMelddPFguYcVIPdzKEBtycORccDtxUhgeffNJjCINqJGqbxvFmJUxNzhyZdHKwshMqVjUxKEEtvfaxDfwpfyUqHmVIDabhcnCSqDnegyKMlBCvVMRhSwDlZCaSRyjnJKKCEEJQlIcFucFGoKvNPAnruCSkCFAFLGvQfHyxkRjGzBcznEUBmfypnBqEqvBDrBlDMxCXSjnhxsYLcVxEPgetYVHFRsGmblhecIADMLtZodelDyFoplSbgRCwZgUvrSKMartSZlhzaywoIgKALNyLdIZlmgTqTRQAcbUTsbXddQYToZPFMrATjfWJrlNtSngZqEBIAprYlOoarTvJShGtxFKOIeowFlJetauEREhKGzeuXKmlvXRonMuMSowznjKWcelUuLcEAwLsIHZQmEozdVQGRrUQtUpzYembyhopxNMjpHSPEXOwHfNhRnveBZEtwfnpCZrdFafrzWFfKKofcLueRRFtZSuadasEfyGQnzMYxbhUrIycauVINDOeXMGQgWIhXdSIpuNFHAvIBmUjOUmdBZPlCWDOqBakqQeNWHCNEJgynYfJdMYlsjhbNSUaPExSIQefRYeLOXfWtprBBqbBlHIcfspzmqcpGwrXQbqJvtOJUdbIKBxVuZFKKSzjZBuEFakcWuAodBegkyCEahrWWeGACCmjkzryEIAnSOZPYmAMuDkNSuSmDTZPrzFnypKjwmIknMHvPsnkDnXXDVtqycaTClMFxLnZRnuEjotvjKQMzXwdMqugMLQ";
        int res = solve(str);
        System.out.println(res);

        //optimized 
        res = solveOpt(str);
        System.out.println(res);

    }
}
