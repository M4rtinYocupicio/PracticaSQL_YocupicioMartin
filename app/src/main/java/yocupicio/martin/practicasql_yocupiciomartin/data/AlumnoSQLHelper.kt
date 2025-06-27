package yocupicio.martin.practicasql_yocupiciomartin.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import yocupicio.martin.practicasql_yocupiciomartin.entities.Alumno

class AlumnoSQLHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME="alumnos.db"
        private const val DATABASE_VERSION= 1
        private const val TABLE_NAME="alumnos"
        private const val COLUMN_ID="_id"
        private const val COLUMN_NOMBRE="nombre"
        private const val COLUMN_PRIMER_APELLIDO="primer_apellido"
        private const val COLUMN_SEGUNDO_APELLIDO="segundo_apellido"
        private const val COLUMN_CARRERA="carrera"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableAlumnos = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NOMBRE TEXT,"+
                "$COLUMN_PRIMER_APELLIDO TEXT, "+
                "$COLUMN_SEGUNDO_APELLIDO TEXT, "+
                "$COLUMN_CARRERA TEXT"+
                ")"
        db?.execSQL(createTableAlumnos)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableAlumnos = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableAlumnos)
        onCreate(db)
    }

    fun insertAlumno(alumno: Alumno){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE, alumno.nombre)
            put(COLUMN_PRIMER_APELLIDO, alumno.apPaterno)
            put(COLUMN_SEGUNDO_APELLIDO, alumno.apMaterno)
            put(COLUMN_CARRERA, alumno.carrera)
        }

        db.insert(TABLE_NAME, null, values)
        db.close()
    }
}