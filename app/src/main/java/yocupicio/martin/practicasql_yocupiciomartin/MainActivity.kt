package yocupicio.martin.practicasql_yocupiciomartin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los EditText
        val etNombre = findViewById<EditText>(R.id.nombre)
        val etApPat = findViewById<EditText>(R.id.apPat)
        val etApMat = findViewById<EditText>(R.id.apMat)
        val etCarrera = findViewById<EditText>(R.id.carrera)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            val alumno = Alumno(
                nombre = etNombre.text.toString(),
                apPaterno = etApPat.text.toString(),
                apMaterno = etApMat.text.toString(),
                carrera = etCarrera.text.toString()
            )

            println("Alumno guardado: $alumno")
        }
    }
}