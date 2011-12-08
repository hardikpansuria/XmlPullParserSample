package com.demo.test;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author hardik
 * email : happygeekblog@gmail.com
 */

public class XmlpullparserActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        try {
			InputStream is = getAssets().open("myxml.xml");
			new XmlPullParsing(is) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}