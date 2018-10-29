package com.example.mi_fancyshowcaseview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void defaultSnackBar(View v){

        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinatorLayout);

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "SnackBar Básico", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void actionCallSnackBar(View v){

        final CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinatorLayout);

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Mensaje eliminado", Snackbar.LENGTH_LONG);
        snackbar.setAction( "Deshacer", new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Snackbar snackbarAuxiliar = Snackbar.make(coordinatorLayout, "Mensaje restablecido!", Snackbar.LENGTH_SHORT);
                snackbarAuxiliar.show();
            }
        });
        snackbar.show();
    }

    public void customSnackBar(View v){

        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinatorLayout);

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "Intèntalo de nuevo!", Snackbar.LENGTH_LONG);

        // Asignamos una acción
        snackbar.setAction("Reintentar", new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Acciones a realizar si se clica en Reintentar
            }
        });

        // Modificamos el color de la acción
        snackbar.setActionTextColor(Color.RED);

        // Obtenemos el texto del snackbar para modificar su color.
        View snackbarView = snackbar.getView();
        TextView textView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);

        snackbar.show();
    }

    public void lanzaShowCaseView(View view){

        View botonBasico      = findViewById(R.id.button_default);
        View botonActionCall  = findViewById(R.id.button_actionCall);
        View botonCustom      = findViewById(R.id.button_custom);
        View botonShowCase    = findViewById(R.id.button_showcase);

        Animation animation = new AlphaAnimation(0.0f,1.0f);
        animation.setDuration(250);

        final FancyShowCaseView fancyShowCaseWelcome = new FancyShowCaseView.Builder(this)
                .title("Con esta guía tendrás una explicación rápida de los diferentes botones " +
                        "de la aplicación.")
                .titleStyle(R.style.showcaseText, Gravity.CENTER)
                .backgroundColor(R.color.showCaseBackground)
                .build();

        final FancyShowCaseView fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                .title("Con este tipo de SnackBar podrás mostrar un mensaje básico " +
                        "y sin personalización.")
                .titleStyle(R.style.showcaseText, Gravity.CENTER | Gravity.BOTTOM)
                .backgroundColor(R.color.showCaseBackground)
                .focusBorderColor(Color.BLUE)
                .focusBorderSize(5)
                .focusOn(botonBasico)
                .build();

        final FancyShowCaseView fancyShowCaseView2 = new FancyShowCaseView.Builder(this)
                .title("Con este SnackBar se añade un TextButton con el que el " +
                        "usuario podrá interaccionar.")
                .titleStyle(R.style.showcaseText, Gravity.CENTER | Gravity.BOTTOM)
                .backgroundColor(R.color.showCaseBackground)
                .focusCircleRadiusFactor(1.5)
                .focusOn(botonActionCall)
                .build();

        final FancyShowCaseView fancyShowCaseView3 = new FancyShowCaseView.Builder(this)
                .title("Con este SnackBar podrás personalizar el mensaje mostrado.")
                .titleStyle(R.style.showcaseText, Gravity.CENTER | Gravity.TOP)
                .backgroundColor(R.color.showCaseBackground)
                .focusOn(botonCustom)
                .build();

        final FancyShowCaseView fancyShowCaseExit = new FancyShowCaseView.Builder(this)
                .title("Con este ejercicio has aprendido a utilizar la librería FancyShowCaseView!")
                .titleStyle(R.style.showcaseText, Gravity.CENTER)
                .backgroundColor(R.color.showCaseBackground)
                .focusOn(botonShowCase)
                .build();

        FancyShowCaseQueue mQueue = new FancyShowCaseQueue()
                .add(fancyShowCaseWelcome)
                .add(fancyShowCaseView1)
                .add(fancyShowCaseView2)
                .add(fancyShowCaseView3)
                .add(fancyShowCaseExit);
        mQueue.show();

    }

}
