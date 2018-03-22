package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list =detectAllWords(crossword, "home", "same");

        for (Word word : list) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (int k = 0; k <words.length ; k++) {
            byte[] chrWord= words[k].getBytes();
            for (int i = 0; i <crossword.length ; i++) {
                for (int j = 0; j <crossword[i].length ; j++) {
                  if(crossword[i][j]==(int)chrWord[0]){
                    /*
                    1 | 2 | 3
                    ----------
                    4 | ! | 6
                    ----------
                    7 | 8 | 9
                    */
                      //Блок № 1
                      try {
                          list.add(checkWord(crossword, words[k],i,j,-1,-1));
                      }catch (Exception e){}
                      //Блок № 2
                      try {
                          list.add(checkWord(crossword, words[k],i,j,-1,0));
                      }catch (Exception e){}
                      //Блок № 3
                      try {
                          list.add(checkWord(crossword, words[k],i,j,-1,+1));
                      }catch (Exception e){}
                      //Блок № 4
                      try {
                          list.add(checkWord(crossword, words[k],i,j,0,-1));
                      }catch (Exception e){}
                      //Блок № 6
                      try {
                          list.add(checkWord(crossword, words[k],i,j,0,+1));
                      }catch (Exception e){}
                      //Блок № 7
                      try {
                          list.add(checkWord(crossword, words[k],i,j,+1,-1));
                      }catch (Exception e){}
                      //Блок № 8
                      try {
                          list.add(checkWord(crossword, words[k],i,j,+1,0));
                      }catch (Exception e){}
                      //Блок № 9
                      try {
                          list.add(checkWord(crossword, words[k],i,j,+1,+1));
                      }catch (Exception e){}
                    }
                }
            }        }
        return list;
    }
//входные данные: кроссворд, Слово которое ищем, коорд X первой буквы найденной в п1.,
// координата У первой буквы найденной в п1, направление по Х, направление по У)
//                        try{
    public static Word checkWord(int[][] crossword, String word,int i, int j,int incI, int incJ) throws Exception{
        Word resultWord = new Word(word);
        resultWord.setStartPoint(j,i);
        byte[] chrWord = word.getBytes();
        for (int k = 1; k < chrWord.length ; k++) {
            i +=incI;
            j +=incJ;
            if(chrWord[k]!=crossword[i][j])throw new Exception();
        }
        resultWord.setEndPoint(j,i);
        return resultWord;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
