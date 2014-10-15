package ch.fhnw.algd2.a03;

public class Node {
	Node left;
	Node right;
	int key;

	public Node(int key){
		this.key = key;
	}

	//internal
	void show(){
		if(left != null){ left.show(); }
		System.out.print(key + ", ");
		if(right != null){ right.show(); }
	}
//	Node search(int key){
//		if(this.key == key){ return this; }
//		Node r = left != null ? left.search(key) : null;
//		return r != null ? r :
//			(right != null ? right.search(key) : null);
//	}
	boolean search(int key){
		if(this.key == key){ return true; }
		else if(key < this.key){
			if(left != null){ left.search(key); }
		} else {
			if(right != null){ right.search(key); }
		}
		return false;
	}
	void insert(int key){
		if(key < this.key){
			if(left != null){ left.insert(key); }
			else { left = new Node(key); }
		} else if(key > this.key) {
			if(right != null){ right.insert(key); }
			else { right = new Node(key); }
		}
		//do nothing if this.key == key -> already inserted
	}
	//boolean return increases performance for average cases:
	//Interrupt and no search of rhs tree if the element was found in the lhs
//	boolean remove(int key){
//		if(this.key == key){
//			if(left != null){
//				this.key = left.key;
//				if(right != null){
//					//simple but degenerative method
//					Node endLeft = left;
//					while(endLeft.right != null){ endLeft = endLeft.right; }
//					endLeft.right = right;
//				}
//				this.left = left.left;
//				this.right = left.right;
//			} else if(right != null){
//				this.key = right.key;
//				this.left = right.left;
//				this.right = right.right;
//			}
//			return true;
//		} else {
//			if(left != null){ if(left.remove(key)){ return true; } }
//			if(right != null){ if(right.remove(key)){ return false; } }
//		}
//		return false;
//	}
	boolean remove(int key, Node parent, boolean isLeft){
		if(this.key == key){
			if(left != null){
				Node l = this;
				while(l.left.left != null){ l = l.left; }
				this.key = l.left.key;
				//l.left.key = key; If it was not deleted
				l.left = null;
			} else if(right != null){
				this.key = right.key;
				this.left = right.left;
				this.right = right.right;
			} else {
				if(isLeft){ parent.left = null; }
				else { parent.right = null; }
			}
			return true;
		} else if(key < this.key){
			if(left != null){ return left.remove(key, this, true); }
		} else {
			if(right != null){ return right.remove(key, this, false); }
		}
		return false;
	}
}
