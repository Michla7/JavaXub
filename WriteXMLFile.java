import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {

	public static void main(ArrayList<Item> items) {

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("LogInInfo");
		doc.appendChild(rootElement);


		for (int i =0; i<items.size();i++)
		{
			// staff elements
			Element Info = doc.createElement("Info");
			rootElement.appendChild(Info);
	
			Element Name = doc.createElement("Name");
			Name.appendChild(doc.createTextNode(items.get(i).Name));
			Info.appendChild(Name);
			
			Element PassWord = doc.createElement("PassWord");
			PassWord.appendChild(doc.createTextNode(items.get(i).PassCode));
			Info.appendChild(PassWord);

			// salary elements
			Element id = doc.createElement("ID");
			id.appendChild(doc.createTextNode(items.get(i).Id));
			Info.appendChild(id);
                         
            Element Address = doc.createElement("Address");
			Address.appendChild(doc.createTextNode(items.get(i).Address));
			Info.appendChild(Address);
		}
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(new File("passcodes.xml"));
		
		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}