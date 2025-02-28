package it.intesys.ybddtests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import it.intesys.ybddtests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BaseActivity {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)

        val topLevelDestinations = setOf(
            R.id.DemoFragment,
            R.id.InfoFragment,
            R.id.CreditsFragment
        )
        // Add a DestinationChangedListener to toggle BottomNavigationView visibility
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in topLevelDestinations) {
                binding.bottomNavigation.visibility = View.VISIBLE
            } else {
                binding.bottomNavigation.visibility = View.GONE
            }
        }
        appBarConfiguration = AppBarConfiguration(topLevelDestinations)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.action_to_HomeFragment)
                    true
                }
                R.id.info -> {
                    navController.navigate(R.id.action_to_InfoFragment)
                    true
                }
                R.id.credits -> {
                    navController.navigate(R.id.action_to_CreditsFragment)
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings1 -> {
                Snackbar.make(binding.root,
                    R.string.item1, Snackbar.LENGTH_LONG).show()
                true
            }
            R.id.action_settings2 -> {
                Snackbar.make(binding.root,
                    R.string.item2, Snackbar.LENGTH_LONG).show()
                true
            }
            R.id.action_settings3 -> {
                Snackbar.make(binding.root,
                    R.string.item3, Snackbar.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun progress(show: Boolean) {
        binding.loader.visibility = if (show) View.VISIBLE else View.GONE
    }
}