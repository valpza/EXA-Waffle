package com.example.uziel.eva1_examen_practico_problema_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity  implements RadioGroup.OnCheckedChangeListener,EditText.OnEditorActionListener{

    EditText editTxtRadio,editTxtGrados;
    RadioGroup rdGrpCalculo;
    TextView txtResultado,txtTipoDato,txtGrados;
    Button btnCalcular,btnCerrar;
    Button btnCalcular1;
    BtnCalcular click;
    BtnCerrar clickCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxtRadio = findViewById(R.id.editTxtRadio);
        editTxtGrados = findViewById(R.id.editTxtGrados);
        rdGrpCalculo = findViewById(R.id.rdGrpCalculo);
        txtResultado = findViewById(R.id.txtResultado);
        txtTipoDato = findViewById(R.id.txtTipoDatos);
        txtGrados = findViewById(R.id.txtGrados);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCerrar = findViewById(R.id.btnCerrar);

        click = new BtnCalcular();
        clickCerrar = new BtnCerrar();
        btnCerrar.setOnClickListener(clickCerrar);
        click.sCal = "vol";
        click.resultado = txtResultado;
        btnCalcular.setOnClickListener(click);
        rdGrpCalculo.setOnCheckedChangeListener(this);
        editTxtRadio.setOnEditorActionListener(this);
        editTxtGrados.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                click.grados = Integer.parseInt(editTxtGrados.getText().toString());
                click.Radio = Integer.parseInt(editTxtRadio.getText().toString());
                return false;
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case(R.id.rdBtnVolumen):
                txtTipoDato.setText("m3");
                editTxtGrados.setEnabled(false);
                txtGrados.setEnabled(false);
                click.sCal = "vol";
                break;
            case(R.id.rdBtnArea):
                txtTipoDato.setText("m2");
                editTxtGrados.setEnabled(false);
                txtGrados.setEnabled(false);
                click.sCal = "ar";
                break;
            case(R.id.rdBtnVolumenCu):
                txtTipoDato.setText("m3");
                editTxtGrados.setEnabled(true);
                txtGrados.setEnabled(true);
                click.sCal = "volCu";
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        click.Radio = Integer.parseInt(editTxtRadio.getText().toString());
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editTxtRadio.getWindowToken(), 0);
        return false;
    }
}
