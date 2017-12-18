package cs.kookmin.datastructure;

import java.util.Comparator;

public class Node  {

    private Node leftChild = null;
    private Node rightChild = null;
    private int value;
    private int bit;
    private String letter = null;

    public Node() {

    }


    public Node (int value) {
        this.value = value;
    }

    public Node(String letter, int value) {
        this.leftChild = null;
        this.rightChild = null;
        this.letter = letter;
        this.value = value;
    }
    
    public Node(int value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }




}
