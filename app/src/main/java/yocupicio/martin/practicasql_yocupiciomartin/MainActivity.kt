package yocupicio.martin.practicasql_yocupiciomartin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import yocupicio.martin.practicasql_yocupiciomartin.data.AlumnoSQLHelper
import yocupicio.martin.practicasql_yocupiciomartin.entities.Alumno

class MainActivity : AppCompatActivity() {
    private lateinit var db: AlumnoSQLHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var alumnoAdapter: AlumnoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = AlumnoSQLHelper(this)

        val etNombre = findViewById<EditText>(R.id.nombre)
        val etApPat = findViewById<EditText>(R.id.apPat)
        val etApMat = findViewById<EditText>(R.id.apMat)
        val etCarrera = findViewById<EditText>(R.id.carrera)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val listaEstudiantes = findViewById<RecyclerView>(R.id.studentsList)

        btnGuardar.setOnClickListener {

            val nombre = etNombre.text.toString().trim()
            val apPat = etApPat.text.toString().trim()
            val apMat = etApMat.text.toString().trim()
            val carrera = etCarrera.text.toString().trim()
            val alumnos = ArrayList<Alumno>()

            val alumno = Alumno(nombre, apPat, apMat, carrera)


            if (nombre.isEmpty() || apPat.isEmpty() || apMat.isEmpty() || carrera.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val alumno = Alumno(
                    nombre = nombre,
                    apPaterno = apPat,
                    apMaterno = apMat,
                    carrera = carrera
                )
                db.insertAlumno(alumno)
                Toast.makeText(this, "Alumno guardado", Toast.LENGTH_SHORT).show()
                println("Alumno guardado: $alumno")
                listaEstudiantes
            }
        }
    }
}