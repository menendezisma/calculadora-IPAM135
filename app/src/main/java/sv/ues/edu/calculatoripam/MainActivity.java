package sv.ues.edu.calculatoripam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText tvResul;
    String num, numIngresado;
    String operacion="+";
    boolean cambio=true;
    String num1="";
    double resultado=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResul=findViewById(R.id.tvResul);
    }

    public void editNumber(View view) {
        if(cambio){
            tvResul.setText("");
        }
        cambio=false;
        num=tvResul.getText().toString();
        switch (view.getId()){
            case R.id.btn1:
                num = num+"1";
                break;
            case R.id.btn2:
                num = num+"2";
                break;
            case R.id.btn3:
                num = num+"3";
                break;
            case R.id.btn4:
                num = num+"4";
                break;
            case R.id.btn5:
                num = num+"5";
                break;
            case R.id.btn6:
                num = num+"6";
                break;
            case R.id.btn7:
                num = num+"7";
                break;
            case R.id.btn8:
                num = num+"8";
                break;
            case R.id.btn9:
                num = num+"9";
                break;
            case R.id.btn0:
                num = num+"0";
                break;
            case R.id.btnPunto:
                num = num+".";
                break;
            case R.id.btnMenos:
                num = "-"+num;
                break;
        }
        tvResul.setText(num);
    }
    public void eventOperar(View view){
        cambio=true;
        num1=tvResul.getText().toString();
        switch (view.getId()){
            case R.id.btnDiv:
                operacion="/";
                break;
            case R.id.btnSuma:
                operacion="+";
                break;
            case R.id.btnResta:
                operacion="-";
                break;
            case R.id.btnMulti:
                operacion="x";
                break;
        }
    }

    public void eventIgual(View view) {
        numIngresado=tvResul.getText().toString();
        double numero1=Double.parseDouble(num1);
        double numero2=Double.parseDouble(numIngresado);
        switch (operacion){
            case "+":
                resultado=numero1+numero2;
                tvResul.setText(resultado+"");
                break;
            case "-":
                resultado=numero1-numero2;
                tvResul.setText(resultado+"");
                break;
            case "x":
                resultado=numero1*numero2;
                tvResul.setText(resultado+"");
                break;
            case "/":
                if(numero2==0){
                    tvResul.setText("INVALID");
                }else{
                    resultado=numero1/numero2;
                    tvResul.setText(resultado+"");
                }
                break;
        }
        //tvResul.setText(resultado+"");
    }

    public void resetear(View view) {
        tvResul.setText("0");
        numIngresado="";
        numIngresado="";
        operacion="";
        cambio=true;
    }

    public void porcentaje(View view) {
       double numPorcentaje=Double.parseDouble(tvResul.getText().toString())/100;
       tvResul.setText(numPorcentaje+"");
       cambio=true;
    }

    public void borraNum(View view) {
        String process=tvResul.getText().toString();
        if(process.length()>=1){
            process=process.substring(0, process.length()-1);
            tvResul.setText(process);
        }else if(process.length()<1){
            tvResul.setText("");
        }
    }
}