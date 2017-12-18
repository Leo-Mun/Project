package cs.kookmin.datastructure;

import java.util.*;

public class Huffman {
    private String input;

    // 인코딩된 input
    private String encodedString;

    // Node를 담을 list
    private List<Node> huffman;

    // 알파벳 빈도수를 계산한 것을 저장
    private Map<String, Integer> letterFrequency;

    // 인코딩된 알파벳을 저장
    private Map<String, String> encodedLetter;

    public Huffman(String input) {
        this.input = input;
        huffman = new ArrayList<>();
        letterFrequency = new HashMap<>();
        encodedLetter = new HashMap<>();
    }

    /**
     * encoding input
     *
     * @return
     */
    public String encoding() {

        countLetterFrequency();
        concatNode();
        setBit(huffman.get(0));
        findEncodedLetter(huffman.get(0));

        // StringBuilder : String을 추가해 줄 수 있는 클래스
        StringBuilder tmp = new StringBuilder("");
        for (int i = 0; i < input.length(); i++) {
            // charAt(i) : String의 i번 째 char을 반환
            // String.valueOf(args) : args를 String으로 변환
            String letter = String.valueOf(input.charAt(i));

            // get(args) : args에 접근
            tmp.append(encodedLetter.get(String.valueOf(letter)));
        }

        // tmp.toString : StringBuilder 을 String으로 변환
        setEncodedString(tmp.toString());
        return getEncodedString();

    }

    /**
     * decoding encoded input
     * 
     * @return
     */
    public String decoding() {
        StringBuilder sb = new StringBuilder("");
        
        Node start = huffman.get(0);
        Node nodePointer = start;
        for (int i = 0; i < getEncodedString().length(); i++) {
            String letter = String.valueOf(getEncodedString().charAt(i));
            // .equals(args) : args와 같은 지 true false 반환
            if (letter.equals("0")) {
                nodePointer = nodePointer.getLeftChild();

                if (isTerminal(nodePointer)) {
                    sb.append(nodePointer.getLetter());
                    nodePointer = start;
                }

            }
            else if (letter.equals("1")) {
                nodePointer = nodePointer.getRightChild();

                if (isTerminal(nodePointer)) {
                    sb.append(nodePointer.getLetter());
                    nodePointer = start;
                }
            }
        }

        String decodedString = sb.toString();
        return decodedString;
    }


    /**
     * 인코딩된 알파벳을 map에 추가
     * goLeft(), goRight()
     * 
     * @param node
     */
    private void findEncodedLetter(Node node) {

        if (node.getLeftChild() != null) {
            StringBuilder sb1 = new StringBuilder("");
            goLeft(node.getLeftChild(), sb1);
        }
        if (node.getRightChild() != null) {
            StringBuilder sb2 = new StringBuilder("");
            goRight(node.getRightChild(), sb2);
        }

    }


    private void goLeft(Node node, StringBuilder sb) {
        sb.append(node.getBit());
        if (isTerminal(node)) {
            encodedLetter.put(node.getLetter(), sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        if (node.getLeftChild() != null) {
            goLeft(node.getLeftChild(), sb);
        }
        if (node.getRightChild() != null) {
            goLeft(node.getRightChild(), sb);
        }
    }

    private void goRight(Node node, StringBuilder sb) {
        sb.append(node.getBit());
        if (isTerminal(node)) {
            encodedLetter.put(node.getLetter(), sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        if (node.getLeftChild() != null) {
            goLeft(node.getLeftChild(), sb);
        }
        if (node.getRightChild() != null) {
            goLeft(node.getRightChild(), sb);
        }
    }

    /**
     *  Input String의 알파벳의 빈도를 계산하여 map 에 저장
     *
     *  그 후 알파벳과 알파벳 빈도의 정보를 가진 노드를 생성 후 List에 저장한 다음 내림차순 정렬
     */
    private void countLetterFrequency() {
        for (int i = 0; i < getInput().length(); i++) {
            // .containsKey(args) : args 라는 key가 map에 있는지 확인
            if (!letterFrequency.containsKey(String.valueOf(getInput().charAt(i)))) {
                letterFrequency.put(String.valueOf(getInput().charAt(i)), 1);
            } else {
                letterFrequency.put(String.valueOf(getInput().charAt(i)), letterFrequency.get(String.valueOf(getInput().charAt(i))) + 1);
            }
        }
        // keySet() : map의 key들을 set에 담음
        for (String s : letterFrequency.keySet()) {
            huffman.add(new Node(s, letterFrequency.get(s)));
        }

        // 내림차순 정렬
        NodeComparator nc = new NodeComparator();
        Collections.sort(huffman, nc);
    }

    /**
     * terminal Node 인지 확인
     * @param node
     * @return
     */
    private boolean isTerminal(Node node) {
        return node.getLeftChild() == null && node.getRightChild() == null;
    }

    /**
     * 리스트에 모아둔 Node들을 트리로 만드는 메소드
     */
    private void concatNode() {
        while (huffman.size() != 1) {
            Node tmp1 = huffman.remove(huffman.size() - 2);
            Node tmp2 = huffman.remove(huffman.size() - 1);

            Node concat = new Node(tmp1.getValue() + tmp2.getValue(), tmp1, tmp2);

            huffman.add(concat);

        }
    }

    /**
     * LeftNode = 0, RightNode = 1
     *
     * @param node
     */
    private void setBit(Node node) {
        if (node.getLeftChild() != null) {
            node.getLeftChild().setBit(0);
            setBit(node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            node.getRightChild().setBit(1);
            setBit(node.getRightChild());
        }
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getEncodedString() {
        return encodedString;
    }

    public void setEncodedString(String encodedString) {
        this.encodedString = encodedString;
    }
}
