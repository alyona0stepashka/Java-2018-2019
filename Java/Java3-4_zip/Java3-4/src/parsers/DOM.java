package parsers;

import books.book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DOM {
    public List<book> items;

    public void startParser(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Root");

            items = new ArrayList<book>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                items.add(getLanguage( nodeList.item(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static book getLanguage(Node node){
        book item = new book();
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            item.setName(getTagValue("name", element));
            item.setAutor(getTagValue("autor", element));
            item.setPapers(Integer.parseInt(getTagValue("papers",element)));
            item.setCost(Integer.parseInt(getTagValue("cost",element)));
        }
        return item;
    }

    public static String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node)nodeList.item(0);
        return node.getNodeValue();
    }
}