package com.vxplore.jpcmvvmapplication.mainController

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.vxplore.jpcmvvmapplication.navigation.MainNavGraph
import com.vxplore.jpcmvvmapplication.ui.theme.JpcMvvmApplicationTheme
import com.vxplore.jpcmvvmapplication.viewModels.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val baseViewModel by viewModels<BaseViewModel>()

        super.onCreate(savedInstanceState)
        setContent {
            JpcMvvmApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = MaterialTheme.colors.background,
                ) { paddingValues ->
                    MainNavGraph(
                        navHostController = rememberNavController(),
                        navigationChannel = baseViewModel.appNavigator.navigationChannel,
                        paddingValues = paddingValues,
                    )
                }
            }
        }
    }
}
