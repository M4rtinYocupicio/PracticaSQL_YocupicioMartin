package yocupicio.martin.practicasql_yocupiciomartin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yocupicio.martin.practicasql_yocupiciomartin.entities.Alumno

class AlumnosAdapter(private var alumnos: List<Alumno>, context: Context): RecyclerView.Adapter<AlumnosAdapter.AlumnosViewHolder>() {

    class AlumnosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nombretv = itemView.findViewById<TextView>(R.id.tvName)
        val carreratv = itemView.findViewById<TextView>(R.id.tvCareer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alumno, parent, false)
        return AlumnosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return alumnos.size
    }

    override fun onBindViewHolder(holder: AlumnosViewHolder, position: Int) {
        val alumno = alumnos[position]
        holder.nombretv.text = "${alumno.nombre} ${alumno.apPaterno} ${alumno.apMaterno}"
        holder.carreratv.text = "${alumno.carrera}"
    }






}