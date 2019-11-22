package algoexpert;

public class BSTConstruction {

    public static void main(String[] args) {

    }

}

class BST {
    int value;
    BST left;
    BST right;

    public BST(int v) {
        this.value = v;
    }


    // Average runtime O(log n), avg space complexity O(1)
    public BST insert(int v) {
        BST current = this;
        // iterative method to write insert into BST
        while(true) {
            if(v<current.value) {
                BST left = current.left;
                if(left == null){
                    current.left = new BST(v);
                    break;
                } else {
                    current = current.left;
                }
            } else {
                BST right = current.right;
                if(right == null){
                    current.right = new BST(v);
                    break;
                } else {
                    current = current.right;
                }
            }
        }
        return this;
    }

    // Average runtime : O(log n) | Avg space : O(1)
    // Worst : O(n) | Worst space : O(1)
    public boolean contains(int v) {
        BST current = this;
        while(current!=null) {
            if(current.value == v) return true;
            if(v<current.value) current = current.left;
            else current = current.right;
        }
        return false;
    }

    public BST remove(int v) {
        remove(v, null);
        return this;
    }

    public void remove(int v, BST parent) {
        BST current = this;
        while(current!=null) {
            if(v<current.value) {
                parent = current;
                current = current.left;
            } else if(v>current.value) {
                parent = current;
                current = current.right;
            } else {
                // main algorithm starts here since this will take care of case when value is equal to the current node value
                if(current.left != null && current.right != null) {
                    current.value = current.right.getMinimum();
                    current.right.remove(current.value, current);
                } else if(parent==null) {
                    if(current.left!=null) {
                        current.value = current.left.value;
                        current.right = current.left.right;
                        current.left = current.left.left;
                    } else if(current.right!=null){
                        current.value = current.right.value;
                        current.right = current.right.right;
                        current.left = current.right.left;
                    } else {
                        current = null;
                    }
                } else if(parent.left == current) {
                    parent.left = (current.left!=null) ? current.left : current.right;
                } else if (parent.right == current) {
                    parent.right = (current.left!=null) ? current.left : current.right;
                }
                break;
            }
        }
    }

    private int getMinimum() {
        BST current = this;
        while(current.left!=null) {
            current = current.left;
        }
        return current.value;
    }
}
