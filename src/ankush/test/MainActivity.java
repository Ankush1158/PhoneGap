package ankush.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;


import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements CordovaInterface {
	
	private final ExecutorService threadPool = Executors.newCachedThreadPool();
	
	private CordovaPlugin activityResultCallback;
	private CordovaWebView cordovaWebView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cordovaWebView=(CordovaWebView) findViewById(R.id.cordova_web_view);
		cordovaWebView.loadUrl("file:///android_asset/www/index.html");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ExecutorService getThreadPool() {
		// TODO Auto-generated method stub
		return threadPool;
	}

	@Override
	public Object onMessage(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActivityResultCallback(CordovaPlugin arg0) {
		// TODO Auto-generated method stub
		this.activityResultCallback = arg0;
	}

	@Override
	public void startActivityForResult(CordovaPlugin arg0, Intent arg1, int arg2) {
		// TODO Auto-generated method stub
		this.activityResultCallback = arg0;
	}
}
