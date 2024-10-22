package su.pank.site.ui.content.projects

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import su.pank.site.ui.content.projects.load.Project
import su.pank.site.ui.content.projects.project.DefaultProjectComponent
import su.pank.site.ui.content.projects.project.ProjectComponent

interface ProjectsComponent {
    val projects: Value<ChildPages<*, ProjectComponent>>
}

class DefaultProjectsComponent(componentContext: ComponentContext, projects: List<Project>) : ProjectsComponent,
    ComponentContext by componentContext {
    private val navigation = PagesNavigation<Config>()

    override val projects: Value<ChildPages<*, ProjectComponent>> =
        childPages(navigation, serializer = Config.serializer(), initialPages = {
            Pages(items = projects.map { Config(it.name, it.programmingLanguage, it.image) }, 0)
        }) { config, childComponentContext ->
            DefaultProjectComponent(childComponentContext, config.name, config.programmingLanguage, config.image)
        }


    @Serializable
    private data class Config(
        val name: String,
        val programmingLanguage: String,
        val image: String
    )

}
