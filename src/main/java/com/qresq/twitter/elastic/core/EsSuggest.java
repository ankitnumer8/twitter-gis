package com.qresq.twitter.elastic.core;
import java.util.List;

/**
 * The Class EsSuggest.
 */
public class EsSuggest {

    /**  The field name. */
    private String fieldname;

    /**  The value of field. */
    private String value;

    /**  The context field name. */
    private String contextFieldname;

    /**  The context value. */
    private List<String> contextValue;

    /**
     * Default constructor.
     * 
     * @param fieldname the field name
     * @param value the value of field
     * @param contextFieldname the context field name
     * @param contextValue the context value.
     */
    public EsSuggest(String fieldname, String value, String contextFieldname, List<String> contextValue) {
        super();
        this.fieldname = fieldname;
        this.value = value;
        this.contextFieldname = contextFieldname;
        this.contextValue = contextValue;
    }

    /**
     * Getter for property fieldname.
     * 
     * @return Value of property fieldname.
     */
    public String getFieldname() {
        return fieldname;
    }

    /**
     * Getter for property value.
     * 
     * @return Value of property value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Getter for property contextFieldname.
     * 
     * @return Value of property contextFieldname.
     */
    public String getContextFieldname() {
        return contextFieldname;
    }

    /**
     * Getter for property contextValue.
     * 
     * @return Value of property contextValue.
     */
    public List<String> getContextValue() {
        return contextValue;
    }

}
