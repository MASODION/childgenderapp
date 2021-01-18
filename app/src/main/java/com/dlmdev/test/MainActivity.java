package com.dlmdev.test;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView mDisplayDate1;
    private DatePickerDialog.OnDateSetListener mDateSetListener1;
    private TextView mDisplayDate2;
    private DatePickerDialog.OnDateSetListener mDateSetListener2;
    private TextView text;
    private Button btn;
    private int f_day, f_month, f_year, m_day, m_month, m_year, c_day, c_month, c_year;
    
   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       text = (TextView) findViewById(R.id.text);
       mDisplayDate = (TextView) findViewById(R.id.clDateF);
       mDisplayDate.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
               Calendar cal = Calendar.getInstance();
               f_year = cal.get(Calendar.YEAR);
               f_month = cal.get(Calendar.MONTH);
               f_day = cal.get(Calendar.DAY_OF_MONTH);
               DatePickerDialog dialog = new DatePickerDialog(
                       MainActivity.this,
                       android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                       mDateSetListener,
                       f_year, f_month, f_day);
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dialog.show();
           }
       });

       mDateSetListener = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker datePicker, int year, int month, int day) {
               month = month + 1;
               Log.d(TAG, "onDateSet: dd/mm/yyyy: " + day + "/" + month + "/" + year);

               String date = day + "/" + month + "/" + year;
               mDisplayDate.setText(date);
               f_year = year;

           }
       };
       mDisplayDate1 = (TextView) findViewById(R.id.clDateM);
       mDisplayDate1.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
               Calendar cal = Calendar.getInstance();
               m_year = cal.get(Calendar.YEAR);
               m_month = cal.get(Calendar.MONTH);
               m_day = cal.get(Calendar.DAY_OF_MONTH);
               DatePickerDialog dialog = new DatePickerDialog(
                       MainActivity.this,
                       android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                       mDateSetListener1,
                       m_year, m_month, m_day);
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dialog.show();
           }
       });

       mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker datePicker, int year, int month, int day) {
               month = month + 1;
               Log.d(TAG, "onDateSet: dd/mm/yyyy: " + day + "/" + month + "/" + year);

               String date = day + "/" + month + "/" + year;
               mDisplayDate1.setText(date);
                m_year = year;
           }
       };
       mDisplayDate2 = (TextView) findViewById(R.id.clDateC);
       mDisplayDate2.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
               Calendar cal = Calendar.getInstance();
               c_year = cal.get(Calendar.YEAR);
               c_month = cal.get(Calendar.MONTH);
               c_day = cal.get(Calendar.DAY_OF_MONTH);
               DatePickerDialog dialog = new DatePickerDialog(
                       MainActivity.this,
                       android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                       mDateSetListener2,
                       c_year, c_month, c_day);
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               dialog.show();
           }
       });

       mDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker datePicker, int year, int month, int day) {
               month = month + 1;
               Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

               String date = day + "/" + month + "/" + year;
               mDisplayDate2.setText(date);
               c_year = year;
               c_month = month;
           }
       };
       btn = (Button) findViewById(R.id.clAfla);
       btn.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
               if(f_year > 0 && m_year > 0 && c_year > 0) {
            	   String test;
                   int t2;
                   int m2;
                   while (f_year + 3 < c_year) {
                       f_year = f_year + 3;
                   }
                   t2 = f_year + 3;
                   while (m_year + 4 < c_year) {
                       m_year = m_year + 4;
                   }
                   m2 = m_year + 4;
                   if (f_year == m_year) {
                       if (minim(Math.abs(t2 - c_year), Math.abs(m2 - c_year)) == 1) {
                           test = "Daca veti ramane insarcinata in luna " + c_month + "/" + c_year
                                   + ", veti avea un baietel." + data_nasterii(c_month, c_year);
                           text.setText(test);
                       } else
                           test = "Daca veti ramane insarcinata in luna " + c_month + "/" + c_year
                                   + ", veti avea o fetita." + data_nasterii(c_month, c_year);
                           text.setText(test);
                   } else {
                       int d1 = Math.abs(c_year - f_year);
                       int d2 = Math.abs(c_year - m_year);
                       int d3 = Math.abs(t2 - c_year);
                       int d4 = Math.abs(m2 - c_year);
                       if (d1 < d2) {
                           if (d4 < d3) {
                               test = "Daca veti ramane insarcinata in luna " + c_month + "/" + c_year
                                       + ", veti avea o fetita." + data_nasterii(c_month, c_year);
                               text.setText(test);
                           } else {
                               test = "Daca veti ramane insarcinata in luna " + c_month + "/" + c_year
                                       + ", veti avea un baietel." + data_nasterii(c_month, c_year);
                               text.setText(test);
                           }
                       } else {
                           if (d3 < d4) {
                               test = "Daca veti ramane insarcinata in luna " + c_month + "/" + c_year
                                       + ", veti avea un baietel." + data_nasterii(c_month, c_year);
                               text.setText(test);
                           } else {
                               test = "Daca veti ramane insarcinata in luna " + c_month + "/" + c_year
                                       + ", veti avea o fetita." + data_nasterii(c_month, c_year);
                               text.setText(test);
                           }
                       }
                   }
               }
               else {
                   String test = "Trebuie sa introduci datele de nastere.";
                   text.setText(test);
               }
           }
       });
   }

    
    
    public static int minim(int a, int b) {
		if (a < b)
			return a;
		else
			return b;
	}

	public static int maxim(int a, int b) {
		if (a > b)
			return 1;
		else
			return 2;
	}

	public static String data_nasterii(int l, int a) {
		if (l + 9 > 12) {
			a++;
			l = 9 - (12 - l);
			return " Se va naste aproximativ in luna " + l + "/" + a + ".";
		} else
			return " Se va naste aproximativ in luna " + (l + 9) + "/" + a + ".";
	}


}
