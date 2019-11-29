package com.example.kcapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kcapp1.utilidades.Utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText Id, nom, fono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        Id = (EditText) findViewById(R.id.campoid);
        nom = (EditText) findViewById(R.id.camponombre);
        fono = (EditText) findViewById(R.id.campofono);
    }

    public void onClick(View view){
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, Id.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, nom.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, fono.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);

        Toast.makeText(getApplicationContext(), "Id registrado: "+idResultante, Toast.LENGTH_SHORT).show();
    }
}
