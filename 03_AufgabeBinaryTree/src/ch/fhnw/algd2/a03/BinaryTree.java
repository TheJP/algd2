package ch.fhnw.algd2.a03;

public class BinaryTree {
	private Node root;
	public void show(){
		if(root != null){ root.show(); }
		System.out.println();
	}
//	public Node search(int key){
//		if(root != null){ return root.search(key); }
//		return null;
//	}
	public boolean search(int key){
		if(root != null){ return root.search(key); }
		return false;
	}
	public void insert(int key){
		if(root != null){ root.insert(key); }
		else { root = new Node(key); }
	}
//	public boolean remove(int key){
//		if(root != null){ return root.remove(key); }
//		return false;
//	}
	public boolean remove(int key){
		Node capsule = new Node(key + 1);
		capsule.left = root;
		boolean result = root.remove(key, capsule, true);
		root = capsule.left;
		return result;
	}
}
