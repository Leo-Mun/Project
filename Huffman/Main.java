package cs.kookmin.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Type the String that you want to encode : ");
        String input = br.readLine();

        Huffman hf = new Huffman(input);
        System.out.println("Encoded : " + hf.encoding());
        System.out.println("Decoded : " + hf.decoding());

    }
}