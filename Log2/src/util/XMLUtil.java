package util;

import model.User;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class XMLUtil {

    public static void exportToXML(List<User> users, String filePath) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element root = doc.createElement("users");
        doc.appendChild(root);

        for (User user : users) {
            Element userElement = doc.createElement("user");
            root.appendChild(userElement);

            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(user.getUsername()));
            userElement.appendChild(username);

            Element hashedPassword = doc.createElement("hashedPassword");
            hashedPassword.appendChild(doc.createTextNode(user.getHashedPassword()));
            userElement.appendChild(hashedPassword);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // Cài đặt format đẹp dễ nhìn
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);
    }

    public static List<User> importFromXML(String filePath) throws Exception {
        List<User> users = new ArrayList<>();
        File xmlFile = new File(filePath);

        if (!xmlFile.exists()) {
            return users; // nếu file chưa tồn tại thì trả list rỗng
        }

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("user");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                String username = elem.getElementsByTagName("username").item(0).getTextContent();
                String hashedPassword = elem.getElementsByTagName("hashedPassword").item(0).getTextContent();
                users.add(new User(username, hashedPassword));
            }
        }
        return users;
    }
}
