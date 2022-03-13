package edu.sdmesa.cisc191;
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
	// A NameNode has-a left node
	// private ??? left = null;
	// A NameNode has-a name
	private String name;
	// A NameNode has-a right node
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
