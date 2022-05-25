package com.example.toyota;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Cotizacion cotizacion = new Cotizacion();

    private Button btnGenerar, btnCerrar;
    private TextView lblCotizacion, lblNum, lblDescripcion, lblPrecio, lblPorcentajePago,lblPlazo,
                     lblPagoInicial, lblTotalFinanciar, lblPagoMensual;
    private EditText txtNum, txtDescripcion, txtPrecio, txtPorcentajePago, txtPlazo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCerrar = (Button) findViewById(R.id.btnCerrar);
        btnGenerar = (Button) findViewById(R.id.btnGenerar);
        lblCotizacion = (TextView) findViewById(R.id.lblCotizacion);
        lblNum = (TextView) findViewById(R.id.lblNum);
        lblDescripcion = (TextView) findViewById(R.id.lblDescripcion);
        lblPrecio = (TextView) findViewById(R.id.lblPrecio);
        lblPorcentajePago = (TextView) findViewById(R.id.lblPorcentajePago);
        lblPlazo = (TextView) findViewById(R.id.lblPlazo);
        lblPagoInicial = (TextView) findViewById(R.id.lblPagoInicial);
        lblTotalFinanciar = (TextView) findViewById(R.id.lblTotalFinanciar);
        lblPagoMensual = (TextView) findViewById(R.id.lblPagoMensual);

        txtNum = (EditText) findViewById(R.id.txtNum);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtPorcentajePago = (EditText) findViewById(R.id.txtPorcentajePago);
        txtPlazo = (EditText) findViewById(R.id.txtPlazo);

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNum.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar el Num Cotizacion",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtDescripcion.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar la descripcion",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtPrecio.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar el precio",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtPorcentajePago.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar el porcentaje de pago",
                            Toast.LENGTH_SHORT).show();
                }
                if(txtPlazo.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar el plazo",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    lblCotizacion.setText("Cotización");
                    String txtNumero = txtNum.getText().toString();
                    lblNum.setText("No. cotización: " + txtNumero);
                    String txtDescrip = txtDescripcion.getText().toString();
                    lblDescripcion.setText("Descripción: " + txtDescrip);
                    //Precio
                    int txtCosto = Integer.parseInt(txtPrecio.getText().toString());
                    lblPrecio.setText("Precio: " + txtCosto);
                    //Porcentaje de pago inicial
                    int txtPorcen = Integer.parseInt(txtPorcentajePago.getText().toString());
                    lblPorcentajePago.setText("Porcentaje pago inicial: " + txtPorcen + "%");
                    //Plazo
                    String txtPla = txtPlazo.getText().toString();
                    lblPlazo.setText("Plazo: " + txtPla + " meses");
                    int txtPlazoPago = Integer.parseInt(txtPlazo.getText().toString());

                    //Parametros
                    cotizacion.setPrecio(txtCosto);
                    cotizacion.setPorPagoInicial(txtPorcen);
                    cotizacion.setPlazo(txtPlazoPago);

                    //Calculos mediante la clase de "Cotizacion.java"
                    lblPagoInicial.setText("Pago inicial: " + cotizacion.calcularPagoInicial());
                    lblTotalFinanciar.setText("Total a financiar: " + cotizacion.calcularTotalFinanciar());
                    lblPagoMensual.setText("Pago mensual: " + cotizacion.calcularPagoMensual());
                }
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder confirmar = new AlertDialog.Builder(MainActivity.this);
                confirmar.setTitle("¿Cerrar app?");
                confirmar.setMessage("Se descartara toda la informacion");
                confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Nariz
                    }
                });
                confirmar.show();
            }
        });
    }
}
