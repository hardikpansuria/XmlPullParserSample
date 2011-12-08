package com.demo.test;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

public class XmlPullParsing {

	protected XmlPullParser xmlpullparser;
    String output;
    String TAG="XmlPullParsing";
    public XmlPullParsing(InputStream is) {

        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        factory.setNamespaceAware(true);
        try {
            xmlpullparser = factory.newPullParser();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        try {
            xmlpullparser.setInput(is, "UTF-8");
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        int eventType = 0;
        try {
            eventType = xmlpullparser.getEventType();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (eventType != XmlPullParser.END_DOCUMENT) {

            parseTag(eventType);
            try {
                eventType = xmlpullparser.next();
            } catch (XmlPullParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

    void parseTag(int event){

        switch (event) {

        case XmlPullParser.START_DOCUMENT:
            Log.i(TAG,"START_DOCUMENT");
            break;

        case XmlPullParser.END_DOCUMENT:
            Log.i(TAG,"END_DOCUMENT");
            break;
        case XmlPullParser.START_TAG:
            Log.i(TAG,"START_TAG"+xmlpullparser.getName());
            Log.i(TAG,"Attribute Name"+xmlpullparser.getAttributeValue(null,"category"));

            break;

        case XmlPullParser.END_TAG:
            Log.i(TAG,"END_TAG"+xmlpullparser.getName());

            break;

        case XmlPullParser.TEXT:
            Log.i(TAG,"TEXT");
            output = xmlpullparser.getText();
            Log.i("valuee==============================",""+output);
            break;
        }

    }
	
	
	
	
}
