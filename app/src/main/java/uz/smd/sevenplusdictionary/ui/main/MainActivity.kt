package uz.smd.sevenplusdictionary.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_content.*
import kotlinx.android.synthetic.main.layout_header.*
import uz.smd.sevenplusdictionary.R
import uz.smd.sevenplusdictionary.navigation.AppScreen
import uz.smd.sevenplusdictionary.ui.base.activity.MvpAppCompatActivityX

class MainActivity : MvpAppCompatActivityX(), MainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    // Initialise the DrawerLayout, NavigationView and ToggleBar
//    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setNavigator(MainNavigator(this))

        loadNavBar()
        clickListener()
    }

    fun loadNavBar(){
        navigationView.getHeaderView(0).apply {
           findViewById<LinearLayout>(R.id.menuDictionary).setOnClickListener {
            presenter.navigate(AppScreen.TasksScreen())
           drawerLayout.closeDrawer(GravityCompat.START)
               toolbar.title="Словарь"
        }
            findViewById<LinearLayout>(R.id.menuFav).setOnClickListener {
            presenter.navigate(AppScreen.FavScreen())
           drawerLayout.closeDrawer(GravityCompat.START)
                toolbar.title="Фаворит"
        }
        }
    }

    // override the onBackPressed() function to close the Drawer when the back button is clicked
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
          drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun clickListener() {
        toolbar.setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }



    }



}