package Coursera_Problems;
import java.util.*;
import java.util.function.Predicate;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		int parent[];
		Node[] nodes;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
				nodes[i] = new Node();
			} 
		}

		int computeHeight() {
                        // Replace this code with a faster implementation
		
			
			
			Node root = null;
			
			
			for(int i = 0; i < parent.length; i++) {
				if(parent[i] == -1) {
					root = nodes[i];
				}
				else {
					nodes[parent[i]].addChild(nodes[i]);
				}
			}
			
			int maxHeight = 1;
			
			Queue<Node> bfs = new LinkedList<Node>();
			bfs.add(root);
			
			while(!bfs.isEmpty()) {
				Node target = bfs.remove();
				for(Node child : target.children) {
					child.height = target.height+1;
					bfs.add(child);
					maxHeight = Math.max(maxHeight, child.height);
				}
			}
		
			
			
			
			return maxHeight;
		}
	}
	
	public class Node {
		List<Node> children;
		int height = 1;
		Node() {
			children = new ArrayList<Node>();
		}
		public void addChild(Node n) {
			children.add(n);
		}
	}
	

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
