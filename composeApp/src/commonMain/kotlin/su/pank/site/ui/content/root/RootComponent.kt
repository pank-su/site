package su.pank.site.ui.content.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import su.pank.site.ui.content.about.AboutComponent
import su.pank.site.ui.content.about.DefaultAboutComponent
import su.pank.site.ui.content.profile.DefaultProfileComponent
import su.pank.site.ui.content.profile.ProfileComponent
import su.pank.site.ui.content.projects.load.DefaultLoadProjectsComponent
import su.pank.site.ui.content.projects.load.LoadProjectsComponent

interface RootComponent {
    val profileComponent: ProfileComponent
    val aboutComponent: AboutComponent
    val loadProjectsComponent: LoadProjectsComponent
}

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    // private val _projects = MutableValue(initialValue = ChildPages<*, ProjectComponent>())


    override val profileComponent: ProfileComponent = DefaultProfileComponent(childContext("profile_info"))


    override val aboutComponent: AboutComponent = DefaultAboutComponent(
        childContext("about"),
        "General",
        "I am a young developer with experience in Kotlin and cross-platform development, as well as UI/UX design. Worked in the Valdai Robots team for 6 months."
    )

    override val loadProjectsComponent: LoadProjectsComponent = DefaultLoadProjectsComponent( childContext("projects"))





    init {
    }
}

