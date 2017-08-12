import java.util.*;

public class LogicClass {
   
    static ArrayList<Item> items = new ArrayList<Item>();
    
    public static void ReadXml()
    {
        ReadXMLFile.main();
    }
    
    public static void WriteXml()
    { 
        WriteXMLFile.main(LogicClass.items);
    }
    
    public static void AddEntry(String name, String pass, String id, String Address)
    {
        items.add(new Item(name, pass, id, Address));
    }
    
    public static void RemoveEntry(int index)
    {
        items.remove(index);
    }
    
    public static boolean ListContains(ArrayList<Item> list, String searchitem){
        for (Item item: list){
            if (item.Name.contains(searchitem)){
                return true;
            }
        }
        return false;
    }
    
    public static void Replace(int index, Item item){
        items.set(index, item);
    }
    
    public static String getPass(int i)
    {        
        return items.get(i).PassCode;
    }
    
    public static String getId(int i)
    {        
        return items.get(i).Id;
    }
}
 