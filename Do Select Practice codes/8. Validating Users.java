import java.util.Scanner;

class TransactionParty {
    String seller;
    String buyer;
    public TransactionParty(String seller, String buyer){
      this.seller = seller;
      this.buyer = buyer;
    }
}
class Receipt{
    TransactionParty transactionParty;
    String productsQR;
    public Receipt(TransactionParty transactionParty, String productsQR){
      this.transactionParty = transactionParty;
      this.productsQR = productsQR;
    }
}
class GenerateReceipt{
    public int verifyParty(Receipt r){
      int count = 0;
      String seller = r.transactionParty.seller;
      String buyer = r.transactionParty.buyer;
      if(validName(seller))
        count++;
      if(validName(buyer))
        count++;
      return count;
    }
    static boolean validName(String name){
      char first_char = name.charAt(0);
      boolean first_char_isAplha = (first_char>='a' && first_char<='z') || (first_char>='A' && first_char<='Z');
      if(!first_char_isAplha)
        return false;
      
      char last_char = name.charAt(0);
      boolean last_char_isAplha = (last_char>='a' && last_char<='z') || (last_char>='A' && last_char<='Z');
      if(!last_char_isAplha)
        return false;
      
      int start_idx_hyphen = name.indexOf("-");
      int last_idx_hyphen = name.lastIndexOf("-");
      if(start_idx_hyphen!=last_idx_hyphen)
        return false;

      int start_idx_quote = name.indexOf("'");
      int last_idx_quote = name.lastIndexOf("'");
      if(start_idx_quote!=last_idx_quote)
        return false;
      return true;
    }
    public String calcGST(Receipt r){
      String productsQR = r.productsQR;
      String[] qrs = productsQR.split("@");
      double cost = 0;
      for(String qr : qrs){
        int idx = qr.indexOf(",");
        if(idx!=-1){
          String quantityString = qr.substring(0, idx);
          String rateString = qr.substring(idx+1);
          int quantity = Integer.valueOf(quantityString);
          double rate = Double.valueOf(rateString);
          cost += quantity * rate;
        }
      }
      int GST = (int) (cost * 0.12);
      return Integer.toString(GST);
    }
}
class Source{
  public static void main(String[] args){
    // Scanner sc = new Scanner(System.in);
    TransactionParty transactionParty = new TransactionParty("Daniel D'Cruz", "Giselle Dawn-Wright");
    Receipt receipt = new Receipt(transactionParty, "250,10@100,3@50,7");
    GenerateReceipt utilObj = new GenerateReceipt();
    System.out.println(utilObj.verifyParty(receipt));
    System.out.println(utilObj.calcGST(receipt));
    // sc.close();
  }
}