package com.emontec.blue_off.utilidades;

/**
 * Created by CHENAO on 7/05/2017.
 */

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_TELEFONO="telefono";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_TELEFONO+" TEXT)";

    //Constantes campos tabla mascota
    public static final String TABLA_MASCOTA="mascota";
    public static final String CAMPO_ID_MASCOTA="id_mascota";
    public static final String CAMPO_NOMBRE_MASCOTA="nombre_mascota";
    public static final String CAMPO_RAZA_MASCOTA="raza_mascota";
    public static final String CAMPO_ID_DUENIO="id_duenio";

    public static final String CREAR_TABLA_MASCOTA="CREATE TABLE " +
            ""+TABLA_MASCOTA+" ("+CAMPO_ID_MASCOTA+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE_MASCOTA+" TEXT, "+CAMPO_RAZA_MASCOTA+" TEXT,"+CAMPO_ID_DUENIO+" INTEGER)";


    //Constantes campos tabla clientes
    public static final String TABLA_CLIENTES="cliente";
    public static final String CAMPO_CARDCODE="cardCode";
    public static final String CAMPO_CARDFNAME="cardFName";
    public static final String CAMPO_CARDNAME="cardName";
    public static final String CAMPO_LISTNUM="listNum";
    public static final String CAMPO_EMAIL="email";
    public static final String CAMPO_MEMO="memo";

    public static final String CREAR_TABLA_CLIENTES="CREATE TABLE " +
            ""+TABLA_CLIENTES+" ("+CAMPO_CARDCODE+" " +
            "TEXT, "+CAMPO_CARDFNAME+" TEXT,"+CAMPO_CARDNAME+" TEXT,"+CAMPO_LISTNUM+" TEXT,"+CAMPO_EMAIL+" TEXT,"+CAMPO_MEMO+" TEXT )";


    //Constantes campos tabla colecciones
    public static final String TABLA_COLECCIONES="colecciones";
    public static final String CAMPO_CATEGORY_NAME="category_name";
    public static final String CAMPO_CATEGORY_ID="virtuemart_category_id";
    public static final String CAMPO_CATEGORY_PARENT_ID="category_parent_id";
    public static final String CAMPO_MEDIA_ID="virtuemart_media_id";
    public static final String CAMPO_FILE_TITLE="file_title";
    public static final String CAMPO_FILE_URL="file_url";

    public static final String CREAR_TABLA_COLECCIONES="CREATE TABLE " +
            ""+TABLA_COLECCIONES+" ("+CAMPO_CATEGORY_NAME+" " +
            "TEXT, "+CAMPO_CATEGORY_ID+" TEXT,"+CAMPO_CATEGORY_PARENT_ID+" TEXT,"+CAMPO_MEDIA_ID+" TEXT,"+CAMPO_FILE_TITLE+" TEXT,"+CAMPO_FILE_URL+" TEXT )";

    ///// Constantes de tabla BODEGAS
    public static final String TABLA_BODEGAS="bodegas";
    public static final String CAMPO_ELEMENTO="elemento";
    public static final String CAMPO_VALOR="valor";
    public static final String CAMPO_SERIES="series";

    public static final String CREAR_TABLA_BODEGAS="CREATE TABLE " +
            ""+TABLA_BODEGAS+" ("+CAMPO_ELEMENTO+" " + "TEXT, "
            +CAMPO_VALOR+" TEXT, "+" "+CAMPO_SERIES+" TEXT)";



    ///// Constantes de tabla ListaFamilias
   /* public static final String TABLA_ListaFamilias="ListaFamilias";
    public static final String CAMPO_VIRTUEMART_CATEGORY_ID="virtuemart_category_id";
    public static final String CAMPO_CATEGORY_PARENT_ID="category_parent_id";
    public static final String CAMPO_VIRTUEMART_MEDIDA_ID="virtuemart_media_id";
    public static final String CAMPO_FILE_TITLE="file_title";
    public static final String CAMPO_CATEGORY_NAME="category_name";


    public static final String CREAR_TABLA_COLECCIONES="CREATE TABLE " +
            ""+TABLA_COLECCIONES+" ("+CAMPO_VIRTUEMART_CATEGORY_ID+" " +CAMPO_CATEGORY_PARENT_ID+ ""+CAMPO_CATEGORY_PARENT_ID+"TEX"+CAMPOCAMPO_VIRTUEMART_MEDIDA_ID_CLAVE+"TEX"
            +CAMPO_FILE_TITLE+
            "TEX"+CAMPO_CATEGORY_NAME+"TEX"+CAMPO_ORDEN+" TEXT)";
*/
}
