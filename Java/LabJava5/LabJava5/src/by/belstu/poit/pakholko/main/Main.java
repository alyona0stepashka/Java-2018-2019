package by.belstu.poit.pakholko.main;
import by.belstu.poit.pakholko.parsers.SAX;
import by.belstu.poit.pakholko.parsers.ValidatorXSD;
import by.belstu.poit.pakholko.student.Student;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.*;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
//import org.xml.sax.SAXException;

import com.google.gson.Gson;

//import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
//import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.*;
import java.util.*;
//import java.util.List;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        ValidatorXSD val = new ValidatorXSD();
        val.valid();

        try {
            //SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAX sax = new SAX();
            parser.parse(new File("files/XML.xml"), sax);
            Student im = sax.getResult();
            System.out.println(im.getName() + "   " + im.getSurname());
            //eXtensible Markup Lang
            //Xml Schema Document
            //JavaScript Object Notation
            TransformerFactory xstf = TransformerFactory.newInstance();
            Transformer transformer = null;
            transformer=xstf.newTransformer(new StreamSource("files/XSL.xsl"));
            transformer.transform(new StreamSource("files/XMLtoHTML.xml"), new StreamResult("files/info.html"));

            //serialization
            FileOutputStream out = new FileOutputStream("files/serializ.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(out);
            xmlEncoder.writeObject(im);
            xmlEncoder.close();

            //Deserialization
            FileInputStream in = new FileInputStream("files/serializ.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(in);
            Student m = (Student) xmlDecoder.readObject();
            xmlDecoder.close();
            System.out.println("from deserializ: " + m.getName() + " " + m.getCourse());

            //json
            FileWriter out_JSON = new FileWriter("files/toJSON.json", true);
            Collection collection = new ArrayList<Student>();
            collection.add(m);
            collection.add(m);
            Gson gson = new Gson();
            gson.toJson(collection, out_JSON);
            out_JSON.close();

            FileReader in_JSON = new FileReader("files/toJSON.json");
            Student m1 = gson.fromJson(in_JSON, Student.class);
            in_JSON.close();

        }
       catch(Exception e){
           LOG.error(e.getMessage());
       }
    }
}