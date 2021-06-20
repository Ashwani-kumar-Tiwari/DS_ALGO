import java.util.*;

public class btree{

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    
    public static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] data){
        Stack<Pair> st = new Stack<>();

        Node root = new Node(data[0]);
        int indx = 1;
        st.push(new Pair(root, -1));

        while(st.size() > 0){
            Pair p = st.peek();

            if(p.state == -1){
                //left child addition
                if(data[indx] != null){
                    Node nn = new Node(data[indx]);
                    p.node.left = nn;
                    st.push(new Pair(nn, -1));
                }
                p.state++;
                indx++;
            } else if(p.state == 0){
                //right child addition
                if(data[indx] != null){
                    Node nn = new Node(data[indx]);
                    p.node.right = nn;
                    st.push(new Pair(nn, -1));
                }
                p.state++;
                indx++;
            } else {
                //pop out
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node){
        if(node == null) return;
        //self printing
        String str = "";
        str += node.left == null ? ". " : node.left.data;
        str += " <- [" + node.data + "] -> ";
        str += node.right == null ? " ." : node.right.data;
        System.out.println(str);
        // left call
        display(node.left);
        // right call
        display(node.right);
    }

    public static int size(Node node) {
        if(node == null) return 0;

        int lsize = size(node.left);
        int rsize = size(node.right);

        return lsize + rsize + 1;
    }
    
    public static int sum(Node node) {
        if(node == null) return 0;
        
        return sum(node.left) + sum(node.right) + node.data;
    }
    
    public static int max(Node node) {
        if(node == null) return Integer.MIN_VALUE;

        int lmax = max(node.left);
        int rmax = max(node.right);

        return Math.max(node.data, Math.max(lmax, rmax));
    }

    public static int height(Node node) {
        if(node == null) return -1;
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        return Math.max(lh, rh) + 1;
    }
    
    public static int min(Node node) {
    if(node == null) return Integer.MAX_VALUE;

        int lmin = min(node.left);
        int rmin = min(node.right);

        return Math.min(node.data, Math.min(lmin, rmin));
    }
    
    public static void preOrder(Node node){
        if(node == null) return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void levelOrder(Node node) {
        Queue<Node> qu = new LinkedList<>();

        qu.add(node);

        while(qu.size() > 0){
            int sz = qu.size();

            while(sz-- > 0){
                // get + remove
                Node rem = qu.remove();
                //print
                System.out.print(rem.data + " ");
                //add left
                if(rem.left != null) qu.add(rem.left);
                //add right
                if(rem.right != null) qu.add(rem.right);
            }
            System.out.println();
        }
    }

    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 0));
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        while(st.size() > 0){
            Pair p = st.peek();
            if(p.state == 0){
                pre.add(p.node.data);
                if(p.node.left != null){
                    st.push(new Pair(p.node.left, 0));
                }
                p.state++;
            } else if(p.state == 1){
                in.add(p.node.data);
                if(p.node.right != null){
                    st.push(new Pair(p.node.right, 0));
                }
                p.state++;
            } else {
                post.add(p.node.data);
                st.pop();
            }
        }

        for(int val : pre){
            System.out.print(val + " ");
        }
        System.out.println();

        for(int val : in){
            System.out.print(val + " ");
        }
        System.out.println();

        for(int val : post){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static class Spair {
        int indx;
        String ans;
        int state; 

        public Spair(int indx, String ans, int state){
            this.indx = indx;
            this.ans = ans;
            this.state = state;
        }
    }
    
    public static void interativeSubSeq(String str){
        Stack<Spair> st = new Stack<>();

        st.push(new Spair(0, "", 0));

        while(st.size() > 0){
            Spair p = st.peek();
            if(p.indx == str.length()){
                //base case
                System.out.println(p.ans);
                st.pop();
            }else if(p.state == 0){
                //yes call
                st.push(new Spair(p.indx + 1, p.ans + str.charAt(p.indx) + " ", 0));
                p.state++;
            } else if(p.state == 1){
                // no call
                st.push(new Spair(p.indx + 1, p.ans + "- ", 0));
                p.state++;
            } else {
                // wipe out
                st.pop();
            }
        }
    }

    public static boolean find(Node node, int data){
        if(node == null) return false;

        if(node.data == data) return true;

        boolean res = false;
        res = find(node.left, data);
        if(res == true) return true;

        res = find(node.right, data);

        return res;
    }
    
    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node == null) return new ArrayList<>();
        
        if(node.data == data){
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }
        
        ArrayList<Integer> res;
        res = nodeToRootPath(node.left, data);
        if(res.size() > 0){
            res.add(node.data);
            return res;
        }

        res = nodeToRootPath(node.right, data);
        if(res.size() > 0){
            res.add(node.data);
            return res;
        }

        return new ArrayList<>();
    }

    public static void printKLevelsDown(Node node, int k){
        if(node == null) return;

        if(k == 0){
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    public static ArrayList<Node> nodeToRootPath2(Node node, int data){
        if(node == null) return new ArrayList<>();
        
        if(node.data == data){
            ArrayList<Node> bres = new ArrayList<>();
            bres.add(node);
            return bres;
        }
        
        ArrayList<Node> res;
        res = nodeToRootPath2(node.left, data);
        if(res.size() > 0){
            res.add(node);
            return res;
        }

        res = nodeToRootPath2(node.right, data);
        if(res.size() > 0){
            res.add(node);
            return res;
        }

        return new ArrayList<>();
    }

    public static void printKDown(Node node, Node blockage, int k){
        if(node == null || node == blockage) return;

        if(k == 0) {
            System.out.println(node.data);
            return;
        }

        printKDown(node.left, blockage, k - 1);
        printKDown(node.right, blockage, k - 1);
    }

    public static void printKNodesFar(Node node, int data, int k){
        ArrayList<Node> path = nodeToRootPath2(node, data);
        Node blockage = null;
        for(int i = 0; i < path.size() && k - 1 >= 0; i++){
            Node nroot = path.get(i);
            printKDown(nroot, blockage, k - i);
            blockage = nroot;
        }
    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
        if(node == null) return; // specially for root == null
        
        if(node.left != null && node.right != null){
            //left + right
            pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
            pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else if(node.left != null){
            // left
            pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        } else if(node.right != null){
            // right
            pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else {
            // leaf
            sum += node.data;
            path += node.data;

            if(lo <= sum && sum <= hi){
                System.out.println(path);
            }
        }
    }

    public static Node createLeftCloneTree(Node node){
        if(node == null) return null;
        Node lc = createLeftCloneTree(node.left);
        Node rc = createLeftCloneTree(node.right);

        Node nn = new Node(node.data);
        node.left = nn;
        node.right = rc;
        nn.left = lc;
        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node){
        if(node == null) return null;

        Node lc = transBackFromLeftClonedTree(node.left.left);
        Node rc = transBackFromLeftClonedTree(node.right);

        node.left = lc;
        node.right = rc;

        return node;
    }

    public static void printSingleChildNodes1(Node node){
        if(node == null) return; // for root null

        if(node.left != null && node.right != null){
            //left + right
            printSingleChildNodes1(node.left);
            printSingleChildNodes1(node.right);
        } else if(node.left != null){
            // left
            System.out.println(node.left.data);
            printSingleChildNodes1(node.left);
        } else if(node.right != null){
            // right
            System.out.println(node.right.data);
            printSingleChildNodes1(node.right);
        } else {
            // leaf
            return;
        }
    }

    public static void printSingleChildNodes(Node node, Node parent){
        if(node == null) return; // for root null

        if(parent != null && parent.left == node && parent.right == null){
            // node is single left child of parent
            System.out.println(node.data);
        } else if(parent != null && parent.right == node && parent.left == null){
            // node is single right child of parent
            System.out.println(node.data);
        } else {
            printSingleChildNodes(node.left, node);
            printSingleChildNodes(node.right, node);
        }
    }

    public static void fun(){
        Integer[] data = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = construct(data);
        // display(root);
        // System.out.println();

        // System.out.println("Max : " + max(root));
        // System.out.println("Min : " + min(root));
        // System.out.println("Height : " + height(root));
        // System.out.println("Sum : " + sum(root));
        // System.out.println("Size : " + size(root));

        // System.out.print("Pre order : ");
        // preOrder(root);
        // System.out.println();
        // System.out.print("In order : ");
        // inOrder(root);
        // System.out.println();
        // System.out.print("Post order : ");
        // postOrder(root);

        // levelOrder(root);
        
        // iterativePrePostInTraversal(root);

        // interativeSubSeq("abc");

        // System.out.println(find(root, 30));
        // System.out.println(nodeToRootPath(root, 30));

        // printKLevelsDown(root, 3);

        // printKNodesFar(root, 50, 2);

        // pathToLeafFromRoot(root, "", 0, 140, 250);

        // display(createLeftCloneTree(root));
        
        // display(transBackFromLeftClonedTree(root));

        // printSingleChildNodes1(root);
    }
    public static void main(String[] args){
        fun();
    }
}
