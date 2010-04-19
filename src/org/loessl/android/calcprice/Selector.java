package org.loessl.android.calcprice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Selector extends Activity {
	
	private Button btnAlc;
	private Button btnPizza;
	private Button btnDrink;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnAlc = ( Button) findViewById( R.id.btnAlc);
		btnAlc.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Selector.this, Alc.class);
				startActivity(i);
			}
		});
		
		btnPizza = ( Button) findViewById( R.id.btnPizza);
		btnPizza.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Selector.this, Pizza.class);
				startActivity(i);
			}
		});
		
		btnDrink = ( Button) findViewById( R.id.btnDrink);
		btnDrink.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(Selector.this, Drink.class);
				startActivity(i);
			}
		});

	}
}