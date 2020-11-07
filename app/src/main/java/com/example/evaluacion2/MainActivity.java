package com.example.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnMinus,btnPlus,btnDivision,btnMultiplication,btnDel,btnPoint,btnBracketOpen,btnBracketClose,btnClear;
    TextView ttvIn, ttvOut;
    Button btnResolve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///Entradas y salidas
        this.ttvIn = findViewById(R.id.ttvIn);
        this.ttvOut = findViewById(R.id.ttvOut);

        //Numeros
        this.btn0 = findViewById(R.id.btn0);
        this.btn1 = findViewById(R.id.btn1);
        this.btn2 = findViewById(R.id.btn2);
        this.btn3 = findViewById(R.id.btn3);
        this.btn4 = findViewById(R.id.btn4);
        this.btn5 = findViewById(R.id.btn5);
        this.btn6 = findViewById(R.id.btn6);
        this.btn7 = findViewById(R.id.btn7);
        this.btn8 = findViewById(R.id.btn8);
        this.btn9 = findViewById(R.id.btn9);

        ///Operaciones
        this.btnPlus = findViewById(R.id.btnPlus);
        this.btnMinus = findViewById(R.id.btnMinus);
        this.btnDivision = findViewById(R.id.btnDivision);
        this.btnMultiplication = findViewById(R.id.btnMultiplication);
        this.btnDel = findViewById(R.id.btnDel);
        this.btnClear = findViewById(R.id.btnClear);
        this.btnResolve = findViewById(R.id.btnResolve);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Se cumple que sea Landscape entonces llamo a mis controles
            this.btnBracketOpen = findViewById(R.id.btnBracketOpen);
            this.btnBracketClose = findViewById(R.id.btnBracketClose);
            this.btnPoint = findViewById(R.id.btnPoint);
            btnBracketOpen.setOnClickListener(this);
            btnBracketClose.setOnClickListener(this);
            btnPoint.setOnClickListener(this);
        }

        //Numeros
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        ///Operaciones
        this.btnPlus.setOnClickListener(this);
        this.btnMinus.setOnClickListener(this);
        this.btnDivision.setOnClickListener(this);
        this.btnMultiplication.setOnClickListener(this);
        this.btnDel.setOnClickListener(this);
        this.btnClear.setOnClickListener(this);
        this.btnResolve.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            StringBuilder entrada = new StringBuilder();
             entrada.append(ttvIn.getText().toString());

             switch (view.getId()){
                 case R.id.btn0:
                     entrada.append(0);
                     break;
                 case R.id.btn9:
                     entrada.append(9);
                     break;
                 case R.id.btn1:
                     entrada.append(1);
                     break;
                 case R.id.btn2:
                     entrada.append(2);
                     break;
                 case R.id.btn3:
                     entrada.append(3);
                     break;
                 case R.id.btn4:
                     entrada.append(4);
                     break;
                 case R.id.btn5:
                     entrada.append(5);
                     break;
                 case R.id.btn6:
                     entrada.append(6);
                     break;
                 case R.id.btn7:
                     entrada.append(7);
                     break;
                 case R.id.btn8:
                     entrada.append(8);
                     break;
                     ///Operaciones
                 case R.id.btnPlus:
                     entrada.append("+");
                     break;
                 case R.id.btnMinus:
                     entrada.append("-");
                     break;
                 case R.id.btnMultiplication:
                     entrada.append("*");
                     break;
                 case R.id.btnDivision:
                     entrada.append("/");
                     break;
                 case R.id.btnDel:
                     if(entrada.length() > 0 ) {
                         entrada.deleteCharAt(entrada.length() - 1);
                     }
                     break;
                 case R.id.btnClear:
                     entrada.delete(0,entrada.length());
                     ttvOut.setText("");
                     ttvIn.setText("");
                     break;
                 case R.id.btnBracketOpen:
                     entrada.append("(");
                     break;
                 case R.id.btnBracketClose:
                     entrada.append(")");
                     break;
                 case R.id.btnPoint:
                     entrada.append(".");
                     break;
                 case R.id.btnResolve:
                     try {
                         Expression e = new ExpressionBuilder(entrada.toString()).build();
                         ttvOut.setText(String.valueOf(e.evaluate()));
                     }catch(Exception e){
                         ttvOut.setText("Error");
                     }
                     break;
             }
        ttvIn.setText(entrada.toString());
    }
}