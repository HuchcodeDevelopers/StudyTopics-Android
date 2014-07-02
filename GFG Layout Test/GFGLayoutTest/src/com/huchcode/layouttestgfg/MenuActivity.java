package com.huchcode.layouttestgfg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {
	
	private Button button;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		button = (Button) findViewById(R.id.buttonLogin);
		button.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(),LoginActivity.class));				
			}
		});
		
		button = (Button) findViewById(R.id.buttonSignup);
		button.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(),SignupActivity.class));				
			}
		});
		
		button = (Button) findViewById(R.id.buttonResetPassword);
		button.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(),ResetPasswordActivity.class));				
			}
		});
		
	}
}
