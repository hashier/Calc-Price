package org.loessl.android.calcprice;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Drink extends Activity implements OnClickListener, OnKeyListener {

	private Button calc, del1, del2;
	private EditText quant1, quant2, price1, price2; 
	private TextView solution1, solution2;
	public static final int green = -16711936;
	public static final int red = -65536;



	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drink);

		calc = (Button) findViewById(R.id.MainButtonCalc);

		del1 = (Button) findViewById(R.id.MainButtonDel1);
		del2 = (Button) findViewById(R.id.MainButtonDel2);

		quant1 = (EditText) findViewById(R.id.MainEditQuantity1);
		quant2 = (EditText) findViewById(R.id.MainEditQuantity2);
		price1 = (EditText) findViewById(R.id.MainEditPrice1);
		price2 = (EditText) findViewById(R.id.MainEditPrice2);

		solution1 = (TextView) findViewById(R.id.MainTextViewSolution1);
		solution2 = (TextView) findViewById(R.id.MainTextViewSolution2);
		
		calc.setEnabled(false);

		/* Anonymous function */
		calc.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Float tmp1, tmp2;
				tmp1 = 0.0F;
				tmp2 = 0.0F;

				//calculate 1. price
				if ( (quant1.length() > 0) && (price1.length() > 0) ) {
					tmp1 =
						Float.parseFloat(quant1.getText().toString()) /
						Float.parseFloat(price1.getText().toString());
					solution1.setText(tmp1.toString());
				} else {
					solution1.setText(R.string.MainTextViewError);
				}

				//calculate 2. price
				if ( (quant2.length() > 0) && (price2.length() > 0) ) {
					tmp2 =
						Float.parseFloat(quant2.getText().toString()) /
						Float.parseFloat(price2.getText().toString());
					solution2.setText(tmp2.toString());
				} else {
					solution2.setText(R.string.MainTextViewError);
				}

				//define colors of output
				if (tmp1 > tmp2) {
					solution1.setTextColor(green);
					solution2.setTextColor(red);
				} else if ( tmp1 < tmp2) {
					solution1.setTextColor(red);
					solution2.setTextColor(green);
				} else if (tmp1 == tmp2) {
					solution1.setTextColor(green);
					solution2.setTextColor(green);
				} else {
					solution1.setTextColor(red);
					solution2.setTextColor(red);
				}
			}
		});

		/* with "normal" function, need implements */
		del1.setOnClickListener(this);
		del2.setOnClickListener(this);
		
		price1.setOnKeyListener(this);
		price2.setOnKeyListener(this);
		quant1.setOnKeyListener(this);
		quant2.setOnKeyListener(this);
		
	}

	public void onClick(View v) {
		if ( v.getId() == R.id.MainButtonDel1 ) {
			quant1.setText(null);
			price1.setText(null);
		} else if ( v.getId() == R.id.MainButtonDel2 ) {
			quant2.setText(null);
			price2.setText(null);
		}
	}
	
	public boolean onKey(View v, int keyCode, KeyEvent event) {
        if( (price1.length() > 0) && (quant1.length() > 0) ||
        		( (price2.length() > 0) && (quant2.length() > 0) ) )
            calc.setEnabled(true);
        else
            calc.setEnabled(false);

		return false;
	}
	
}
