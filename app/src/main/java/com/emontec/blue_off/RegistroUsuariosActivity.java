package com.emontec.blue_off;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.emontec.blue_off.entidades.Bodegas;
import com.emontec.blue_off.entidades.Clientes;
import com.emontec.blue_off.utilidades.Utilidades;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono;
    private ArrayList<Clientes> myDatasetCa;
    private ArrayList<Bodegas> myDatasetBo;
    int Num_DB = 3;
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoId= (EditText) findViewById(R.id.campoId);
        campoNombre= (EditText) findViewById(R.id.campoNombre);
        campoTelefono= (EditText) findViewById(R.id.campoTelefono);

        //Clientes();
        Bodegas();
    }

    public void onClick(View view) {
        registrarUsuarios();
        //registrarUsuariosSql();
    }

    private void registrarUsuariosSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (id,nombre,telefono) values (123,'Cristian','85665223')

        String insert="INSERT INTO "+ Utilidades.TABLA_USUARIO
                +" ( " +Utilidades.CAMPO_ID+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_TELEFONO+")" +
                " VALUES ("+campoId.getText().toString()+", '"+campoNombre.getText().toString()+"','"
                +campoTelefono.getText().toString()+"')";

        db.execSQL(insert);


        db.close();
    }

    private void Clientes () {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,Num_DB);
        final SQLiteDatabase db=conn.getWritableDatabase();
        final ContentValues values=new ContentValues();
        myDatasetCa = new ArrayList<Clientes>();
        String url = "https://bluelinemexico.com/ws_offline/ListaClientes.php";
        final String urlIMG = "http://bluelinemexico.com/";
        //Instanciamos un objeto RequestQueue el cual sae encarga de gestionar la cola de peticiones
        RequestQueue queue = Volley.newRequestQueue(getApplication());
        //Armamos una peticion de tipo JSONArray por que es un JsonArray lo que obtendremos como resultado
        JsonArrayRequest aRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "onResponse");
                        //Obtenemos un JSONArray como respuesta
                        if (response != null && response.length() > 0) {
                            //Iteramos son el JSONArray
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject p = (JSONObject) response.get(i);
                                    if (p != null) {
                                        //Armamos un objeto Photo con el Title y la URL de cada JSONObject
                                        Clientes photo = new Clientes();
                                        if (p.has("CardCode"))
                                            photo.setCardCode(p.getString("CardCode"));
                                        values.put(Utilidades.CAMPO_CARDCODE,p.getString("CardCode"));

                                        if (p.has("CardFName"))
                                            photo.setCardFName(p.getString("CardFName"));
                                        values.put(Utilidades.CAMPO_CARDFNAME,p.getString("CardFName"));

                                        if (p.has("CardName"))
                                            photo.setCardName(p.getString("CardName"));
                                        values.put(Utilidades.CAMPO_CARDNAME,p.getString("CardName"));

                                        if (p.has("ListNum"))
                                            photo.setListNum(p.getString("ListNum"));
                                        values.put(Utilidades.CAMPO_LISTNUM,p.getString("ListNum"));

                                        Long idResultante=db.insert(Utilidades.TABLA_CLIENTES,Utilidades.CAMPO_CARDCODE,values);
                                        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
                                        //Agreagamos el objeto Photo al Dataset
                                        myDatasetCa.add(photo);
                                        //   progreso.hide();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    //   progreso.hide();
                                } finally {
                                    //Finalmente si hemos cargado datos en el Dataset
                                    // entonces refrescamos
                                    if (myDatasetCa.size() > 0){
                                    }
                                      //  refreshDataset();
                                }
                                //mRecyclerViewCa.setVisibility(View.VISIBLE);
                                //animacion.setVisibility(View.INVISIBLE);
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse");
            }
        });
        //Agregamos la petición de tipo JSON a la cola
        queue.add(aRequest);
    }



    private void Bodegas () {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,Num_DB);
        final SQLiteDatabase db=conn.getWritableDatabase();
        final ContentValues values=new ContentValues();
        myDatasetBo = new ArrayList<Bodegas>();
        String url = "https://bluelinemexico.com/ws_offline/Bodega.php";
        final String urlIMG = "http://bluelinemexico.com/";
        //Instanciamos un objeto RequestQueue el cual sae encarga de gestionar la cola de peticiones
        RequestQueue queue = Volley.newRequestQueue(getApplication());
        //Armamos una peticion de tipo JSONArray por que es un JsonArray lo que obtendremos como resultado
        JsonArrayRequest aRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "onResponse");
                        //Obtenemos un JSONArray como respuesta
                        if (response != null && response.length() > 0) {
                            //Iteramos son el JSONArray
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject p = (JSONObject) response.get(i);
                                    if (p != null) {
                                        //Armamos un objeto Photo con el Title y la URL de cada JSONObject
                                        Bodegas photo = new Bodegas();
                                        if (p.has("Elemento"))
                                            photo.setElemento(p.getString("Elemento"));
                                        values.put(Utilidades.CAMPO_ELEMENTO,p.getString("Elemento"));

                                        if (p.has("Valor"))
                                            photo.setSeries(p.getString("Valor"));
                                        values.put(Utilidades.CAMPO_VALOR,p.getString("Valor"));

                                        if (p.has("Series"))
                                            photo.setValor(p.getString("Series"));
                                        values.put(Utilidades.CAMPO_SERIES,p.getString("Series"));


                                        Long idResultante=db.insert(Utilidades.TABLA_BODEGAS,Utilidades.CAMPO_ELEMENTO,values);
                                        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
                                        //Agreagamos el objeto Photo al Dataset
                                        myDatasetBo.add(photo);
                                        //   progreso.hide();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    //   progreso.hide();
                                } finally {
                                    //Finalmente si hemos cargado datos en el Dataset
                                    // entonces refrescamos
                                    if (myDatasetBo.size() > 0){
                                    }
                                    //  refreshDataset();
                                }
                                //mRecyclerViewCa.setVisibility(View.VISIBLE);
                                //animacion.setVisibility(View.INVISIBLE);
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse");
            }
        });
        //Agregamos la petición de tipo JSON a la cola
        queue.add(aRequest);
    }


    private void Colecciones () {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,Num_DB);
        final SQLiteDatabase db=conn.getWritableDatabase();
        final ContentValues values=new ContentValues();
        myDatasetBo = new ArrayList<Bodegas>();
        String url = "https://bluelinemexico.com/ws_offline/Bodega.php";
        final String urlIMG = "http://bluelinemexico.com/";
        //Instanciamos un objeto RequestQueue el cual sae encarga de gestionar la cola de peticiones
        RequestQueue queue = Volley.newRequestQueue(getApplication());
        //Armamos una peticion de tipo JSONArray por que es un JsonArray lo que obtendremos como resultado
        JsonArrayRequest aRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, "onResponse");
                        //Obtenemos un JSONArray como respuesta
                        if (response != null && response.length() > 0) {
                            //Iteramos son el JSONArray
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject p = (JSONObject) response.get(i);
                                    if (p != null) {
                                        //Armamos un objeto Photo con el Title y la URL de cada JSONObject
                                        Bodegas photo = new Bodegas();
                                        if (p.has("Elemento"))
                                            photo.setElemento(p.getString("Elemento"));
                                        values.put(Utilidades.CAMPO_ELEMENTO,p.getString("Elemento"));

                                        if (p.has("Valor"))
                                            photo.setSeries(p.getString("Valor"));
                                        values.put(Utilidades.CAMPO_VALOR,p.getString("Valor"));

                                        if (p.has("Series"))
                                            photo.setValor(p.getString("Series"));
                                        values.put(Utilidades.CAMPO_SERIES,p.getString("Series"));


                                        Long idResultante=db.insert(Utilidades.TABLA_BODEGAS,Utilidades.CAMPO_ELEMENTO,values);
                                        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
                                        //Agreagamos el objeto Photo al Dataset
                                        myDatasetBo.add(photo);
                                        //   progreso.hide();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    //   progreso.hide();
                                } finally {
                                    //Finalmente si hemos cargado datos en el Dataset
                                    // entonces refrescamos
                                    if (myDatasetBo.size() > 0){
                                    }
                                    //  refreshDataset();
                                }
                                //mRecyclerViewCa.setVisibility(View.VISIBLE);
                                //animacion.setVisibility(View.INVISIBLE);
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse");
            }
        });
        //Agregamos la petición de tipo JSON a la cola
        queue.add(aRequest);
    }


    private void registrarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}
