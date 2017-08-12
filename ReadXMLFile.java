
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

  public static void main() {
    try { 
	File fXmlFile = new File("passcodes.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("Info");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			System.out.println("Name : " + eElement.getElementsByTagName("Name").item(0).getTextContent());
			System.out.println("PassWord : " + eElement.getElementsByTagName("PassWord").item(0).getTextContent());
			System.out.println("Id : " + eElement.getElementsByTagName("ID").item(0).getTextContent());
                        System.out.println("Address : " + eElement.getElementsByTagName("Address").item(0).getTextContent());

                        LogicClass.AddEntry(eElement.getElementsByTagName("Name").item(0).getTextContent(),
                                eElement.getElementsByTagName("PassWord").item(0).getTextContent(),
                                eElement.getElementsByTagName("ID").item(0).getTextContent(),
                                eElement.getElementsByTagName("Address").item(0).getTextContent());
                       
                }
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}