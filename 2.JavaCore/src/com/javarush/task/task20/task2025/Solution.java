package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    private ArrayList<Long> rr = new ArrayList<>();
    private  int N;
    private  int[] digitsMultiSet;
    private  int[] testMultiSet;

    private  List<Long> results;
    private  long maxPow;
    private  long minPow;

    private  long[][] pows;

    private  void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }
    private  boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }

    private  void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;

        if (digit == -1) {
            if (check(pow)) results.add(pow);
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N]);
        } else {
            // Check if we can generate more than minimum
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][N];
                    // Check maximum and break the loop - doesn't help
                    // if (p >= maxPow) break;
                }
            }
        }
    }

    public  List<Long> generate(int maxN) {
        if (maxN > 20) throw new IllegalArgumentException();

        genPows(maxN);
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];

        for (N = 1; N <= maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);

            search(9, N, 0);
        }

        Collections.sort(results);

        return results;
    }


    public static long[] getNumbers(long N) {
        // предзаполняем возведение в степени
        String str = Long.toString(N);
        int maxN = str.length();
        if (maxN > 20) throw new IllegalArgumentException();

        // спиздим код
        long start = System.currentTimeMillis();
        Solution s = new Solution();
        List<Long> list = s.generate(maxN);
        for (Long lng : list)
            if (lng < N) s.rr.add(lng);
        Collections.sort(s.rr);

        long[] result = new long[s.rr.size()];

        int j = 0;
        for (Long r : s.rr) {
            result[j++] = r;
        }

        return result;
    }



    public static void main(String[] args) {
        Date begin = new Date();
        long[] r = getNumbers(10000000000L);
        Date end = new Date();
        for (int i = 0; i <r.length ; i++) {
            System.out.println(r[i]);
        }
        System.out.println("Размер массива="+r.length);
        System.out.println("Прошло секунд: "+(end.getTime() - begin.getTime())/1000);
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1000000 + " MB");

    }

}

