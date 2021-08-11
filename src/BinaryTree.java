public class BinaryTree
{
	private BinaryTree Left;
	private BinaryTree right;
	private int info;
	
	public BinaryTree(BinaryTree left, BinaryTree right, int info)
	{
		this.Left = left;
		this.right = right;
		this.info = info;
	}
	

	public BinaryTree(int info)
	{
		this.Left =null;
		this.right =null;
		this.info = info;
	}


	/**
	 * @return the left
	 */
	public BinaryTree getLeft() {
		return Left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BinaryTree left) {
		Left = left;
	}

	/**
	 * @return the right
	 */
	public BinaryTree getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BinaryTree right) {
		this.right = right;
	}

	/**
	 * @return the info
	 */
	public int getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(int info) {
		this.info = info;
	}
	
	
	

}
