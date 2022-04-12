
public class TreeNode<T> {
	
	TreeNode<T> left;
	TreeNode<T> right;
	T data;
	
	
	public TreeNode(T dataNode) {
		left = null;
		right = null;
	}
	
	public TreeNode(TreeNode<T> node) {
		TreeNode<T> copy = new TreeNode<T>(data);
		copy.left = left;
		copy.right = right;
		
	}
	
	
	public T getData() {
		return data;
	}
}
