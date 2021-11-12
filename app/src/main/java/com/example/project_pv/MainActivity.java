package com.example.project_pv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button bp5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView lon =(TextView)findViewById(R.id.textView3);
        String lh1 = (String) lon.getText().toString();

        final TextView lar =(TextView)findViewById(R.id.textView5);
        String lh2 = (String) lar.getText().toString();
        final TextView longpan =(TextView)findViewById(R.id.textView4);

        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);

        int lh1f = Integer.parseInt(lh1);
        final EditText dis1 =(EditText) findViewById(R.id.Distance);
        String dis = (String) dis1.getText().toString();
        int disf = Integer.parseInt(dis);

        final TextView hypr =(TextView)findViewById(R.id.textView11);
        final TextView adjr =(TextView)findViewById(R.id.textView13);
        final TextView oppr =(TextView)findViewById(R.id.textView12);
        String etage = (String) radioButton.getText().toString();
        bp5=(Button) findViewById(R.id.button4);
        bp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        radioGroup=findViewById(R.id.radioGroup);
        Button buttonOK = findViewById(R.id.button);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                switch(etage)
                {
                    case "1 étage":
                        int hyp=lh1f-disf;
                        int adj= (int) (hyp*0.899);
                        int opp= (int) (hyp*0.5);
                        hypr.setText(Integer.toString(hyp));
                        adjr.setText(Integer.toString(adj));
                        oppr.setText(Integer.toString(opp));


                        break;
                    case "2 étage":
                        int hyp2= (int) (((lh1f*2)+2.5)-disf);
                        int adj2= (int) (hyp2*0.899);
                        int opp2= (int) (hyp2*0.5);
                        hypr.setText(Integer.toString(hyp2));
                        adjr.setText(Integer.toString(adj2));
                        oppr.setText(Integer.toString(opp2));
                        break;

                    case "3 étage":
                        int hyp3= (int) (((lh1f*3)+2.5)-disf);
                        int adj3= (int) (hyp3*0.899);
                        int opp3= (int) (hyp3*0.5);
                        hypr.setText(Integer.toString(hyp3));
                        adjr.setText(Integer.toString(adj3));
                        oppr.setText(Integer.toString(opp3));
                        break;
                }

                
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String marque = parent.getItemAtPosition(i).toString();
        final TextView lon =(TextView)findViewById(R.id.textView3);
        final TextView lar =(TextView)findViewById(R.id.textView5);
        switch (marque)
        {
            case "choisir votre panneau":

                lon.setText(R.string.pardefaut1) ;
                lar.setText(R.string.pardefaut1) ;
                break;
            case "Panneau Jonsol Monocristallin 320_340 W":
                lon.setText(R.string.lojons1) ;
                lar.setText(R.string.larjon11) ;
                break;
            case "Panneau Jonsol Monocristallin 375_390 W":
                lon.setText(R.string.lojons2) ;
                lar.setText(R.string.larjon22) ;
                break;
            case "Panneau Jonsol Monocristallin 390_415 W":
                lon.setText(R.string.lojons3) ;
                lar.setText(R.string.larjon33) ;
                break;
            case "Panneau Jonsol Monocristallin 430_450 W":
                lon.setText(R.string.lojons4) ;
                lar.setText(R.string.larjon44) ;
                break;
            case "Panneau Jonsol Monocristallin 530_550 W":
                lon.setText(R.string.lojons5) ;
                lar.setText(R.string.larjon55) ;
                break;
            case "Panneau Axitec Monocristallin 350_380 W":
                lon.setText(R.string.longeuraxitec1) ;
                lar.setText(R.string.largeuraxitec11) ;
                break;
            case "Panneau Axitec Monocristallin 390_410 W":
                lon.setText(R.string.longeuraxitec2) ;
                lar.setText(R.string.largeuraxitec22) ;
                break;
            case "Panneau Axitec Monocristallin 430_455 W":
                lon.setText(R.string.longeuraxitec3) ;
                lar.setText(R.string.largeuraxitec33) ;
                break;
            case "Panneau Axitec Monocristallin 530_545 W":
                lon.setText(R.string.longeuraxitec4) ;
                lar.setText(R.string.largeuraxitec44) ;
                break;



        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}