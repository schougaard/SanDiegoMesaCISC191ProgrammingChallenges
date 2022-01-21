package edu.sdmesa.cisc191;

public class NameNode
{
	// private ??? left = null;
	private String name;
	// private ??? right = null;

	public NameNode(String newName)
	{
		// TODO: store newName in node;
	}

	/**
	 * Insert a new name into a tree
	 * 
	 * @param newName the name to be inserted
	 */
	public void insert(String newName)
	{
		// See
		// https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#compareTo(java.lang.String)

		if (newName.compareTo(name) < 0)
		{
			// TODO: insert newName on the left or right?
		}
		else if (newName.compareTo(name) > 0)
		{
			// TODO: insert newName on the left or right?
		}
		// else the name is already in the tree.

	}

	/**
	 * @return the names in the tree in lexicographical order
	 */
	public String toString()
	{
		String returnValue = "";

		// TODO: in-order traverse tree recursively:
		// left subtree, then this, then right subtree

		return returnValue;
	}

}
