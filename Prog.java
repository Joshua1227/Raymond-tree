import daj.*;

class Prog extends Program
{
  private int id, holder;
  public boolean sent_req, have_token, completed_crit;		//sent req is to make sure that every node sends a req once. (we assume that every node needs to enter the critical section once)
  private FIFO request_q;
  private InChannelSet msgIn;
  private OutChannelSet msgOut;

  // --------------------------------------------------------------------------
  // called for	initialization of program
  // --------------------------------------------------------------------------
  public Prog(int ID, int Holder)
  { 
    this.id = ID;
    this.holder = Holder;//only for root
    if(id == 0) {
    	sent_req = true;
    	completed_crit = true;
    }
    else {
    	sent_req = false;
    	completed_crit = false;
    }
    request_q = new FIFO();
    msgIn = new InChannelSet();
    msgOut = new OutChannelSet();
    if(this.id == this.holder ) {
    	have_token = false;
    }
    else {
    	have_token = true;
    }
  } 
 
  // --------------------------------------------------------------------------
  // called for	 execution of program
  // --------------------------------------------------------------------------
  public void main()
  { 
	  int fromChannel, outChannels, inChannels, i;
	  Msg msg;
	  
	  inChannels = in().getSize();
	  	for (i=0; i<inChannels; i++) {
	  		msgIn.addChannel(in(i));
	  }
	  outChannels = out().getSize();
	  	for (i=0; i<outChannels; i++) {
	  		msgOut.addChannel(out(i));
	  }
	  while(true) {
		  i = request_q.getNextReceiver();
		  if(have_token && (i == id)) {
			  //Critical section
			  //give token to next id on request_q
			  holder = i;
			  completed_crit = true;
			  have_token = false;
			  request_q.dropNextReciever();
			  msgOut.getChannel(i).send(new Token(id, i));
			  
		  }
		  if(request_q.isempty() && !sent_req) {							// send its own request only when the request_q is empty.
			  msgOut.getChannel(holder).send(new Request(id, holder));
		      sent_req = true;
		      request_q.addToFIFO(id);
		  }
		  fromChannel=msgIn.select();
	      msg = (Msg)msgIn.getChannel(fromChannel).receive();
	      if(msg.getReceiver() == id) {
	    	  if(msg instanceof Request) {
	    		  request_q.addToFIFO(msg.getSender());
	    		  if(holder != id) {	// if node is not holder fwd the req to node's holder
	    			  msgOut.getChannel(holder).send(new Request(id, holder));
	    		  }
	    	  }
	    	  else {//token
	    		  have_token = true;
	    		  if(request_q.getNextReceiver() != id) {
	    			  i = request_q.getNextReceiver();
	    			  request_q.dropNextReciever();
	    			  msgOut.getChannel(i).send(new Token(id, i));	// forward token to requester in request_q.
	    			  have_token = false;
	    			  holder = i;									// reset holder to node where token was sent.
	    		  }
	    	  }
	      }
		  
	  }
  }

  // --------------------------------------------------------------------------
  // called for	display of program state
  // --------------------------------------------------------------------------

}