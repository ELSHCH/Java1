import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) {
        // write your code here

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            byte[] buffer = new byte[1024];

            String currentDir = System.getProperty("user.dir");
            System.out.println(currentDir);

            String FilePath = currentDir+"\\"+"files\\Myfile2.zip";
            String outputFolder = currentDir+"\\"+"files\\";
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(FilePath));
            ZipEntry zi =  zipInputStream.getNextEntry();

            String fileName = zi.getName();
            System.out.println(fileName);
            File newFile = new File(outputFolder+fileName);
            FileOutputStream fos = new FileOutputStream(newFile);

            int length;
            while ((length = zipInputStream.read(buffer))>0){
                fos.write(buffer,0,length);
            }
            fos.close();

            zipInputStream.closeEntry();
            zipInputStream.close();

            String ext = "xml";
            ;
            File dir = new File(currentDir + "\\files");
            System.out.println(currentDir);
            String[] list = dir.list();

            DefaultHandler handler = new DefaultHandler() {

                public void startElement(String uri, String localName, String qName,
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
            };
            for (String file : list) {
                if (file.endsWith(ext)) {
                    String xmlFile = file;
                    System.out.println(xmlFile);
                    saxParser.parse(xmlFile, handler);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}