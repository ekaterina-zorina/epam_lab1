package by.epam.tour_agency.dao.util;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Class of deserialization objects from xml file.
 * The close method is called automatically when existing
 * a try-with-resources block.
 */
public class XMLDeserializer implements AutoCloseable {
    private XMLDecoder decoder;

    public XMLDeserializer(String path) throws FileNotFoundException {
        decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
    }

    /**
     * Deserializes object from xml file.
     *
     * @return deserialized object
     */
    public Object deserialize() {
        Object result = decoder.readObject();
        return result;
    }

    @Override
    public void close() {
        decoder.close();
    }
}
