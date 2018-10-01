package com.example.iowner.eva1_examen_practico_problema_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,Button.OnClickListener {

    EditText editTxt1,editTxt2,editTxt3,editTxt4,editTxt5,editTxtNum;
    RadioGroup rdGrpSerie;
    Button btnVerificar;
    String sRespuesta;
    String sEstado = "Alge";
    int iIntentos = 3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //VINCULAMOS WIDGETS
        editTxt1 = findViewById(R.id.editTxt1);
        editTxt2 = findViewById(R.id.editTxt2);
        editTxt3 = findViewById(R.id.editTxt3);
        editTxt4 = findViewById(R.id.editTxt4);
        editTxt5 = findViewById(R.id.editTxt5);
        editTxtNum = findViewById(R.id.editTxtNum);
        rdGrpSerie = findViewById(R.id.rdGrpSerie);
        btnVerificar = findViewById(R.id.btnVerificar);
        //ASIGNAMOS LISTENERS
        rdGrpSerie.setOnCheckedChangeListener(this);
        btnVerificar.setOnClickListener(this);
        editTxt1.setFocusable(false);
        editTxt2.setFocusable(false);
        editTxt3.setFocusable(false);
        editTxt4.setFocusable(false);
        editTxt5.setFocusable(false);
        serieAlgebraica();

    }

    //METODOS PARA GENERAR SERIES
    public void serieAlgebraica(){
        int[] numeros = new int[5];
        numeros[0] = (int)(Math.random()*10)+1;
        int var = (int)(Math.random()*10)+1;
        for(int i = 1;i<5;i++)
        {
            numeros[i] = numeros[0] * ((int)Math.pow(var,(i)));
        }
        editTxt1.setText(""+numeros[0]);
        editTxt2.setText(""+numeros[1]);
        editTxt3.setText(""+numeros[2]);
        editTxt4.setText(""+numeros[3]);
        editTxt5.setText(""+numeros[4]);

        int variante = (int)(Math.random()*4);
        sRespuesta = numeros[variante]+"";
        switch(variante){
            case 0:
                editTxt1.setText("");
                break;
            case 1:
                editTxt2.setText("");
                break;
            case 2:
                editTxt3.setText("");
                break;
            case 3:
                editTxt4.setText("");
                break;
            case 4:
                editTxt5.setText("");
                break;
        }
    }
    public void serieAritmetica(){
        int[] numeros = new int[5];
        numeros[0] = (int)(Math.random()*10)+1;
        int var = (int)(Math.random()*10)+1;
        for(int i = 1;i<5;i++)
        {
            numeros[i] = numeros[0] + (i)*var;
        }
        editTxt1.setText(""+numeros[0]);
        editTxt2.setText(""+numeros[1]);
        editTxt3.setText(""+numeros[2]);
        editTxt4.setText(""+numeros[3]);
        editTxt5.setText(""+numeros[4]);

        int variante = (int)(Math.random()*4);
        sRespuesta = numeros[variante]+"";
        switch(variante){
            case 0:
                editTxt1.setText("");
                break;
            case 1:
                editTxt2.setText("");
                break;
            case 2:
                editTxt3.setText("");
                break;
            case 3:
                editTxt4.setText("");
                break;
            case 4:
                editTxt5.setText("");
                break;
        }
    }
    @Override
    public void onClick(View view) {
        if(editTxtNum.getText().toString().equals(sRespuesta)) {
            Toast.makeText(this, "Correcto!!!", Toast.LENGTH_SHORT).show();
            if(sEstado.equals("Alge"))
                serieAlgebraica();
            else
                serieAritmetica();
        }
        else {
            iIntentos--;
            if(iIntentos != 0)
                Toast.makeText(this, "Mal!!! Te quedan "+iIntentos+" intentos", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this, "Mal!!! Perdiste", Toast.LENGTH_SHORT).show();
                iIntentos = 3;
                if(sEstado.equals("Alge"))
                    serieAlgebraica();
                else
                    serieAritmetica();
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i==R.id.rdBtnAlge)
        {
            serieAlgebraica();
            sEstado = "Alge";
        }
        else
        {
            serieAritmetica();
            sEstado = "Arit";
        }
    }
}
