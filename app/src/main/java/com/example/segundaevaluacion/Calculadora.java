package com.example.segundaevaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.example.segundaevaluacion.MainActivity.operacion;
import static com.example.segundaevaluacion.MainActivity.resultado;
import static com.example.segundaevaluacion.MainActivity.contSuma;
import static com.example.segundaevaluacion.MainActivity.contResta;
import static com.example.segundaevaluacion.MainActivity.contMultiplicacion;
import static com.example.segundaevaluacion.MainActivity.contDivision;
import static com.example.segundaevaluacion.MainActivity.contPiz;
import static com.example.segundaevaluacion.MainActivity.contPde;
import static com.example.segundaevaluacion.MainActivity.contPunto;

public class Calculadora extends AppCompatActivity {

    TextView txvOperacion, txvResultado;
    List<Double> lstResultadosBloques;
    List<Double> lstResultadosNuevos;
    List<Integer> lstPosSumas, lstPosRes, lstPosMul, lstPosDiv;
    int ultimoParenEvaluado, sumHechas, resHechas, mulHechas, divHechas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.codigo);

        lstResultadosBloques = new ArrayList<>();
        lstResultadosNuevos = new ArrayList<>();

        lstPosSumas = new ArrayList<>();
        lstPosRes = new ArrayList<>();
        lstPosMul = new ArrayList<>();
        lstPosDiv = new ArrayList<>();

        ultimoParenEvaluado = 0;
        sumHechas = 0;
        resHechas = 0;
        mulHechas = 0;
        divHechas = 0;

        txvOperacion = findViewById(R.id.txvOperacion);
        txvResultado = findViewById(R.id.txvRespuesta);
        if(operacion.length() > 0){ txvOperacion.setText(operacion);}
        if(resultado.length() > 0){ txvResultado.setText(resultado);}
    }

    public void OnClickAc(View v){
        IgualCeroVacio();
        txvOperacion.setText(operacion);
        txvResultado.setText(resultado);
    }

    public void OnClickDel(View v){
        if(resultado.length() <= 0){
            if(operacion.length() > 0){
                String opeTmp = "";
                String caracEliminado = "";
                if(operacion.length() > 0){
                    for(int i = 0; i < (operacion.length() - 1); i++){
                        opeTmp = opeTmp + operacion.charAt(i);
                    }
                    caracEliminado = caracEliminado + operacion.charAt(operacion.length() - 1);
                    operacion = opeTmp;
                }
                RestarContadorCaracter(caracEliminado);
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickMas(View v){
        if(resultado.length() <= 0){
            if(operacion.length() > 0){
                String ultimoCarac = "";
                ultimoCarac = ultimoCarac + operacion.charAt(operacion.length() - 1);

                if(BuscarOperador(ultimoCarac)){
                    Toast.makeText(this, "No se puede poner dos operadores juntos", Toast.LENGTH_SHORT).show();
                } else{
                    operacion = operacion + "+";
                    contSuma++;
                    txvOperacion.setText(operacion);
                }
            }
        }
    }

    public void OnClickMenos(View v){
        if(resultado.length() <= 0){
            if(operacion.length() > 0){
                String ultimoCarac = "";
                ultimoCarac = ultimoCarac + operacion.charAt(operacion.length() - 1);

                if(BuscarOperador(ultimoCarac)){
                    Toast.makeText(this, "No se puede poner dos operadores juntos", Toast.LENGTH_SHORT).show();
                } else{
                    operacion = operacion + "-";
                    contResta++;
                    txvOperacion.setText(operacion);
                }
            }
        }
    }

    public void OnClickPor(View v){
        if(resultado.length() <= 0){
            if(operacion.length() > 0){
                String ultimoCarac = "";
                ultimoCarac = ultimoCarac + operacion.charAt(operacion.length() - 1);

                if(BuscarOperador(ultimoCarac)){
                    Toast.makeText(this, "No se puede poner dos operadores juntos", Toast.LENGTH_SHORT).show();
                } else{
                    operacion = operacion + "*";
                    contMultiplicacion++;
                    txvOperacion.setText(operacion);
                }
            }
        }
    }

    public void OnClickDivision(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() > 0){
                String ultimoCarac = "";
                ultimoCarac = ultimoCarac + operacion.charAt(operacion.length() - 1);

                if(BuscarOperador(ultimoCarac)){
                    Toast.makeText(this, "No se puede poner dos operadores juntos", Toast.LENGTH_SHORT).show();
                } else{
                    operacion = operacion + "/";
                    contDivision++;
                    txvOperacion.setText(operacion);
                }
            }
        }
    }

    public void OnClickCero(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "0";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "0";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickUno(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "1";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "1";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickDos(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "2";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "2";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickTres(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "3";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "3";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickCuatro(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "4";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "4";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickCinco(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "5";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "5";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickSeis(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "6";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "6";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickSiete(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "7";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "7";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickOcho(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "8";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "8";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickNueve(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "9";
                txvOperacion.setText(operacion);
            } else{
                operacion = operacion + "9";
                txvOperacion.setText(operacion);
            }
        }
    }

    public void OnClickParenIzqui(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = "(";
                txvOperacion.setText(operacion);
            } else{
                String ultimoCarac = "";
                ultimoCarac = ultimoCarac + operacion.charAt(operacion.length() - 1);

                if(ultimoCarac.equals("(")){
                } else{
                    operacion = operacion + "(";
                    txvOperacion.setText(operacion);
                }
            }
            contPiz++;
        }
    }

    public void OnClickParenDere(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() <= 0){
                operacion = ")";
                txvOperacion.setText(operacion);
            } else{
                String ultimoCarac = "";
                ultimoCarac = ultimoCarac + operacion.charAt(operacion.length() - 1);

                if(ultimoCarac.equals(")")){
                } else{
                    operacion = operacion + ")";
                    txvOperacion.setText(operacion);
                }
            }
            contPde++;
        }
    }

    public void OnClickPunto(View v){
        if(resultado.length() <= 0) {
            if(operacion.length() > 0){
                String ultimoCarac = "";
                ultimoCarac = ultimoCarac + operacion.charAt(operacion.length() - 1);

                if(ultimoCarac.equals("+") || ultimoCarac.equals("-") || ultimoCarac.equals("*") || ultimoCarac.equals("/")
                        || ultimoCarac.equals("(") || ultimoCarac.equals(")") || ultimoCarac.equals(".")){
                } else{
                    operacion = operacion + ".";
                    txvOperacion.setText(operacion);
                }
            }
        }
    }

    public void OnClickIgual(View v){
        if(contPiz > 0 && contPiz == contPde){
            BloquesOperacionales();
            if(contDivision > 0){
                OperarDosBloques(4);
                if(contMultiplicacion > 0){ OperarDosBloques(3);}
                if(contResta > 0){ OperarDosBloques(2);}
                if(contSuma > 0){ OperarDosBloques(1);}
            } else if(contMultiplicacion > 0){
                OperarDosBloques(3);
                if(contResta> 0){ OperarDosBloques(2);}
                if(contSuma > 0){ OperarDosBloques(1);}
            } else if(contResta > 0){
                OperarDosBloques(2);
                if(contSuma > 0){ OperarDosBloques(1);}
            } else if(contSuma > 0){
                OperarDosBloques(1);
            }
            resultado = Double.toString(lstResultadosBloques.get(0));
        } else if(contPiz == 0 && contPde == 0){
            BloquesOperacionales();
            if(contDivision > 0){
                OperarDosBloques(4);
                if(contMultiplicacion > 0){ OperarDosBloques(3);}
                if(contResta > 0){ OperarDosBloques(2);}
                if(contSuma > 0){ OperarDosBloques(1);}
            } else if(contMultiplicacion > 0){
                OperarDosBloques(3);
                if(contResta> 0){ OperarDosBloques(2);}
                if(contSuma > 0){ OperarDosBloques(1);}
            } else if(contResta > 0){
                OperarDosBloques(2);
                if(contSuma > 0){ OperarDosBloques(1);}
            } else if(contSuma > 0){
                OperarDosBloques(1);
            }
            resultado = Double.toString(lstResultadosBloques.get(0));
        }
        txvResultado.setText(resultado);
    }

    private void IgualCeroVacio(){
        operacion = "";
        resultado = "";
        contSuma = 0;
        contResta = 0;
        contMultiplicacion = 0;
        contDivision = 0;
        contPiz = 0;
        contPde = 0;
        contPunto = 0;
        sumHechas = 0;
        resHechas = 0;
        mulHechas = 0;
        divHechas = 0;
        ultimoParenEvaluado = 0;
        lstResultadosBloques.clear();
        lstResultadosNuevos.clear();
        lstPosSumas.clear();
        lstPosRes.clear();
        lstPosMul.clear();
        lstPosDiv.clear();
    }

    private void OperarDosBloques(int opera){
        int bloque1 = -1;
        int bloque2 = 0;
        boolean parentesis = true;

        for(int i = 0; i < operacion.length(); i++){
            String caracter = "";
            caracter = caracter + operacion.charAt(i);

            if(caracter.equals("(")){ parentesis = false;}
            if(caracter.equals(")")){ parentesis = true;}
            if(caracter.equals("+") ||  caracter.equals("-") ||caracter.equals("*") || caracter.equals("/")){
                if(parentesis){

                    if(opera == 4){     //Es división
                        if(caracter.equals("/")){
                            bloque1 = lstPosDiv.get(divHechas);
                            bloque2 = bloque1 + 1;

                            if(bloque1 >= 1){
                                for(int k = 0; k < (bloque1); k++){
                                    lstResultadosNuevos.add(lstResultadosBloques.get(k));
                                }
                            }
                            double result = lstResultadosBloques.get(bloque1) / lstResultadosBloques.get(bloque2);
                            lstResultadosNuevos.add(result);
                            if(bloque2 < lstResultadosBloques.size()){
                                for(int k = bloque2 + 1; k < lstResultadosBloques.size(); k++){
                                    lstResultadosNuevos.add(lstResultadosBloques.get(k));
                                }

                                lstResultadosBloques.clear();
                                for(int h = 0; h < lstResultadosNuevos.size(); h++){
                                    lstResultadosBloques.add(lstResultadosNuevos.get(h));
                                }
                                lstResultadosNuevos.clear();
                                ModificarListaPos(bloque2);
                                bloque2 = 0;
                            }
                            divHechas++;
                        }
                    }
                    if(opera == 3){     //Es multiplicación
                        if(caracter.equals("*")){
                            bloque1 = lstPosMul.get(mulHechas);
                            bloque2 = bloque1 + 1;

                            if(bloque1 >= 1){
                                for(int k = 0; k < (bloque1); k++){
                                    lstResultadosNuevos.add(lstResultadosBloques.get(k));
                                }
                            }
                            double result = lstResultadosBloques.get(bloque1) * lstResultadosBloques.get(bloque2);
                            lstResultadosNuevos.add(result);
                            if(bloque2 < lstResultadosBloques.size()){
                                for(int k = bloque2 + 1; k < lstResultadosBloques.size(); k++){
                                    lstResultadosNuevos.add(lstResultadosBloques.get(k));
                                }

                                lstResultadosBloques.clear();
                                for(int h = 0; h < lstResultadosNuevos.size(); h++){
                                    lstResultadosBloques.add(lstResultadosNuevos.get(h));
                                }
                                lstResultadosNuevos.clear();
                                ModificarListaPos(bloque2);
                                bloque2 = 0;
                            }
                            mulHechas++;
                        }
                    }
                    if(opera == 2){     //Es resta
                        if(caracter.equals("-")){
                            bloque1 = lstPosRes.get(resHechas);
                            bloque2 = bloque1 + 1;

                            if(bloque1 >= 1){
                                for(int k = 0; k < (bloque1); k++){
                                    lstResultadosNuevos.add(lstResultadosBloques.get(k));
                                }
                            }
                            double result = lstResultadosBloques.get(bloque1) - lstResultadosBloques.get(bloque2);
                            lstResultadosNuevos.add(result);
                            if(bloque2 < lstResultadosBloques.size()){
                                for(int k = bloque2 + 1; k < lstResultadosBloques.size(); k++){
                                    lstResultadosNuevos.add(lstResultadosBloques.get(k));
                                }

                                lstResultadosBloques.clear();
                                for(int h = 0; h < lstResultadosNuevos.size(); h++){
                                    lstResultadosBloques.add(lstResultadosNuevos.get(h));
                                }
                                lstResultadosNuevos.clear();
                                ModificarListaPos(bloque2);
                                bloque2 = 0;
                            }
                            resHechas++;
                        }
                    }
                    if(opera == 1){     //Es suma
                        if(caracter.equals("+")){
                            bloque1 = lstPosSumas.get(sumHechas);
                            bloque2 = bloque1 + 1;

                            if(bloque1 >= 1){
                                for(int k = 0; k < (bloque1); k++){
                                    lstResultadosNuevos.add(lstResultadosBloques.get(k));
                                }
                            }
                            double result = lstResultadosBloques.get(bloque1) + lstResultadosBloques.get(bloque2);
                            lstResultadosNuevos.add(result);
                            if(bloque2 < lstResultadosBloques.size()){
                                for(int k = bloque2 + 1; k < lstResultadosBloques.size(); k++){
                                    lstResultadosNuevos.add(lstResultadosBloques.get(k));
                                }

                                lstResultadosBloques.clear();
                                for(int h = 0; h < lstResultadosNuevos.size(); h++){
                                    lstResultadosBloques.add(lstResultadosNuevos.get(h));
                                }
                                lstResultadosNuevos.clear();
                                ModificarListaPos(bloque2);
                                bloque2 = 0;
                            }
                            sumHechas++;
                        }
                    }
                }
            }
        }
    }

    private void ResuelveParentesis(int iniEvaluacion){
        int posPiz = 0;
        int posPde = 0;
        int limite = 0;
        double n1;
        double n2;
        int tipoOperacion = 0;
        String priNum = "";
        String SegNum = "";
        double resultadoParen = 0;
        boolean encontrado = false;

        for(int i = iniEvaluacion; i < operacion.length(); i++){
            String caracter = "";
            caracter = caracter + operacion.charAt(i);
            if(caracter.equals("(") && posPiz == 0 && !encontrado){
                posPiz = i;
                encontrado = true;
            }
        }

        for(int i = iniEvaluacion; i < operacion.length(); i++){
            String caracter2 = "";
            caracter2 = caracter2 + operacion.charAt(i);
            if(caracter2.equals(")") && posPde == 0){
                posPde = i;
            }
        }

        int tamParentesis = (posPde - posPiz) - 1;
        char cadenaTmp[] = new char[tamParentesis];
        operacion.getChars((posPiz + 1), posPde, cadenaTmp, 0);
        String cadenaEvaluar = new String(cadenaTmp);

        for(int i = 0; i < cadenaEvaluar.length(); i++){
            String signo = "";
            signo = signo + cadenaEvaluar.charAt(i);
            if(signo.equals("+") || signo.equals("-") || signo.equals("*") || signo.equals("/")){
                limite = i;
                if(signo.equals("+")){ tipoOperacion = 1; }
                if(signo.equals("-")){ tipoOperacion = 2; }
                if(signo.equals("*")){ tipoOperacion = 3; }
                if(signo.equals("/")){ tipoOperacion = 4; }
            }
        }

        for(int i = 0; i < limite; i++){
            priNum = priNum + cadenaEvaluar.charAt(i);
        }
        n1 = Double.parseDouble(priNum);

        for(int i = (limite + 1); i < cadenaEvaluar.length(); i++){
            SegNum = SegNum + cadenaEvaluar.charAt(i);
        }
        n2 = Double.parseDouble(SegNum);


        if(tipoOperacion == 1){
            resultadoParen = n1 + n2;
        }
        if(tipoOperacion == 2){
            resultadoParen = n1 - n2;
        }
        if(tipoOperacion == 3){
            resultadoParen = n1 * n2;
        }
        if(tipoOperacion == 4){
            resultadoParen = n1 / n2;
        }

        lstResultadosBloques.add(resultadoParen);
    }

    private void BloquesOperacionales(){
        int posN1 = 0;
        int posN2 = 0;
        boolean permitir = true;

        for(int i = 0; i < operacion.length(); i++){
            String caracter = "";
            caracter = caracter + operacion.charAt(i);

            if(i == operacion.length() - 1){
                if(caracter.equals(")")){
                    permitir = false;
                }
                if(permitir){
                    String carac = "";
                    carac = carac + operacion.charAt(i - 1);
                    if(carac.equals(")")){
                    } else{
                        posN2 = operacion.length();

                        int tamBloque = posN2 - posN1;
                        char cadenaTmp[] = new char[tamBloque];
                        operacion.getChars(posN1, posN2, cadenaTmp, 0);
                        String bloque = new String(cadenaTmp);
                        lstResultadosBloques.add(Double.parseDouble(bloque));
                        posN1 = posN2 + 1;
                        posN2 = 0;
                    }
                }
            } else{
                if(caracter.equals("(")){
                    ultimoParenEvaluado = i;
                    ResuelveParentesis(ultimoParenEvaluado);
                    permitir = false;
                }
                if(caracter.equals(")")){
                    permitir = true;
                }
                if(caracter.equals("+") ||  caracter.equals("-") ||caracter.equals("*") || caracter.equals("/")){
                    if(permitir){
                        String carac = "";
                        carac = carac + operacion.charAt(i - 1);
                        if(carac.equals(")")){
                            if(caracter.equals("+")){
                                lstPosSumas.add(lstResultadosBloques.size() - 1);
                            } else if(caracter.equals("-")){
                                lstPosRes.add(lstResultadosBloques.size() - 1);
                            } else if(caracter.equals("*")){
                                lstPosMul.add(lstResultadosBloques.size() - 1);
                            } else if(caracter.equals("/")){
                                lstPosDiv.add(lstResultadosBloques.size() - 1);
                            }
                            posN1 = i + 1;
                        } else {
                            if(caracter.equals("+")){
                                posN2 = i;

                                int tamBloque = posN2 - posN1;
                                char cadenaTmp[] = new char[tamBloque];
                                operacion.getChars(posN1, posN2, cadenaTmp, 0);
                                String bloque = new String(cadenaTmp);
                                lstResultadosBloques.add(Double.parseDouble(bloque));
                                lstPosSumas.add(lstResultadosBloques.size() - 1);
                                posN1 = posN2 + 1;
                                posN2 = 0;
                            } else if(caracter.equals("-")){
                                posN2 = i;

                                int tamBloque = posN2 - posN1;
                                char cadenaTmp[] = new char[tamBloque];
                                operacion.getChars(posN1, posN2, cadenaTmp, 0);
                                String bloque = new String(cadenaTmp);
                                lstResultadosBloques.add(Double.parseDouble(bloque));
                                lstPosRes.add(lstResultadosBloques.size() - 1);
                                posN1 = posN2 + 1;
                                posN2 = 0;
                            } else if(caracter.equals("*")){
                                posN2 = i;

                                int tamBloque = posN2 - posN1;
                                char cadenaTmp[] = new char[tamBloque];
                                operacion.getChars(posN1, posN2, cadenaTmp, 0);
                                String bloque = new String(cadenaTmp);
                                lstResultadosBloques.add(Double.parseDouble(bloque));
                                lstPosMul.add(lstResultadosBloques.size() - 1);
                                posN1 = posN2 + 1;
                                posN2 = 0;
                            } else if(caracter.equals("/")){
                                posN2 = i;

                                int tamBloque = posN2 - posN1;
                                char cadenaTmp[] = new char[tamBloque];
                                operacion.getChars(posN1, posN2, cadenaTmp, 0);
                                String bloque = new String(cadenaTmp);
                                lstResultadosBloques.add(Double.parseDouble(bloque));
                                lstPosDiv.add(lstResultadosBloques.size() - 1);
                                posN1 = posN2 + 1;
                                posN2 = 0;
                            }
                        }
                    }
                }
            }

        }
    }

    private void ModificarListaPos(int bloque2){
        boolean enconDiv = false;
        boolean enconMul = false;
        boolean enconRes = false;
        boolean enconSum = false;
        int posDiv = 0;
        int posMul = 0;
        int posRes = 0;
        int posSum = 0;

        ArrayList<Integer> lstTpm = new ArrayList<>();

        //------------------------- Búsqueda -----------------------
        for(int a = 0; a < lstPosDiv.size(); a++){
            if(bloque2 <= lstPosDiv.get(a) && !enconDiv){
                enconDiv = true;
                posDiv = a;
            }
        }

        for(int a = 0; a < lstPosMul.size(); a++){
            if(bloque2 <= lstPosMul.get(a) && !enconMul){
                enconMul = true;
                posMul = a;
            }
        }

        for(int a = 0; a < lstPosRes.size(); a++){
            if(bloque2 <= lstPosRes.get(a) && !enconRes){
                enconRes = true;
                posRes = a;
            }
        }

        for(int a = 0; a < lstPosSumas.size(); a++){
            if(bloque2 <= lstPosSumas.get(a) && !enconSum){
                enconSum = true;
                posSum = a;
            }
        }
        //------------------------- Búsqueda -----------------------

        //------------------------- Modificación -----------------------
        if(enconDiv){
            for(int a = 0; a < lstPosDiv.size(); a++){
                if(posDiv <= a){
                    lstTpm.add(lstPosDiv.get(a) - 1);
                } else{
                    lstTpm.add(lstPosDiv.get(a));
                }
            }
            lstPosDiv.clear();
            for(int b = 0; b < lstTpm.size(); b++){
                lstPosDiv.add(lstTpm.get(b));
            }
            lstTpm.clear();
        }

        if(enconMul){
            for(int a = 0; a < lstPosMul.size(); a++){
                if(posMul <= a){
                    lstTpm.add(lstPosMul.get(a) - 1);
                } else{
                    lstTpm.add(lstPosMul.get(a));
                }
            }
            lstPosMul.clear();
            for(int b = 0; b < lstTpm.size(); b++){
                lstPosMul.add(lstTpm.get(b));
            }
            lstTpm.clear();
        }

        if(enconRes){
            for(int a = 0; a < lstPosRes.size(); a++){
                if(posRes <= a){
                    lstTpm.add(lstPosRes.get(a) - 1);
                } else{
                    lstTpm.add(lstPosRes.get(a));
                }
            }
            lstPosRes.clear();
            for(int b = 0; b < lstTpm.size(); b++){
                lstPosRes.add(lstTpm.get(b));
            }
            lstTpm.clear();
        }

        if(enconSum){
            for(int a = 0; a < lstPosSumas.size(); a++){
                if(posSum <= a){
                    lstTpm.add(lstPosSumas.get(a) - 1);
                } else{
                    lstTpm.add(lstPosSumas.get(a));
                }
            }
            lstPosSumas.clear();
            for(int b = 0; b < lstTpm.size(); b++){
                lstPosSumas.add(lstTpm.get(b));
            }
            lstTpm.clear();
        }
        //------------------------- Modificación -----------------------
    }

    private void RestarContadorCaracter(String caracEliminado){
        if(caracEliminado.equals("+")){ contSuma--;}
        if(caracEliminado.equals("-")){ contResta--;}
        if(caracEliminado.equals("*")){ contMultiplicacion--;}
        if(caracEliminado.equals("/")){ contDivision--;}
        if(caracEliminado.equals("(")){ contPiz--;}
        if(caracEliminado.equals(")")){ contPde--;}
        if(caracEliminado.equals(".")){ contPunto--;}
    }

    private boolean BuscarOperador(String ultimoCaracter){
        boolean encontrado = false;
        if(ultimoCaracter.equals("+")){ encontrado = true;}
        if(ultimoCaracter.equals("-")){ encontrado = true;}
        if(ultimoCaracter.equals("*")){ encontrado = true;}
        if(ultimoCaracter.equals("/")){ encontrado = true;}
        if(ultimoCaracter.equals(".")){ encontrado = true;}
        return encontrado;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                onBackPressed();
            }break;
        }
        return super.onOptionsItemSelected(item);
    }
}
