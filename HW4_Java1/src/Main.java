import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.Hashtable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
    public static class SAXLocalNameCount extends DefaultHandler {

        private Hashtable tags;
//
//        public void startDocument() throws SAXException {
//            tags = new Hashtable();
    }


    public static void main(String[] args) throws IOException {

//        public class SAXLocalNameCount extends DefaultHandler {
//
//            private Hashtable tags;
//
//            public void startDocument() throws SAXException {
//                tags = new Hashtable();
//            }
//
//            public void endDocument() throws SAXException {
//                Enumeration e = tags.keys();
//                while (e.hasMoreElements()) {
//                    String tag = (String) e.nextElement();
//                    int count = ((Integer) tags.get(tag)).intValue();
//                    System.out.println("Local Name \"" + tag + "\" occurs "
//                            + count + " times");
//                }
//            }
//        }

        // write your code here

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new SAXLocalNameCount());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();

            byte[] buffer = new byte[1024];

            String currentDir = System.getProperty("user.dir");
            //System.out.println(currentDir);

            String FilePath = currentDir + "\\" + "files\\Myfile2.zip";
            String outputFolder = currentDir + "\\" + "files\\";
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(FilePath));
            ZipEntry zi = zipInputStream.getNextEntry();

            String fileName = zi.getName();
            //System.out.println(fileName);
            File newFile = new File(outputFolder + fileName);
            FileOutputStream fos = new FileOutputStream(newFile);

            int length;
            while ((length = zipInputStream.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            fos.close();

            zipInputStream.closeEntry();
            zipInputStream.close();

            String ext = "xml";
            File dir = new File(currentDir + "\\files");
            // System.out.println(dir);
            String[] list = dir.list();

            DefaultHandler handler = new DefaultHandler();

           /*     public void startElement(String uri, String localName, String qName,
                                         Attributes attributes) throws SAXException {

                    System.out.println(qName);
                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                    System.out.println(qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    System.out.println(new String(ch, start, length));
                }
            };*/
            File xmlFile =new File(dir.list()[0]);
            System.out.println(xmlFile);
            for (String file : list) {
                if (file.endsWith(ext)) {
                    xmlFile = new File(file);
                }
            }
            if (xmlFile != null){
                StringBuffer sbuffer = new StringBuffer("");
                FileInputStream fin = new FileInputStream(dir + "\\" + xmlFile);
                int len;
                int ch;
                while ((ch = fin.read()) != -1) {
                    sbuffer.append((char) ch);
                    //     System.out.println(sbuffer.toString());
                    //    System.out.println(xmlFile);
                }
                // System.out.println(sbuffer.toString());
                Document doc = builder.parse(new InputSource(new StringReader(sbuffer.toString())));

                //   saxParser.parse(new InputSource(new StringReader(sbuffer.toString())), handler);
                // Document doc = builder.parse(xmlFile);
                // convertFileURL(xmlFile);
                //  xmlReader.parse(new InputSource(new StringReader(sbuffer.toString())));

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                if (doc.hasChildNodes()) {

                    printNote(doc.getChildNodes());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void printNote(NodeList nodeList) {

        for (int count = 0; count < nodeList.getLength(); count++) {

            Node tempNode = nodeList.item(count);

            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

                // get node name and value
                System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {

                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());

                    }

                }

                if (tempNode.hasChildNodes()) {

                    // loop again if has child nodes
                    printNote(tempNode.getChildNodes());

                }

                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

            }

        }
    }
}
