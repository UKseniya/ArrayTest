import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class SaveToXML extends Output { // наследование

    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40mb
    private static SaveToXML instance;

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc;
    Element element = null;

    private SaveToXML() { // инкапсуляция

    }

    public static SaveToXML getInstance() {
        if (instance == null) {
            instance = new SaveToXML();
        }
        return instance;
    }

    @Override
    public void print(NumberHolder[] num) throws ExceededFileSizeException { // �����������

        try {
            doc = factory.newDocumentBuilder().newDocument();

            Element rootElement = doc.createElement("array");
            doc.appendChild(rootElement);

            for (int i = 0; i < num.length; i++) {
                NumberHolder numberHolder = new NumberHolder(num[i].getNumber());
                element = doc.createElement("element");
                rootElement.appendChild(element);
                Attr attr = doc.createAttribute("id");
                attr.setValue(num[i].toString());
                Element number = doc.createElement("number");
                number.appendChild(doc.createTextNode(String.valueOf(numberHolder.getNumber())));
                element.appendChild(number);
                Element isEven = doc.createElement("isEven");
                isEven.appendChild(doc.createTextNode(String.valueOf(numberHolder.isEven())));
                element.appendChild(isEven);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        File file = new File("C:\\Users\\Kseniya\\temp.xml");

        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(file));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        if (file.length() > MAX_FILE_SIZE) {
            throw new ExceededFileSizeException("The file size exceeds the limit");
        }
    }
}
