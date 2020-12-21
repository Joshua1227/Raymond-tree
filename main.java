// --------------------------------------------------------------------------
// $Id: algorithm.tex,v 1.2 1997/11/06 14:37:28 schreine Exp schreine $
// a trivial test application
//
// (c) 1997, Wolfgang Schreiner <Wolfgang.Schreiner@risc.uni-linz.ac.at>
// http://www.risc.uni-linz.ac.at/software/daj
// --------------------------------------------------------------------------
import daj.*;

// ----------------------------------------------------------------------------
//
// the application itself
//
// ----------------------------------------------------------------------------

public class Main extends Application
{
  // --------------------------------------------------------------------------
  // main function of application
  // --------------------------------------------------------------------------
  public static void main(String[] args)
  {
    new Main().run();
  }
  public void resetStatistics()
  {
	  
  }
  // --------------------------------------------------------------------------
  // constructor for application
  // --------------------------------------------------------------------------
  public Main()
  {
    super("An Implementation of Raymond tree Algorithm", 400, 400);
  }

  // --------------------------------------------------------------------------
  // construction of network
  // --------------------------------------------------------------------------
  public void construct()
  {
    Node node0 = node(new Prog(0), "0", 200, 50);
    Node node1 = node(new Prog(1), "1", 150, 200);
    Node node2 = node(new Prog(2), "2", 250, 200);
    Node node3 = node(new Prog(3), "3", 300, 350);
    link(node0, node1);
    link(node1, node0);
    link(node0, node2);
    link(node2, node0);
    link(node2, node3);
    link(node3, node2);

  }

  // --------------------------------------------------------------------------
  // informative message
  // --------------------------------------------------------------------------
  public String getText()
  {
    return "A Trivial Program\n \n" +
      "2 messages circling bidirectionally\n" +
      "through a ring of three nodes";
  }
}

// ----------------------------------------------------------------------------
//
// a program class
//
// ----------------------------------------------------------------------------
class Prog extends Program
{
  private int number;
  public int index;
  public Message msg;
  public boolean sent;

  // --------------------------------------------------------------------------
  // called for	initialization of program
  // --------------------------------------------------------------------------
  public Prog(int i)
  { 
    number = i;	
    msg = null;
    sent = false;
  } 
 
  // --------------------------------------------------------------------------
  // called for	 execution of program
  // --------------------------------------------------------------------------
  public void main()
  { 

  }

  // --------------------------------------------------------------------------
  // called for	display of program state
  // --------------------------------------------------------------------------

}


