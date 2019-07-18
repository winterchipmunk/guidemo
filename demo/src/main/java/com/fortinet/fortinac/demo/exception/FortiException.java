package com.fortinet.fortinac.demo.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author LD
 */
@SuppressWarnings("serial")
public class FortiException extends RuntimeException
{
    private String key;
    private Object[] m_aobjArg = null;
    
    final static String KEY_GENERAL = "error.public.general";

    public FortiException()
    {
        this.setKey(KEY_GENERAL);
    }

    public FortiException(String key)
    {
        this.setKey(key);
    }
    
    public FortiException(String key, Object[] aobjArg)
    {
        this.setArguments(aobjArg);
        this.setKey(key);
    }

    public FortiException(String message, Throwable cause)
    {
        super(message, cause);
        this.setKey(KEY_GENERAL);
    }

    public FortiException(Throwable cause)
    {
        super(cause);
        this.setKey(KEY_GENERAL);
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public Object[] getArguments()
    {
        return m_aobjArg;
    }

    public void setArguments(Object[] aobjArg)
    {
        m_aobjArg = aobjArg;
    }

    public static FortiException getException(String key)
    {
        return new FortiException(key);
    }

    public static FortiException getException(String sKey, Object[] aobjArg)
    {
        return new FortiException(sKey, aobjArg);
    }

    public static String getErrorMsg(Exception e)
    {
        Writer swr = new StringWriter();
        PrintWriter sw = new PrintWriter(swr);
        e.printStackTrace(sw);
        return swr.toString();
    }
}
