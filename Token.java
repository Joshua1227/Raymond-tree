public class Token extends Msg {
  

  public Token (int sender, int receiver) {
    super(sender, receiver);
  }


  public String getText () {
    return "Token from : " + sender + "  to : " + receiver;
  }

}