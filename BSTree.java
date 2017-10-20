

public class BSTree {
	public BSTNode root;
	
	public void insert(String s) {
		root = insert(root, s);
	}

	public BSTNode insert(BSTNode node, String s) {
		if (node == null) {
			node = new BSTNode(s);
			return node;
		}
		
		if (s.compareTo(node.getData()) < 0) {
			node.setLeft(insert(node.getLeft(), s));
		}
		else {
			node.setRight(insert(node.getRight(), s));
		}
		return node;
	}
	
	public boolean find(String s) {
		return find(root, s);
	}
	
	public boolean find(BSTNode node, String s) {
		if (node == null) {
			return false;
		}
		else if (s.compareTo(node.getData()) < 0) {
			return find(node.getLeft(), s);
		}
		else if (s.compareTo(node.getData()) > 0) {
			return find(node.getRight(), s);
		}
		else {
			return true;
		}
	}
	
	public void delete(String s) {
		root = delete(root, s);
	}
	public BSTNode delete(BSTNode node, String s) {
		if (node == null) {
			return null;
		}
		if (s.compareTo(node.getData()) == 0) {
			if (node.getLeft() == null && node.getRight() == null) {
				node = null;
			}
			else if (node.getLeft() == null) {
				node = node.getRight();
			}
			else if (node.getRight() == null) {
				node = node.getLeft();
			}
			else if (node.getRight().getLeft() == null) {
				node.setData(node.getRight().getData());
				node.setRight(node.getRight().getRight());
			}
			else {
				node.setData(deleteSmallest(node.getRight()));
			}
		}
		else if (s.compareTo(node.getData()) < 0) {
			node.setLeft(delete(node.getLeft(), s));
		}
		else {
			node.setRight(delete(node.getRight(), s));
		}
		return node;
	}
	
	public String deleteSmallest(BSTNode node) {
		if (node.getLeft().getLeft() == null) {
			String smallest = node.getLeft().getData();
			node.setLeft(node.getLeft().getRight());
			return smallest;
		}
		else {
			return deleteSmallest(node.getLeft());
		}
	}
	
	public String toStringInOrder() {
		String s1 = "";
		return toStringInOrder(root, s1).trim();
	}
	
	public String toStringInOrder(BSTNode node, String s1) {
		String ss = "";
		if (node != null) {
			ss += toStringInOrder(node.getLeft(), s1);
			ss += s1 + node.getData() + " ";
			ss += toStringInOrder(node.getRight(), s1);
		}
		return ss;
	}
	
	public void toStringInOrder1() {
		toStringInOrder1(root);
	}
	
	public void toStringInOrder1(BSTNode node) {
		if (node != null) {
			toStringInOrder1(node.getLeft());
			System.out.println(node.getData() + " ");
			toStringInOrder1(node.getRight());
		}
	}
	
	public String toStringPreOrder() {
		String s2 = "";
		return toStringPreOrder(root, s2).trim();
	}
	
	public String toStringPreOrder(BSTNode node,String s2) {
		String ss = "";
		if (node != null) {
			ss += s2 + node.getData() + " ";
			ss += toStringPreOrder(node.getLeft(), s2);
			ss += toStringPreOrder(node.getRight(), s2);
		}
		return ss;
	}
}
