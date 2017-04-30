package edu.cecyt9.ipn.practica_13_hilos;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;


public class MainActivity extends Activity {
    private EditText entrada;
    private TextView salida;
    private TextView salida1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);
        salida1 = (TextView) findViewById(R.id.salida1);
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n +"! = ");
        int res = factorial(n);
        salida.append(res + "\n");

        salida1.append(n + "° posicion de fibonacci: ");
        String respuesta = fibonacci(n);
        salida1.append(respuesta + "\n");
    }

    public int factorial(int n) {
        int res=1;
        for (int i=1; i<=n; i++){
            res*=i;

        }  SystemClock.sleep(1000);

        return res;

    }

 //   public void calcularOperacion1(View view){
 //       int m = Integer.parseInt(entrada.getText().toString());
 //       salida1.append(m + "° posicion de fibonacci: ");
 //       int numero = fibonacci(m);
 //       salida1.append(numero + "\n");
 //   }

    public String fibonacci(int n){
        String respuesta = " ";
        int numero = 0;
        int res1 = 0;
        int anterior = 1;
        if(n == 0){
            numero = 0;
            respuesta = numero + ".";
        }else{
            if(n == 1 || n == 2){
                numero = 1;
                respuesta = "0, " + numero + ".";
            }else {
                respuesta = "0,1,";
                for (int i = 0; i <= n - 3; i++) {
                    numero = res1 + anterior;
                    respuesta = respuesta + numero + ",";
                    res1 = anterior;
                    anterior = numero;
                }
                SystemClock.sleep(1000);
            }
        }
          return respuesta;
    }

    class MiThread extends Thread {
        private int n, res;
        private String respuesta;

        public MiThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            res = factorial(n);
            salida.append(res + "\n");

            respuesta = fibonacci(n);
            salida1.append(respuesta + "\n");
        }

//        @Override
//        public void run() {
//            res = factorial(n);
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    salida.append(res + "\n");
//                }
//            });
//        }
    }

//    public void calcularOperacion(View view) {
//        int n = Integer.parseInt(entrada.getText().toString());
//        salida.append(n + "! = ");
//        MiThread thread = new MiThread(n);
//        thread.start();
//    }


//    ejemplo AsyncTask
//    class MiTarea extends AsyncTask<Integer, Void, Integer> {
//
//        @Override
//
//        protected Integer doInBackground(Integer... n) {
//
//            return factorial(n[0]);
//
//        }
//
//        @Override
//
//        protected void onPostExecute(Integer res) {
//
//            salida.append(res + "\n");
//
//        }
//
//    }

//        public void calcularOperacion(View view) {
//        int n = Integer.parseInt(entrada.getText().toString());
//        salida.append(n + "! = ");
//        MiTarea tarea = new MiTarea();
//        tarea.execute(n);
//
//        }

    //    ejemplo AsyncTask whit progressdialog
//    class MiTarea extends AsyncTask<Integer, Integer, Integer> {
//
//        private ProgressDialog progreso;
//
//        @Override protected void onPreExecute() {
//
//            progreso = new ProgressDialog(MainActivity.this);
//
//            progreso.setProgressStyle(ProgressDialog.
//                    STYLE_HORIZONTAL);
//
//            progreso.setMessage("Calculando...");
//
//            progreso.setCancelable(false);
//
//            progreso.setMax(100);
//
//            progreso.setProgress(0);
//
//            progreso.show();
//
//        }
//
//        @Override protected Integer doInBackground(Integer... n) {
//
//            int res = 1;
//
//            for (int i = 1; i <= n[0]; i++) {
//
//                res *= i;
//
//                SystemClock.sleep(1000);
//
//                publishProgress(i*100 / n[0]);
//
//            }
//
//            return res;
//
//        }
//
//        @Override protected void onProgressUpdate(Integer... porc) {
//
//            progreso.setProgress(porc[0]);
//
//        }
//
//        @Override protected void onPostExecute(Integer res) {
//
//            progreso.dismiss();
//
//            salida.append(res + "\n");
//
//        }
//
//    }

    //    ejemplo AsyncTask whit progressdialog cancel
//    class MiTarea extends AsyncTask<Integer, Integer, Integer> {
//
//        private ProgressDialog progreso;
//
//        @Override protected void onPreExecute() {
//
//            progreso = new ProgressDialog(MainActivity.this);
//
//            progreso.setProgressStyle(ProgressDialog.
//                    STYLE_HORIZONTAL);
//
//            progreso.setMessage("Calculando...");
//
//            progreso.setCancelable(true);
//
//            progreso.setOnCancelListener(new OnCancelListener() {
//
//                @Override
//                public void onCancel(DialogInterface dialog) {
//
//                    MiTarea.this.cancel(true);
//
//                }
//
//            });
//
//            progreso.setMax(100);
//
//            progreso.setProgress(0);
//
//            progreso.show();
//
//        }
//
//        @Override protected Integer doInBackground(Integer... n) {
//
//            int res = 1;
//
//            for (int i = 1; i <= n[0] && !isCancelled(); i++) {
//                res *= i;
//
//                SystemClock.sleep(1000);
//
//                publishProgress(i*100 / n[0]);
//
//            }
//
//            return res;
//
//        }
//
//        @Override protected void onProgressUpdate(Integer... porc) {
//
//            progreso.setProgress(porc[0]);
//
//        }
//
//        @Override protected void onPostExecute(Integer res) {
//
//            progreso.dismiss();
//
//            salida.append(res + "\n");
//
//        }
//
//        @Override protected void onCancelled() {
//
//            salida.append("cancelado\n");
//
//        }
//
//    }

}