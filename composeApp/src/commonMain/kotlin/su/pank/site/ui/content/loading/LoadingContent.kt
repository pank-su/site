package su.pank.site.ui.content.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun LoadingContent(loadingComponent: LoadingComponent<*>, modifier: Modifier){
    val state by loadingComponent.loadingProcess.collectAsState(null)
    LaunchedEffect(state){
        println(state)
    }
    Box(modifier) {
        CircularProgressIndicator()
    }
}