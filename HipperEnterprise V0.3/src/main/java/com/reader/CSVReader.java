/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Example of how it can be used.
/*public static void main(String[] args) {
 //Get a stream of the csv file to read.
 InputStream is = null;
 try {
 is = new FileInputStream("C:/Users/Tomas/Desktop/Heup zijwaards ahmed.csv");
 } catch (Exception e) {
 System.out.println(e.getMessage());
 }
        
 //Set stream to Reader
 Reader reader = new InputStreamReader(is);
        
 //Create CSVReader instance with SensorData as serializable model
 CSVReader csv = new CSVReader(reader, SensorData.class);
        
 // Deserialize the stream
 csv.deserialize();
        
 // Get deserialized Items
 List<SensorData> data = csv.getItems();
        
 //Loop and print the items
 for (SensorData sd : data) {
 System.out.println(sd);
 }
 }*/
package com.reader;

import com.converter.DoubleConverter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import org.jsefa.csv.CsvDeserializer;
import org.jsefa.csv.CsvIOFactory;
import org.jsefa.csv.config.CsvConfiguration;

/**
 *
 * @author Tomas
 * @param <Item>
 */
public class CSVReader<Item> {

    //private String path;
    private Reader stream;
    private Class item;
    private CsvDeserializer deserializer;
    private List<Item> items;

    /**
     *
     * @param fileStream
     * @param c
     */
    public CSVReader(Reader fileStream, Class c) {
        this.stream = fileStream;
        this.item = c;
        this.items = null;

        createDeserializer();
    }

    private void createDeserializer() {
        CsvConfiguration config = new CsvConfiguration();
        config.setLineFilter(new HeaderAndFooterFilter(1, false, true));
        config.setFieldDelimiter(',');
        config.getSimpleTypeConverterProvider().registerConverterType(double.class, DoubleConverter.class);
        config.getSimpleTypeConverterProvider().registerConverterType(Double.class, DoubleConverter.class);
        this.deserializer = CsvIOFactory.createFactory(config, this.item).createDeserializer();
    }

    /**
     *
     */
    public void deserialize() {

        if (this.stream != null) {
            this.deserializer.open(stream);
            this.items = new ArrayList<Item>();

            while (deserializer.hasNext()) {
                Item i = (Item) deserializer.next();
                items.add(i);
            }

            this.deserializer.close(true);
        }
    }

    /**
     * @return the stream
     */
    public Reader getStream() {
        return stream;
    }

    /**
     * @param stream the stream to set
     */
    public void setStream(Reader stream) {
        this.stream = stream;
    }

    /**
     *
     * @return List of deserialized items
     */
    public List<Item> getItems() {
        return this.items;
    }

}
