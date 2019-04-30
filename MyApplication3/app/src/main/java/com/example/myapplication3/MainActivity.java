package com.example.myapplication3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    public static final int CONSTANTE_ACTIVITY2 = 1;
    public static final int CONSTANTE_SOBRE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG, "onCreate");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSobre:
                Intent intent = new Intent(this, Sobre.class);
                startActivityForResult(intent, CONSTANTE_SOBRE);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void enviarDados(View view){
        EditText nome = (EditText) findViewById(R.id.nome);
        EditText idade = (EditText) findViewById(R.id.idade);
        EditText endereco = (EditText) findViewById(R.id.endereco);

        Bundle params = new Bundle();
        params.putString("nome", nome.getText().toString());
        params.putString("idade", idade.getText().toString());
        params.putString("endereco", endereco.getText().toString());

        Intent intent = new Intent(this, Activity2.class);
        intent.putExtras(params);

        startActivityForResult(intent, CONSTANTE_ACTIVITY2);
    }

    protected void onActivityResult(int codigoTela, int resultCode, Intent intent){
        super.onActivityResult(codigoTela, resultCode, intent);

        if(codigoTela == CONSTANTE_ACTIVITY2){
            Bundle params = intent.getExtras();
            String msg = params.getString("msg");
            if(params != null) {
                switch (resultCode) {
                    case 1:
                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

                        EditText nome = (EditText) findViewById(R.id.nome);
                        EditText idade = (EditText) findViewById(R.id.idade);
                        EditText endereco = (EditText) findViewById(R.id.endereco);

                        nome.setText("");
                        idade.setText("");
                        endereco.setText("");
                    case 2:
                        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

                    default:
                        Toast.makeText(this, "Os dados não foram Salvos!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    protected void onResume(){
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
