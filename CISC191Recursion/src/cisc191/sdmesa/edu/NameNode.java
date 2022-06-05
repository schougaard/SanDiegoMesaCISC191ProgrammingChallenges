package cisc191.sdmesa.edu;
/**
 * Lead Author(s):
 * 
 * @author
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 * Version/date:
 * 
 * Responsibilities of class:
 * 
 */
public class NameNode
{
	// TODO: A NameNode has-a left node
	
	// A NameNode has-a name
	private String name;
	
	// TODO: A NameNode has-a right node
	

	/**
	 * 
	 * @param newName the String stored in the node
	 */
	public NameNode(String newName)
	{
		// TODO: store newName in node;
		
	}
	
	/**
	 * 
	 * @return the String stored in the node
	 */
	public String getName()
	{
		// TODO:
		return null;
	}
	
	/**
	 * Set the left node of this node
	 * @param newLeft
	 */
	public void setLeft(NameNode newLeft)
	{
		// TODO:
		
	}
	
	/**
	 * Set the right node of this node
	 * @param newRight
	 */
	public void setRight(NameNode newRight)
	{
		// TODO:
		
	}
	
	/**
	 * 
	 * @return the left node of this node
	 */
	public NameNode getLeft()
	{
		// TODO:
		return null;
	}
	
	/**
	 * 
	 * @return the right node of this node
	 */
	public NameNode getRight()
	{
		// TODO:
		return null;
	}
	
	/**
	 * Find the least name in the tree
	 * @return the node with the least name
	 */
	public String getSmallest()
	{
		// TODO:
		return null;
	}
	
	/**
	 * Find the largest name in the tree
	 * @return the node with the largest name
	 */
	public String getLargest()
	{
		// TODO:
		return null;
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
		// traverse and left subtree, then add this, then traverse and add right subtree

		return returnValue;
	}

}
