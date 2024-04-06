package com.example.wikicroissants
import android.content.Intent
import android.media.tv.TvContract.Channels.Logo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.add
import androidx.fragment.app.commit
class Principal : AppCompatActivity(){
    lateinit var tbPrincipal : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        //Toolbar
        val tbPrincipal: Toolbar = findViewById(R.id.tbPrincipal)
        setSupportActionBar(tbPrincipal)
        tbPrincipal.setLogo(R.drawable.croissants)
        //Toolbar
        supportFragmentManager.commit{
            setReorderingAllowed(true)
//            add<Inicio>(R.id.fragmentContainer)
            add<Estanteria>(R.id.fragmentContainer)
        }
    }//OnCreate
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_principal, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.itemEstante -> {
                Toast.makeText(this,"Estantes", Toast.LENGTH_SHORT).show()
                val fragemntoEsatntes = Estanteria()
                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainer, fragemntoEsatntes)
                transaction.addToBackStack(null)
                transaction.commit()
                true
            }
            R.id.itemLibros -> {
                Toast.makeText(this,"Libros", Toast.LENGTH_SHORT).show()
                val fragemntoLibros = Libros()
                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainer, fragemntoLibros)
                transaction.addToBackStack(null)
                transaction.commit()
                true
            }
            R.id.itemSalir -> {
                Toast.makeText(this,"Sesión cerrada correctamente", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }//onOptionsItemSelected
}//Class Principal