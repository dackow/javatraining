/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class WordCounter {

    private static final String _pattern = "[^a-zA-Z0-9* ]";

    public static Map<String, Integer> countWordsInFile(File inputFile) throws IOException {
        Map<String, Integer> _map = new TreeMap<>();

        try (BufferedReader reader = openFileForRead(inputFile)) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(_pattern, "").toLowerCase();
                for (String word : line.split("\\s+")) {
                    addWord(word, _map);
                }
            }
        }
        return _map;
    }

    private static void addWord(String word, Map<String, Integer> _map) {
        if (!word.isEmpty()) {
            Integer count = _map.get(word);
            if (count == null) {
                count = 0;
            }
            _map.put(word, ++count);
        }
    }

    private static BufferedReader openFileForRead(File inputFile) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Not able to open the stream", ex);
        }
        return reader;
    }

    public static void main(String[] args) {
        Map<String, Integer> res = null;
        try {
            File file = new File("file.txt");
            res = WordCounter.countWordsInFile(file);
        } catch (IOException ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (res != null) {
            for (Map.Entry<String, Integer> entrySet : res.entrySet()) {
                String key = entrySet.getKey();
                Integer value = entrySet.getValue();

                System.out.println(String.format("%s - %d", key, value));
            }
        }
    }
}
