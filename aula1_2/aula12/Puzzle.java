/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author guilherme
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Puzzle{
    
    private char[][] puzzle;
    private List<String> words;

    public Puzzle(char[][] puzzle, List<String> words) {
        
        this.puzzle = puzzle;
        this.words = words;
    }
    
     public char[][] getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(char[][] puzzle) {
        this.puzzle = puzzle;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
    
    
    // Nao percebi esta funcao, perguntar BRUNO PINTO
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int l = 0; l < puzzle.length; l++) {
            s.append(puzzle[l]);
            s.append("\n");
        }

        for (int i = 0; i < words.size(); i++) {
            s.append(words.get(i).toLowerCase());

            if (i != words.size() - 1) {
                s.append(", ");
            }

        }

        return s.toString();
    }
   
    
    //Generate
    private boolean fitWord(int l, int c, String word, Directions direction) {

        boolean wordFitted = false;

        // l = largura - c = comprimento
        
        switch (direction) {
            case RIGHT:
                if (word.length() <= puzzle.length - c) {
                    for (int j = 0; j < word.length(); j++) {
                        if (puzzle[l][c + j] != 0) {
                            return false;
                        }
                    }
                    for (int j = 0; j < word.length(); j++) {
                        puzzle[l][c + j] = word.charAt(j);
                    }
                    wordFitted = true;
                }
                break;

            case LEFT:
                if (word.length() <= c + 1) {
                    for (int j = 0; j < word.length(); j++) {
                        if (puzzle[l][c - j] != 0) {
                            return false;
                        }
                    }
                    for (int j = 0; j < word.length(); j++) {
                        puzzle[l][c - j] = word.charAt(j);
                    }
                    wordFitted = true;
                }
                break;

            case UP:
                if (word.length() <= l + 1) {
                    for (int j = 0; j < word.length(); j++) {
                        if (puzzle[l - j][c] != 0) {
                            return false;
                        }
                    }
                    for (int j = 0; j < word.length(); j++) {
                        puzzle[l - j][c] = word.charAt(j);
                    }
                    wordFitted = true;
                }
                break;

            case DOWN:
                if (word.length() <= puzzle.length - l) {
                    for (int j = 0; j < word.length(); j++) {
                        if (puzzle[l + j][c] != 0) {
                            return false;
                        }
                    }
                    for (int j = 0; j < word.length(); j++) {
                        puzzle[l + j][c] = word.charAt(j);
                    }
                    wordFitted = true;
                }
                break;

            case DOWNRIGHT:
                if (word.length() <= puzzle.length - l && word.length() <= puzzle.length - c) {
                    for (int j = 0; j < word.length(); j++) {
                        if (puzzle[l + j][c + j] != 0) {
                            return false;
                        }
                    }
                    for (int j = 0; j < word.length(); j++) {
                        puzzle[l + j][c + j] = word.charAt(j);
                    }
                    wordFitted = true;
                }
                break;

            case DOWNLEFT:
                if (word.length() <= puzzle.length - l && word.length() <= c + 1) {
                    for (int j = 0; j < word.length(); j++) {
                        if (puzzle[l + j][c - j] != 0) {
                            return false;
                        }
                    }
                    for (int j = 0; j < word.length(); j++) {
                        puzzle[l + j][c - j] = word.charAt(j);
                    }
                    wordFitted = true;
                }
                break;

            case UPRIGHT:
                if (word.length() <= l + 1 && word.length() <= puzzle.length - c) {
                    for (int j = 0; j < word.length(); j++) {
                        if (puzzle[l - j][c + j] != 0) {
                            return false;
                        }
                    }
                    for (int j = 0; j < word.length(); j++) {
                        puzzle[l - j][c + j] = word.charAt(j);
                    }
                    wordFitted = true;
                }
                break;

            case UPLEFT:
                if (word.length() <= l + 1 && word.length() <= c + 1) {
                    for (int j = 0; j < word.length(); j++) {
                        if (puzzle[l - j][c - j] != 0) {
                            return false;
                        }
                    }
                    for (int j = 0; j < word.length(); j++) {
                        puzzle[l - j][c - j] = word.charAt(j);
                    }
                    wordFitted = true;
                }
                break;

            default:
                break;

        }

        return wordFitted;
    }
    
    //Sort words and return the number of all chars
    public static int sortWords(List<String> arr) {

        int sum = 0;

        for (int i = 0; i < arr.size() - 1; i++) {

            int index = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j).length() > arr.get(index).length()) {
                    index = j;
                }
            }
            String aux = arr.get(index);
            arr.set(index, arr.get(i));
            arr.set(i, aux);

            sum += arr.get(i).length();
        }
        return sum;
    }
    
    //Generate
    public Puzzle(List<String> words) {

        this.words = new ArrayList(words);
        int numChars = sortWords(words);
        
        int size = (int) Math.sqrt(numChars) + 3;

        if (size < words.get(0).length() + 3) {
            size = words.get(0).length() + 3;
        }

        if (size < words.size() + 3) {
            size = words.size() + 3;
        }

        this.puzzle = new char[size][size];
        Random random = new Random();
        List<Directions> directions = Arrays.asList(Directions.values());

        for (int i = 0; i < words.size(); i++) {

            boolean fitted = false;
            String word = words.get(i);

            do {
                int l = random.nextInt(size);
                int c = random.nextInt(size);

                if (puzzle[l][c] == 0) {

                    Collections.shuffle(directions);

                    for (Directions direction : directions) {
                        fitted = fitWord(l, c, word, direction);
                        if (fitted) {
                            break;
                        }
                    }
                }

            } while (!fitted);

        }

        for (int l = 0; l < size; l++) {
            for (int c = 0; c < size; c++) {
                if (puzzle[l][c] == 0) {
                    //puzzle[l][c] = '_';
                    puzzle[l][c] = (char) (random.nextInt(26) + 'A');
                }
            }
        }
    }
    
    //Solve
    public Ponto[] solve() {
        List<String> searchList = new ArrayList(words);
        Ponto[] results = new Ponto[words.size()];
        List<Directions> directions = Arrays.asList(Directions.values());

        for (int l = 0; l < puzzle.length; l++) {
            for (int c = 0; c < puzzle.length; c++) {
                for (int i = 0; i < searchList.size(); i++) {
                    if (searchList.get(i).charAt(0) == puzzle[l][c]) {
                        //System.out.println(searchList.get(i) + ": " + l + ", " + c);
                        String word = searchList.get(i);
                        
                        for (int j = 0; j < directions.size(); j++) {
                            Ponto result = searchWord(l, c, word, directions.get(j));
                            if (result != null) {
                                results[words.indexOf(word)] = result;
                                searchList.remove(word);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return results;
    }
    
    //Solve
    private Ponto searchWord(int l, int c, String word, Directions direction) {

        switch (direction) {
            case RIGHT:
                if (word.length() <= puzzle.length - c) {
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != puzzle[l][c + j]) {
                            return null;
                        }
                    }
                    return new Ponto(l, c,word, Directions.RIGHT);
                }
                break;

            case LEFT:
                if (word.length() <= c + 1) {
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != puzzle[l][c - j]) {
                            return null;
                        }
                    }
                    return new Ponto(l, c,word, Directions.LEFT);
                }
                break;

            case UP:
                if (word.length() <= l + 1) {
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != puzzle[l - j][c]) {
                            return null;
                        }
                    }
                    return new Ponto(l, c,word, Directions.UP);
                }
                break;

            case DOWN:
                if (word.length() <= puzzle.length - l) {
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != puzzle[l + j][c]) {
                            return null;
                        }
                    }
                    return new Ponto(l, c,word, Directions.DOWN);
                }
                break;

            case DOWNRIGHT:
                if (word.length() <= puzzle.length - l && word.length() <= puzzle.length - c) {
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != puzzle[l + j][c + j]) {
                            return null;
                        }
                    }
                    return new Ponto(l, c,word, Directions.DOWNRIGHT);
                }
                break;

            case DOWNLEFT:
                if (word.length() <= puzzle.length - l && word.length() <= c + 1) {
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != puzzle[l + j][c - j]) {
                            return null;
                        }
                    }
                    return new Ponto(l, c,word, Directions.DOWNLEFT);
                }
                break;

            case UPRIGHT:
                if (word.length() <= l + 1 && word.length() <= puzzle.length - c) {
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != puzzle[l - j][c + j]) {
                            return null;
                        }
                    }
                    return new Ponto(l, c,word, Directions.UPRIGHT);
                }
                break;

            case UPLEFT:
                if (word.length() <= l + 1 && word.length() <= c + 1) {
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != puzzle[l - j][c - j]) {
                            return null;
                        }
                    }
                    return new Ponto(l, c,word, Directions.UPLEFT);

                }
                break;

            default:
                break;
        }
        return null;
    }
    
}
