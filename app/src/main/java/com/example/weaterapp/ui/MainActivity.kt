package com.example.weaterapp.ui

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.weaterapp.R
import com.example.weaterapp.databinding.ActivityMainBinding
import com.example.weaterapp.ui.home.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    private lateinit var locationPermissionLauncher: ActivityResultLauncher<Array<String>>

    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                weatherViewModel.loadWeatherByCurrentLocation()
            }

        locationPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController

        setupNavigateBottomAppbar(navController)
    }

    private fun setupNavigateBottomAppbar(navController: NavController) {
        binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
            return@setOnMenuItemClickListener when (menuItem.itemId) {
                R.id.home_nav -> {
                    navController.navigate(R.id.home_nav)
                    true
                }
                R.id.setting_nav -> {
                    navController.navigate(R.id.setting_nav)
                    true
                }
                else -> false
            }
        }
    }
}