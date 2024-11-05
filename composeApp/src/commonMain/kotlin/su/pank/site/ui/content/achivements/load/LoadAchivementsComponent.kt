package su.pank.site.ui.content.achivements.load

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.Serializable
import su.pank.site.data.AchivementsRepository
import su.pank.site.ui.content.loading.LoadingComponent
import su.pank.site.ui.content.achivements.DefaultAchivementsComponent
import su.pank.site.ui.content.achivements.AchivementsComponent
import su.pank.site.ui.content.achivements.project.DefaultAchivementComponent
import kotlin.time.Duration.Companion.seconds

interface LoadAchivementsComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Loading(val component: LoadingComponent<*>) : Child
        data class Projects(val component: AchivementsComponent) : Child
    }
}


class DefaultLoadAchivementsComponent(
    componentContext: ComponentContext,
    private val achivementsRepository: AchivementsRepository
) : LoadAchivementsComponent,
    ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()


    override val childStack: Value<ChildStack<*, LoadAchivementsComponent.Child>> =
        childStack(
            navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Loading,
            handleBackButton = false,
            childFactory = ::createChild
        )


    private fun createChild(config: Config, componentContext: ComponentContext): LoadAchivementsComponent.Child {
        return when (config) {
            Config.Loading -> LoadAchivementsComponent.Child.Loading(
                LoadingComponent(
                    componentContext,
                    achivementsRepository.achivements.catch { Result.failure<List<Achivement>>(it) }
                        .map { Result.success(it) },
                    {
                        navigation.replaceCurrent(Config.Success(it))
                    },
                    {

                    })
            )

            is Config.Success -> LoadAchivementsComponent.Child.Projects(
                DefaultAchivementsComponent(
                    componentContext,
                    config.achivements
                )
            )
        }
    }

    @Serializable
    private sealed class Config {
        @Serializable
        data object Loading : Config()

        @Serializable
        data class Success(val achivements: List<Achivement>) : Config()

    }
}

@Serializable
data class Achivement(
    val name: String,
    val description: String,
    val image: String
)

fun Achivement.toAchivementComponent(componentContext: ComponentContext) =
    DefaultAchivementComponent(
        componentContext,
        name,
        description,
        image
    )