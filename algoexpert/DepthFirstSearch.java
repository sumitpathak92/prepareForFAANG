package algoexpert;

import java.util.ArrayList;


public class DepthFirstSearch {
    public static void main(String[] args) {
        Program.Node node = new Program.Node("A");
        node.addChild("B").addChild("C").addChild("D");
    }
}

class Program {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        ArrayList children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

//        public ArrayList<String> depthFirstSearch(ArrayList<String> array) {
//            // Write your code here.
//            array.add(this.name); // adds root the first time
//            for(int i = 0; i<children.size() ; i++) {
//                children.get(i).depthFirstSearch(array);
//            }
//            return array;
//        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
