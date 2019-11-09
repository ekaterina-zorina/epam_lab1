package by.epam.tour_agency.dao.util;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Class of serialization objects to xml file.
 * The close method is called automatically when existing
 * a try-with-resources block.
 */
public class XMLSerializer implements AutoCloseable {
    private XMLEncoder encoder;

    public XMLSerializer(String path) throws FileNotFoundException {
        encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
    }

    /**
     * Serializes object to xml file.
     */
    public void serialize(Object obj) {
        encoder.writeObject(obj);
    }

    @Override
    public void close() {
        encoder.close();
    }
}
