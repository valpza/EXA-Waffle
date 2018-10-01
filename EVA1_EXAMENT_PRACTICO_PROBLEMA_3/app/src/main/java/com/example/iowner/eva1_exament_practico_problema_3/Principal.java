package com.example.iowner.eva1_exament_practico_problema_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,Button.OnClickListener{

    TextView txtPalabra,txtLetras,txtIntentos;
    Button btnOk,btnNewGame;
    EditText editTxtLetra;
    RadioGroup rdGrpNivel;
    CheckBox chkBoxX;
    String sPalabra;
    boolean xtream = false;
    int iIntentos = 6;
    String sNivel = "facil";
    String[] sPalabras = {"android","java","service","activity","broadcast receiver","development",
                                "mobile","content provider","rest","aplicaciones"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //VINCULAMOS WIDGETS
        txtPalabra = findViewById(R.id.txtPalabra);
        txtLetras = findViewById(R.id.txtLetrasR);
        txtIntentos = findViewById(R.id.txtIntentos);
        btnOk = findViewById(R.id.btnOk);
        btnNewGame = findViewById(R.id.btnNewGame);
        editTxtLetra = findViewById(R.id.editTxtLetra);
        rdGrpNivel = findViewById(R.id.btnGrpNivel);
        chkBoxX = findViewById(R.id.chkBoxX);
        //ASIGNAMOS LISTENERS
        btnOk.setOnClickListener(this);
        rdGrpNivel.setOnCheckedChangeListener(this);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//BOTON DE NUEVO JUEGO
                cambioPalabra();
                switch (sNivel){//CHECAMOS NIVEL
                    case "dificil":
                        txtIntentos.setText("Intentos Restantes: 2");
                        break;
                    case "medio":
                        txtIntentos.setText("Intentos Restantes: 4");
                        break;
                    case "facil":
                        txtIntentos.setText("Intentos Restantes: 6");
                        break;
                }

            }
        });
        chkBoxX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//METODO DE CHECBOC
                if(chkBoxX.isChecked())
                    xtream = true;
                else
                    xtream = false;
            }
        });
        cambioPalabra();

    }

    @Override
    public void onClick(View view) {//METODO DEL BOTON OK
        char letra = editTxtLetra.getText().toString().charAt(0);//TOMAMOS LETRA DEL EDIT TEXT
        if(editTxtLetra.getText().toString().length()==1){//SI INGRESA UNA LETRA
            if(checarLetra(letra))//SI SE ENCUENTRA LA LETRA
            {
                Toast.makeText(this, "Bien!!!", Toast.LENGTH_SHORT).show();
                if(sPalabra.equals(txtPalabra.getText().toString()))//SI YA ESTA COMPLETA LA LETRA
                {
                    Toast.makeText(this, "GANASTE!!!", Toast.LENGTH_SHORT).show();
                    cambioPalabra();//NUEVA PARTIDO
                }
            }
            else//.SI NO ESTA LA LETRA
            {
                Toast.makeText(this, "MAL!!!", Toast.LENGTH_SHORT).show();
                iIntentos--;//QUITAMOS UN INTENTO
                txtIntentos.setText("Intentos Restantes "+iIntentos);
                if(iIntentos==0)//COMPARAMOS INTENTO
                {
                    Toast.makeText(this, "PERDISTE!!!!!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "JUEGO NUEVO", Toast.LENGTH_SHORT).show();
                    cambioPalabra();//NUEVO JUEGO
                }
            }
        }
        else {//SI INGRESA MAS DE 1 LETRA
            if(editTxtLetra.getText().toString().equals(sPalabra))
            {
                Toast.makeText(this, "GANASTE!!!", Toast.LENGTH_SHORT).show();
                cambioPalabra();
            }
            else{
                Toast.makeText(this, "PERDISTE!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {//ESCUCHADOR DEL LOS RADIOS

        switch(i){
            case R.id.rdBtnDificil:
                iIntentos = 2;
                txtIntentos.setText("Intentos Restantes: 2");//MODIFICAMOS INTENTOS
                cambioPalabra();//NUEVA PARTIDA
                sNivel = "dificil";
                break;
            case R.id.rdBtnMedio:
                iIntentos = 4;
                txtIntentos.setText("Intentos Restantes: 4");
                cambioPalabra();
                sNivel = "medio";
                break;
            case R.id.rdBtnFacil:
                iIntentos = 6;
                txtIntentos.setText("Intentos Restantes: 6");
                cambioPalabra();
                sNivel = "facil";
                break;
        }
    }
    public void cambioPalabra(){
        int num = (int)(Math.random()*10);//NUMERO ALEATORIO PARA ELEGIR PALABRA
        String guiones = "";//STRING PARA LOS GUIONES
        sPalabra = sPalabras[num];//SELECCIONAMOS PALABRA DEL ARREGLO
        for(int i = 0; i<sPalabra.length();i++)
        {
            guiones += "_";//LLENAMOS CON GUIONES
        }
        txtPalabra.setText(guiones);//MOSTRAMOS EN PANTALLA
        txtLetras.setText("Cantidad de letras: "+sPalabra.length());//CANTIDAD DE LETRAS
        if(sNivel.equals("dificil")){//MODIFICAMOS INTENTOS
            iIntentos = 2;
            txtIntentos.setText("Intentos Restantes "+iIntentos);
        }else
        {
            if(sNivel.equals("medio")){
                iIntentos = 4;
                txtIntentos.setText("Intentos Restantes "+iIntentos);
            }else{
                iIntentos = 6;
                txtIntentos.setText("Intentos Restantes "+iIntentos);
            }
        }
    }
    public boolean checarLetra(char letra){//METODO PARA COMPARAR LA LETRA INGRESADA CON LA PALABRA
        boolean intento = false;
        String sJuego = txtPalabra.getText().toString();
        for(int i = 0;i<sPalabra.length();i++){//CICLO QUE RECORRE LA PALABRA
            if(letra==sPalabra.charAt(i)){//SI COINCIDE
                intento = true;
                if(i==sPalabra.length()-1)//SI ES LETRA DEL FINAL
                {
                    sJuego=sJuego.substring(0,i)+letra;//INTERCAMBIAMOS LETRAS
                }
                else{//SI NO
                    sJuego=sJuego.substring(0,i)+letra+sJuego.substring(i+1);//INTERCAMBIAMOS LETRAS
                }
            }

        }
        txtPalabra.setText(sJuego);
        return intento;
    }
}
