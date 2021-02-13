/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aysu
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
// I stored the data I read from files on different maps.Then i combine these datas on a different map.
//After printing the loop and conditions needed to find the same elements, I printed the final map which is map 3.

public class WordFre {

    public static void readToMap(String[] words, HashMap<String, Integer> map) {

        for (String word : words) {
            if (map.keySet().contains(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        String[] words;

        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        HashMap<String, Integer> map3 = new HashMap<String, Integer>();
        System.out.println("Please enter the file name :");
        //tomsawyer.txt
        //totc.txt
        //dyssy10.txt
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        Scanner txtFile = new Scanner(new File(text));
        //Read the data from file into a map.
        while (txtFile.hasNextLine()) {
            String line = txtFile.nextLine().toLowerCase();
            words = line.split("[^a-zA-Z']");
            readToMap(words, map1);

        }

        txtFile.close();
        Scanner txtFile1 = new Scanner(new File("C:\\Users\\aysu\\Documents\\NetBeansProjects\\Homework2\\commonwords.txt"));
        while (txtFile1.hasNextLine()) {
            String line = txtFile1.nextLine().toLowerCase();
            words = line.split("[^a-zA-Z']");
            readToMap(words, map2);

        }

        txtFile1.close();
        //combining the data in one map
        map3.putAll(map2);
        map3.putAll(map1);
        //comparing each element in 2 map and remove the same ones.
        for (String a : map1.keySet()) {
            if (map2.containsKey(a) || map2.containsValue(map1.get(a))) {
                map3.remove(a);
            }
        }
        //print the last version of map3.
        /*I found the number of words correct when I called to test the files, but it just printed the letter "t" in the totc.txt file. 
         I had no problems with other files, but I could not find a solution.*/
        for (String b : map3.keySet()) {
            int occurences = map3.get(b);
            if (occurences > 200) {
                System.out.println(b + " " + map3.get(b));
            }

        }
    }
}
