package ch.fhnw.algd2.a03;

public class BinaryTree {
	private Node root;
	public void show(){
		if(root != null){ root.show(); }
		System.out.println();
	}
	public Node search(int key){
		if(root != null){ return root.search(key); }
		return null;
	}
	public void insert(int key){
		if(root != null){ root.insert(key); }
		else { root = new Node(key); }
	}
	public void remove(int key){
		if(root != null){ root.remove(key); }
	}
}
