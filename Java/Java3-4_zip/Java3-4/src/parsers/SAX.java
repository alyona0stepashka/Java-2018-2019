package parsers;

import books.book;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class SAX extends DefaultHandler {
    book element = new book();
    String thisElement = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() {
        System.out.println("end parsing");
    }

    public book getResult() {
        return element;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("name")) {
            element.setName(new String(ch, start, length));
        }
        if (thisElement.equals("papers")) {
            element.setPapers(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("cost")) {
            element.setCost(new Integer(new String(ch, start, length)));
        }
        if(thisElement.equals("autor")){
            element.setAutor(new String(ch,start,length));
        }
    }
}