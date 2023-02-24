package com.vxplore.jpcmvvmapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vxplore.jpcmvvmapplication.viewModels.DashboardViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
               StateFlowList2(viewModel =viewModel)

            }
        },

    )

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StateFlowList2(viewModel: DashboardViewModel) {
   // val moviedata = viewModel.dataList2.collectAsState()
    val moviedata = viewModel.movies
    if (viewModel.loader.value) {
        Column( modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(16.dp).background(color = Color.White), verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
            //.shadow(elevation = 10.dp, shape = RoundedCornerShape(8.dp))
            CircularProgressIndicator()
        }
    }
    else{
        LazyColumn {
            items(
                moviedata.value!!.results,
                itemContent = { movies ->
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        ListItem(text = {
                            Text(
                                text = movies.original_title,
                                style = TextStyle(
                                    fontFamily = FontFamily.Serif,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }, secondaryText = {
                            Text(
                                text = "Id: ${movies.id}",
                                style = TextStyle(
                                    fontFamily = FontFamily.Serif,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    color = Color.DarkGray
                                )
                            )

                        })
                    }
                })
        }
    }


}




