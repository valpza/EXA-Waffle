package com.example.vale.eva1_examen_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity
        implements  RadioGroup.OnCheckedChangeListener
{
    EditText edT1, edT2, edT3, edT4, edT5, edT6, edT7, edT8;
    RadioGroup RGF;
    RadioButton rbDe, rbBi;
    TextView TxtVIP, TxtVMa, TxtVSub, TxtVPre;
    Button btC, btB;
    int deci,deci2,deci3,deci4,deci5,deci6,deci7,deci8;
    String Des, S1,S2,S3,S4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edT1 = findViewById(R.id.edT1);
        edT2 = findViewById(R.id.edT2);
        edT3 = findViewById(R.id.edT3);
        edT4 = findViewById(R.id.edT4);
        edT5 = findViewById(R.id.edT5);
        edT6 = findViewById(R.id.edT6);
        edT7 = findViewById(R.id.edT7);
        edT8 = findViewById(R.id.edT8);
        RGF = findViewById(R.id.RGF);
        rbDe = findViewById(R.id.rbDe);
        rbBi = findViewById(R.id.rbBi);
        TxtVIP = findViewById(R.id.TxtVIP);
        TxtVMa = findViewById(R.id.TxtVMa);
        TxtVSub = findViewById(R.id.TxtVSub);
        TxtVPre = findViewById(R.id.TxtVPre);
        btC = findViewById(R.id.btC);
        btB = findViewById(R.id.btB);

        btB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edT1.setText("");
                edT2.setText("");
                edT3.setText("");
                edT4.setText("");
                edT5.setText("");
                edT6.setText("");
                edT7.setText("");
                edT8.setText("");
                TxtVIP.setText("IP ");
                TxtVMa.setText("Mask ");
                TxtVSub.setText("Subred ");
                TxtVPre.setText("Prefijo ");


            }
        });

        btC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbBi.isChecked()) {
                    int deci = Integer.parseInt(edT1.getText().toString());
                    int  deci2 = Integer.parseInt(edT2.getText().toString());
                    int  deci3 = Integer.parseInt(edT3.getText().toString());
                    int  deci4 = Integer.parseInt(edT4.getText().toString());
                    int  deci5 = Integer.parseInt(edT5.getText().toString());
                    int deci6 = Integer.parseInt(edT6.getText().toString());
                    int  deci7 = Integer.parseInt(edT7.getText().toString());
                    int  deci8 = Integer.parseInt(edT8.getText().toString());
                    String bin = Integer.toBinaryString(deci);
                    String bin2 = Integer.toBinaryString(deci2);
                    String bin3 = Integer.toBinaryString(deci3);
                    String bin4 = Integer.toBinaryString(deci4);
                    String bin5 = Integer.toBinaryString(deci5);
                    String bin6 = Integer.toBinaryString(deci6);
                    String bin7 = Integer.toBinaryString(deci7);
                    String bin8 = Integer.toBinaryString(deci8);
                    TxtVIP.setText("IP  " + bin + ",  " + bin2 + ",  " + bin3 + ",  " + bin4 );
                    TxtVMa.setText("Mask  " + bin5 + ",  " + bin6 + ",  " + bin7 + ",  " + bin8 );

                }
                if (rbDe.isChecked()){
                    int deci = Integer.parseInt(edT1.getText().toString());
                    int deci2 = Integer.parseInt(edT2.getText().toString());
                    int deci3= Integer.parseInt(edT3.getText().toString());
                    int deci4 = Integer.parseInt(edT4.getText().toString());
                    int deci5 = Integer.parseInt(edT5.getText().toString());
                    int deci6 = Integer.parseInt(edT6.getText().toString());
                    int deci7= Integer.parseInt(edT7.getText().toString());
                    int deci8 = Integer.parseInt(edT8.getText().toString());
                    TxtVIP.setText("IP  " + deci + ",  " + deci2 + ",  " + deci3 + ",  " + deci4);
                    TxtVMa.setText("Mask  " + deci5 + ",  " + deci6 + ",  " + deci7 + ",  " + deci8);

                }
                int pref = 0;
                while (deci5>0) {
                    int cociente = deci5 / 2;//cociente
                    int residuo = deci5 % 2;//residuo
                    deci5 = cociente;
                    S1 += residuo;
                    if (residuo == 1) {
                        pref++;
                    }
                }
            }

        });



    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) { //int es el id del boton que se presiono
        switch (checkedId) {
            case R.id.rbDe://aqui se sabe cual boton pico
                Des = "Desimal";
                break;
            case R.id.rbBi:
                Des = "Binario";
                break;
        }
    }

}
