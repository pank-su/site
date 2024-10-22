package su.pank.site.ui.content.projects.load

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import su.pank.site.ui.content.loading.LoadingContent
import su.pank.site.ui.content.projects.ProjectsContent

@Composable
fun LoadProjectsContent(loadProjectsComponent: LoadProjectsComponent, modifier: Modifier = Modifier){
    Children(loadProjectsComponent.childStack) {
        when (val child = it.instance) {
            is LoadProjectsComponent.Child.Loading -> LoadingContent(child.component, modifier)
            is LoadProjectsComponent.Child.Projects -> ProjectsContent(child.component, modifier)
        }
    }
}