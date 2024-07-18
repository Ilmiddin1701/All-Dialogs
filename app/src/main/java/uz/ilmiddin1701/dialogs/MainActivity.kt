package uz.ilmiddin1701.dialogs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import uz.ilmiddin1701.dialogs.databinding.ActivityMainBinding
import uz.ilmiddin1701.dialogs.databinding.CustomDialogItemBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

//        val snackBar = Snackbar.make(it, "Salom snackbar", Snackbar.LENGTH_LONG)
//        snackBar.setAction("Bekor qilish") {
//            Toast.makeText(this@MainActivity, "Bekor qilindi", Toast.LENGTH_SHORT).show()
//        }
//        snackBar.show()

        binding.apply {
            alertDialog.setOnClickListener {
                val alertDialog = AlertDialog.Builder(this@MainActivity).create()
                alertDialog.setTitle("Salom")
                alertDialog.setMessage("Alert Dialog")
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES") { dialog, _ ->
                    Toast.makeText(this@MainActivity, "AlertDialog👍", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO") { dialog, _ ->
                    Toast.makeText(this@MainActivity, "AlertDialog👎", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "CANCEL") { dialog, _ ->
                    Toast.makeText(this@MainActivity, "AlertDialog❌", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                alertDialog.show()
            }

            customDialog.setOnClickListener {
                val customDialog = AlertDialog.Builder(this@MainActivity).create()
                val dialogView = CustomDialogItemBinding.inflate(layoutInflater)
                dialogView.apply {
                    btnSave.setOnClickListener {
                        if (edtEmailDialog.text.isNotBlank() && edtPasswordDialog.text.isNotBlank()) {
                            Toast.makeText(this@MainActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                            customDialog.dismiss()
                        } else {
                            Toast.makeText(this@MainActivity, "Ma'lumotlar to'liq emas", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                customDialog.setView(dialogView.root)
                customDialog.show()
            }
        }
    }
}