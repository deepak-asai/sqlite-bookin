package com.example.deepak.sqlite_booking;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {

    EditText inp;
    TextView disp;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp=(EditText) findViewById(R.id.input);
       disp=(TextView)  findViewById(R.id.disp);
        dbHandler=new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    public void printDatabase(){
        String dbString= dbHandler.databasetostring();
        disp.setText(dbString);
        inp.setText(" ");
    }

    public void addMovieBut(View v){
        Movie movie= new Movie(inp.getText().toString());
        dbHandler.addMovie(movie);
        printDatabase();
    }

    public void deleteMovieBut(View v){
        String str=inp.getText().toString();
        dbHandler.deleteMovie(str);
        printDatabase();
    }
}
