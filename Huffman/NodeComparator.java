package cs.kookmin.datastructure;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.getValue() > o2.getValue() ? -1 : o1.getValue() == o2.getValue() ? 0 : 1;
    }
}