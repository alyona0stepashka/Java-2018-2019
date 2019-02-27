package by.belstu.poit.pakholko.parsers;

import by.belstu.poit.pakholko.student.Student;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class SAX extends DefaultHandler {
    Student stud = new Student();
    String thisElement = "";

    @Override
    /** реагирует на событие начала документа. Сюда можно повесить различные действия*/
    public void startDocument() throws SAXException {
        System.out.println("Sax: start parsing");
    }
    /** Парсер идет по документу, встречает элемент его структуры. Начинает работать метод startElement().
     * Причем на самом деле вид его такой: startElement(String namespaceURI, String localName, String qName, Attributes atts).
     * Здесь namespaceURI — это пространство имен, localName — локальное имя элемента,
     * qName- это комбинация локального имени с пространством имен (разделяется двоеточием) и
     * atts — атрибуты данного элемента. Достаточно воспользоваться qName'ом и кинуть его в некоторую служебную
     * строку thisElement. Тем самым мы помечаем в каком элементе в данный момент мы находимся*/
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }
/**За окончание отвечает endElement().Сигнализирует нам что элемент закончился.
 *Очистим Element.*/
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }
/**Пройдя таким образом весь документ, мы придем к концу файла. Сработает endDocument().
 * В нем мы можем высвободить память, сделать какую-то диагностичесую печать и т.д.
 * В нашем случае просто напишем о том что парсинг заканчивается.*/
    @Override
    public void endDocument() {
        System.out.println("Sax: end parsing");
    }

    public Student getResult() {
        return stud;
    }

/**Встретив элемент мы доходим до его значения. Здесь включается метод characters().
 * Он имеет вид: characters(char[] ch, int start, int length).
 *ch — это массив содержащий собственной саму строку-значение внутри данного элемента.
 * start и length — служебные числа обозначающие точку старта в строке и длину.*/
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("name")) {
            stud.setName(new String(ch, start, length));
        }
        if (thisElement.equals("surname")) {
            stud.setSurname(new String(ch, start, length));
        }
        if (thisElement.equals("course")) {
            stud.setCourse(new Integer(new String(ch, start, length)));
        }
        if(thisElement.equals("numOfZach")){
            stud.setNumOfZach(new Integer(new String(ch,start,length)));
        }
    }
}