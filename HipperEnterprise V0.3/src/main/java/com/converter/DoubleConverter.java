/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.converter;

import org.jsefa.common.converter.ConversionException;
import org.jsefa.common.converter.SimpleTypeConverter;

/**
 *
 * @author Tomas
 */
public final class DoubleConverter implements SimpleTypeConverter {
    
    private static final DoubleConverter INSTANCE = new DoubleConverter(); 
    
    /**
     * Returns the single <code>DoubleConverter</code>.
     * 
     * @return the single double converter.
     */
    public static DoubleConverter create() {
        return INSTANCE;
    }

    private DoubleConverter() {

    }

    /**
     * {@inheritDoc}
     * @param value
     * @return the value cast to Double
     */
    @Override
    public Double fromString(String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        try {
            return new Double(value);
        } catch (NumberFormatException e) {
            if (value.charAt(0) == '+') {
                return fromString(value.substring(1));
            }
            throw new ConversionException("Wrong Double format: " + value);
        }
    }

    /**
     * {@inheritDoc}
     * @param value
     * @return the value cast to Strings
     */
    @Override
    public String toString(Object value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
    
}
