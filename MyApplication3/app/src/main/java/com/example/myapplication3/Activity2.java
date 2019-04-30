package com.example.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private final String TAG = "Activity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                String nome = params.getString("nome");
                String idade = params.getString("idade");
                String endereco = params.getString("endereco");

                TextView nomeTextView = (TextView) findViewById(R.id.nomeRes);
                TextView idadeTextView = (TextView) findViewById(R.id.idadeRes);
                TextView enderecoTextView = (TextView) findViewById(R.id.enderecoRes);

                nomeTextView.setText("" + nome);
                idadeTextView.setText("" + idade);
                enderecoTextView.setText("" + endereco);
            }
        }

        Log.d(TAG, "onCreate");
    }

    public void correto(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "Salvo com Sucesso!");
        setResult(1, intent);
        finish();
    }

    public void incorreto(View view){
        Intent intent = new Intent();
        intent.putExtra("msg", "Os dados não foram Salvos!");
        setResult(2, intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
