
public class Item {
    Item (String name, String pass, String id, String Addr) 
     {
        Name=name;
        PassCode=pass;
        Id=id;  
        Address=Addr;
     }
        String Name;
        String PassCode;
        String Id;
        String Address;
    
     @Override
     public String toString(){
         return Name;
     }
}
 