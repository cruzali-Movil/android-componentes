package dev.encuestas

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView

class Inicio : AppCompatActivity() {

    // Inicializacion Variables
    private lateinit var textView: TextView
    private lateinit var arrayList:ArrayList<String>
    private lateinit var dialog: Dialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        // Asignar variables
        textView = findViewById(R.id.text_view)
        arrayList = ArrayList();
        arrayList.add("Puebla");
        arrayList.add("CDMX");
        arrayList.add("Monterrey");
        arrayList.add("Nuevo Leon");
        arrayList.add("Oaxaca");
        arrayList.add("Queretaro")
        arrayList.add("Orizaba");
        arrayList.add("Morelos")
        arrayList.add("Tamaulipas");
        arrayList.add("Guerrero")
        arrayList.add("Veracruz");
        arrayList.add("Guadalajara")

        textView.setOnClickListener {
            dialog = Dialog(this@Inicio);
            dialog.setContentView(R.layout.dialog_searchable_spinner);

            // width and height
            dialog.window?.setLayout(650, 800)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dialog.show();


            val editText: EditText = dialog.findViewById(R.id.edit_text);
            val listView: ListView = dialog.findViewById(R.id.list_view);

            // Inicializa array
            val adapter = ArrayAdapter<String>(this@Inicio, android.R.layout.simple_list_item_1, arrayList);

            listView.adapter = adapter;
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

                }

                override fun onTextChanged (charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    adapter.filter.filter(charSequence);

                }

                override fun afterTextChanged(editable: Editable) {

                }
            })

            listView.setOnItemClickListener{ _, _, i, _ ->
            textView.text = adapter.getItem(i)
            dialog.dismiss()
            }
        }
    }
}