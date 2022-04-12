import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root;
	private String code = null;
	private String tempCode = "";
	private String letter = null;
	private int pos = 0;

	public MorseCodeTree() {
		buildTree();
	}
	public MorseCodeTree(String code) {
		this.code = code;
		buildTree();
	}
		
	


	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;		
	}
	
	@Override
	public void buildTree() {
		if (code == null) {
			setRoot(new TreeNode<String>(code));
			addToTestTree(root, "."); //e
			addToTestTree(root, "-"); //t
			
			addToTestTree(root, ".."); //i
			addToTestTree(root, ".-"); //a
			addToTestTree(root, "-."); //n
			addToTestTree(root, "--"); //m
			
			addToTestTree(root, "..."); //s
			addToTestTree(root, "..-"); //u
			addToTestTree(root, ".-."); //r
			addToTestTree(root, ".--"); //w
			addToTestTree(root, "-.."); //d
			addToTestTree(root, "-.-"); //k
			addToTestTree(root, "--."); //g
			addToTestTree(root, "---"); //o

			addToTestTree(root, "...."); //h
			addToTestTree(root, "...-"); //v
			addToTestTree(root, "..-."); //f
			addToTestTree(root, ".---"); //l
			addToTestTree(root, ".--."); //p
			addToTestTree(root, ".---"); //j
			addToTestTree(root, "-..."); //b
			addToTestTree(root, "-..-"); //x
			addToTestTree(root, "-.-."); //c
			addToTestTree(root, "-.--"); //y
			addToTestTree(root, "--.."); //z
			addToTestTree(root, "--.-"); //q
			toArrayList();
		}
		else {
			insert(code,letter);
		}
	}
	
	private void addToTestTree(TreeNode<String> root, String code) {
		if (pos == code.length()) { //If the root has no node, reset and exit
			pos = 0;
			return;
		}
		else {
			String currentCode = Character.toString(code.charAt(pos));
			if (pos == 0 && root.data == null) {
				root.data = "";
				
				
				if (currentCode.equals(".") && root.left == null) {
					root.left = new TreeNode<String>(code);
				}
				else if (currentCode.equals("-") && root.right == null) {
					root.right = new TreeNode<String>(code);
				}
				addToTestTree(root, code);
			}
			else { //Enter the data into the node
				pos++;
				if (currentCode.equals(".")) {
					if (root.left == null) {
						root.left = new TreeNode<String>(code);
					}
					root.left.data = currentCode;
					addToTestTree(root.left, code);
				}
				else if (currentCode.equals("-")) {
					if (root.right == null) {
						root.right = new TreeNode<String>(code);
					}
					root.right.data = currentCode;
					addToTestTree(root.right, code);
				}
			}
		}
		
	}
	@Override
	public void insert(String code, String letter) {
		setRoot(new TreeNode<String>(code));
		
		addNode(root, code, letter);
	}

	public void addNode(TreeNode<String> root, String code, String letter) {
		if (pos == code.length()) { //If the root has no node, reset and exit
			pos = 0;
			return;
		}
		else {
			String currentCode = Character.toString(code.charAt(pos));
				//Decide whether to start on the left or right node.
				//1st Node will be an empty string.
			if (pos == 0 && root.data == null) {
				if (currentCode.equals("/")) {
					root.data = "/";
				}
				else root.data = "";
				
				
				if (currentCode.equals(".")) {
					root.left = new TreeNode<String>(code);
					addNode(root, code, letter);
				}
				else if (currentCode.equals("-")) {
					root.right = new TreeNode<String>(code);
					addNode(root, code, letter);
				}
			}
			else { //Enter the data into the node
				pos++;
				if (currentCode.equals(".")) {
					root.left = new TreeNode<String>(code);
					root.left.data = currentCode;
					addNode(root.left, code, letter);
				}
				else if (currentCode.equals("-")) {
					root.right = new TreeNode<String>(code);
					root.right.data = currentCode;
					addNode(root.right, code, letter);
				}
			}
		}
	}

	@Override
	public String fetch(java.lang.String code) {
		return fetchNode(root, code);
	}

	public String fetchNode(TreeNode<String> root, String code) {
		String currentCode = "";
		if (code.length() > 0) {
			currentCode = Character.toString(code.charAt(pos));
		}
		switch (pos) {
			case 0:{
				if (currentCode == "") {
					letter = "";
				}
				if (root.data.equals("/")) {
					letter = " ";
					break;
				}
				pos++;
				if (currentCode.equals(".")) {
					letter = "e";
					if (pos < code.length()) {
						fetchNode(root.left, code);
					}
				}
				else if (currentCode.equals("-")) {
					letter = "t";
					if (pos < code.length()) {
						fetchNode(root.right, code);
					}
				}
			break;
			}
			
			case 1: {  //Level 1
				pos++;
				if (letter == "e") {
					if (currentCode.equals(".")) {
						letter = "i";
					}
					else if (currentCode.equals("-")) {
						letter = "a";
					}
				}
				else if (letter == "t") {
					if (currentCode.equals(".")) {
						letter = "n";
					}
					else if (currentCode.equals("-")) {
						letter = "m";
					}
				}
				if (pos < code.length()) {
					if (currentCode.equals(".")) {
						fetchNode(root.left, code);
					}
					else if (currentCode.equals("-")) {
						fetchNode(root.right, code);
					}
				}
			break;
			}
		
			case 2: { //Level 2
				pos++;
				if (letter == "i") {
					if (currentCode.equals(".")) {
						letter = "s";
					}
					else if (currentCode.equals("-")) {
						letter = "u";
					}
				}
				else if (letter == "a") {
					if (currentCode.equals(".")) {
						letter = "r";
					}
					else if (currentCode.equals("-")) {
						letter = "w";
					}
				}
				else if (letter == "n") {
					if (currentCode.equals(".")) {
						letter = "d";
					}
					else if (currentCode.equals("-")) {
						letter = "k";
					}
				}
				else if (letter == "m") {
					if (currentCode.equals(".")) {
						letter = "g";
					}
					else if (currentCode.equals("-")) {
						letter = "o";
					}
				}
				
				if (pos < code.length()) {
					if (currentCode.equals(".")) {
						fetchNode(root.left, code);
					}
					else if (currentCode.equals("-")) {
						fetchNode(root.right, code);
					}
				}
			break;
			}
		
			case 3: { //Level 3
				pos++;
				if (letter == "s") {
					if (currentCode.equals(".")) {
						letter = "h";
					}
					else if (currentCode.equals("-")) {
						letter = "v";
					}
				}
				else if (letter == "u") {
					if (currentCode.equals(".")) {
						letter = "f";
					}
				}
				else if (letter == "r") {
					if (currentCode.equals(".")) {
						letter = "l";
					}
				}
				else if (letter == "w") {
					if (currentCode.equals(".")) {
						letter = "p";
					}
					else if (currentCode.equals("-")) {
						letter = "j";
					}
				}
				else if (letter == "d") {
					if (currentCode.equals(".")) {
						letter = "b";
					}
					else if (currentCode.equals("-")) {
						letter = "x";
					}
				}
				else if (letter == "k") {
					if (currentCode.equals(".")) {
						letter = "c";
					}
					else if (currentCode.equals("-")) {
						letter = "y";
					}
				}
				else if (letter == "g") {
					if (currentCode.equals(".")) {
						letter = "z";
					}
					else if (currentCode.equals("-")) {
						letter = "q";
					}
				}
			break;
			}
		}
		pos = 0;
		return letter;
	}

	public String getLetter() {
		return letter;
	}
	
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		
		
		return list;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		tempCode += root.data;
		if (root.left != null) {
			LNRoutputTraversal(root.left, list);
		}
		String current = fetch(tempCode);
		list.add(current);
		if (root.right != null) {
			LNRoutputTraversal(root.right, list);
		}
		if (tempCode.length() > 0) {
			tempCode = tempCode.substring(0,tempCode.length()-1);
		}
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
