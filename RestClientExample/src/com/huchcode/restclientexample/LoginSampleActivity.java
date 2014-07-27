package com.huchcode.restclientexample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class LoginSampleActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}

    @Override
    protected void onStart() {
        super.onStart();
        new HttpLoginRequestTask().execute();
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
		/*
		findViewById(R.id.action_refersh)
		*/

		/*
		if (id == R.id.action) {
			new HttpRequestTask().execute();
			return true;
		}
		*/
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	

    private class HttpLoginRequestTask extends AsyncTask<Void, Void, Employee> {
		@Override
        protected Employee doInBackground(Void... params) {
			/* In the case of post */
			Map<String, String> vars = new HashMap<String, String>();
	        vars.put("username", "gikimiad@gmail.com");
	        vars.put("password", "PASSWORD_FOR_PARKYONGGYU");

            //final String url = "http://192.168.0.215:5000/";
            try {
                //final String url = "http://192.168.1.103:8080/SpringRestExample/rest/emp/dummy";
                //final String url = "http://10.0.1.6:8080/SpringRestExample/rest/emp/dummy";
                //final String url = "http://192.168.0.215:5000/login";
                final String url = "http://192.168.0.215:5000/login";
                RestTemplate restTemplate = new RestTemplate();                
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                //return restTemplate.getForObject(url, Employee.class);
                
                /* In the case of post */
                Employee e = new Employee();
                e.setId(1);
                e.setName("박용규");
                return restTemplate.postForObject(url, e, Employee.class, vars);
                
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Employee employee) {
        	/*
            TextView employeeIdText = (TextView) findViewById(R.id.id_value);
            TextView employeeNameText = (TextView) findViewById(R.id.name_value);
            TextView employeeCreatedDateText = (TextView) findViewById(R.id.createdDate_value);
            employeeIdText.setText(String.valueOf(employee.getId()));
            employeeNameText.setText(employee.getName());
            employeeCreatedDateText.setText(employee.getCreatedDate().toString());
            */
        }

    }	
    
    /*
    public static Result create(JSONObject jObj) throws JSONException {
    	Result result = new Result();
    	if ( jObj != null ) {
    		result.code = jObj.getInt("code");
    		result.msg = jObj.getString("msg");
    	}
    	return result;
    }
    */

}
