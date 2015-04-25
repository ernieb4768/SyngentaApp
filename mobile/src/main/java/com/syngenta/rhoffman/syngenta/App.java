package com.syngenta.rhoffman.syngenta;

import android.app.Application;
import android.content.Context;

/**
 * A very small class to create/get the context throughout the app.
 */
public class App extends Application {

	private static Context context;

	@Override
	public void onCreate(){
		super.onCreate();
		context = this;
	}

	public static Context getContext(){
		return context;
	}

}
