package su.pank.site.ui.content.projects.load

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable
import su.pank.site.ui.content.loading.LoadingComponent
import su.pank.site.ui.content.projects.DefaultProjectsComponent
import su.pank.site.ui.content.projects.ProjectsComponent
import su.pank.site.ui.content.projects.project.DefaultProjectComponent
import kotlin.time.Duration.Companion.seconds

interface LoadProjectsComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Loading(val component: LoadingComponent<*>) : Child
        data class Projects(val component: ProjectsComponent) : Child
    }
}


class DefaultLoadProjectsComponent(componentContext: ComponentContext) : LoadProjectsComponent,
    ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, LoadProjectsComponent.Child>> =
        childStack(
            navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Loading,
            handleBackButton = false,
            childFactory = ::createChild
        )


    private fun createChild(config: Config, componentContext: ComponentContext): LoadProjectsComponent.Child {
        return when (config) {
            Config.Loading -> LoadProjectsComponent.Child.Loading(LoadingComponent(componentContext, flow {
                delay(2.seconds)
                emit(Result.success(listOf(Project("test", "test", "test"))))
            }, {
                navigation.replaceCurrent(Config.Success(it))
            }, {

            }))

            is Config.Success -> LoadProjectsComponent.Child.Projects(
                DefaultProjectsComponent(
                    componentContext,
                    config.projects
                )
            )
        }
    }

    @Serializable
    private sealed class Config {
        @Serializable
        data object Loading : Config()

        @Serializable
        data class Success(val projects: List<Project>) : Config()

    }
}

@Serializable
data class Project(
    val name: String,
    val programmingLanguage: String,
    val image: String
)

fun Project.toProjectComponent(componentContext: ComponentContext) =
    DefaultProjectComponent(componentContext, name, programmingLanguage, image)