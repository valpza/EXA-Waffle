package com.example.uziel.eva1_examen_practico_problema_1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BtnCalcular implements View.OnClickListener {
    String sCal,sResultado;
    TextView resultado;
    int Radio,grados;
    @Override
    public void onClick(View v) {
        double res;
        if(sCal.equals("vol")){
            res=(4*3.14159*(Radio*Radio*Radio))/3;
        }else{
            if(sCal.equals("ar")){
                res=4*3.14159*Radio*Radio;
            }else{
                res=(4/3)*((3.14159*(Radio*Radio*Radio))/360)*grados;
            }
        }
        res = (double)Math.round(res * 100d) / 100d;
        sResultado = res+"";
        resultado.setText(sResultado);
    }
}
