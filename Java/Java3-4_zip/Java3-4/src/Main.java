import books.Catalogue;
import books.book;
import books.mainBook;
import com.google.gson.Gson;
import enums.fabricEnum;
import factory.factoryClass;
import library.library;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import librarycontroller.LibraryMan;
import org.xml.sax.SAXException;
import parsers.DOM;
import parsers.SAX;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Main
{
    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository()); }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        LOG.info("Starting program_____________________________");

        book v1 = (book)factoryClass.getItem(fabricEnum.book);
        v1.setName("1000 лье под водой");
        v1.setCost(1200);
        v1.setAutor("Жьль верн");
        v1.setPapers(909);
        Catalogue v2 = (Catalogue) factoryClass.getItem(fabricEnum.catalogue);
        v2.setName("Вред бомжей");
        v2.setCost(190);
        v2.setCopyright("ООО МИнскЗаБомжей");
        v2.setPapers(4);

        library lib = new library();
        lib.addToCollection(v1);
        lib.addToCollection(v2);

        LibraryMan dude = LibraryMan.getInsnatce();
        dude.talkAboutLib(lib);
        dude.sort(lib);
        dude.talkAboutLib(lib);
        ////////////////////////////
        ///////////////////////////
        /*XMLEncoder e = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("Test.xml")));
        e.writeObject(v2);
        e.close();*/

        //Валидация (в случае не успеха кинет эксепшн)
        String filename = "files/xml.xml";
        String schemaname = "files/xml.xsd";
        Schema schems = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        schems = factory.newSchema(new File(schemaname));
        Validator validator = schems.newValidator();
        Source source = new StreamSource(filename);
        validator.validate(source);

        //SAX
        System.out.println("SAX");
        SAXParserFactory factory1 = SAXParserFactory.newInstance();
        SAXParser parser = factory1.newSAXParser();
        SAX sax = new SAX();
        parser.parse(new File("files/xml.xml"), sax);
        book v3 = sax.getResult();
        System.out.println(v3.getName() + "   " + v3.getCost());

        //DOM
        System.out.println("DOM");
        DOM dom = new DOM();
        dom.startParser("files/xml.xml");
        System.out.println(dom.items.get(0).getName());

        //XMLtoHtml
        TransformerFactory xstf = TransformerFactory.newInstance();
        Transformer transformer = null;
        transformer=xstf.newTransformer(new StreamSource("files/XSL.xsl"));
        transformer.transform(new StreamSource("files/Html.xml"), new StreamResult("files/info.html"));

        //JSON serialization
        String json = new Gson().toJson(lib.getCollection());
        FileWriter writer = new FileWriter("files/Json.json");
        System.out.println(json);
        writer.write(json);

        LOG.info("Program is end!");

    }
}
