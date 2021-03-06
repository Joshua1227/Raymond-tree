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
	int arr1[] = {1,2};
    Node node0 = node(new Prog(0,0,arr1), "0", 200, 50);
    int arr2[] = {0};
    Node node1 = node(new Prog(1,0,arr2), "1", 150, 200);
    int arr3[] = {0,3};
    Node node2 = node(new Prog(2,0,arr3), "2", 250, 200);
    int arr4[] = {2};
    Node node3 = node(new Prog(3,2,arr4), "3", 300, 350);
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







