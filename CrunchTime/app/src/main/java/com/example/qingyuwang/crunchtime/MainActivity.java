package com.example.qingyuwang.crunchtime;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void something(View v){
        EditText ET = (EditText)findViewById(R.id.editText2);
        String str = ET.getText().toString();
        int n = Integer.valueOf(str);
        int calo = 0;

        TextView put = (TextView)findViewById(R.id.textView9);
        TextView sut = (TextView)findViewById(R.id.textView11);
        TextView jjt = (TextView)findViewById(R.id.textView12);
        TextView jgt = (TextView)findViewById(R.id.textView14);

        TextView cb = (TextView)findViewById(R.id.textView20);

        RadioButton pu = (RadioButton)findViewById(R.id.radioButton);
        RadioButton su = (RadioButton)findViewById(R.id.radioButton2);
        RadioButton jj = (RadioButton)findViewById(R.id.radioButton3);
        RadioButton jg = (RadioButton)findViewById(R.id.radioButton4);

        RadioButton min = (RadioButton)findViewById(R.id.radioButton5);
        RadioButton rep = (RadioButton)findViewById(R.id.radioButton6);


        if (pu.isChecked()&&rep.isChecked()){
            calo = n*100/350;
            cb.setText(calo+" cal");
        }
        else if (su.isChecked()&&rep.isChecked()){
            calo = n*100/200;
            cb.setText(calo+" cal");
        }
        else if (jj.isChecked()&&min.isChecked()){
            calo = n*100/10;
            cb.setText(calo+" cal");
        }
        else if (jg.isChecked()&&min.isChecked()){
            calo = n*100/12;
            cb.setText(calo+" cal");
        }
        else{
            calo = 0;
            cb.setText(calo+" cal");
            new AlertDialog.Builder(this)
                    .setTitle("Warning!")
                    .setMessage("Please make sure that the type of activity and unit matches")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }


        put.setText((calo * 350/100)+"");
        sut.setText((calo * 200/100)+"");
        jjt.setText((calo * 10/100)+"");
        jgt.setText((calo * 12/100)+"");

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(ET.getWindowToken(), 0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
