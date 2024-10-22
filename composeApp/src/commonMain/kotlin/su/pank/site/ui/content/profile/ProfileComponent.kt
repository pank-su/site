package su.pank.site.ui.content.profile

import com.arkivanov.decompose.ComponentContext
import org.jetbrains.compose.resources.DrawableResource
import site.composeapp.generated.resources.Res
import site.composeapp.generated.resources.avatar

interface ProfileComponent {
    val name: String
    val description: String
    val avatar: DrawableResource
}

class DefaultProfileComponent(componentContext: ComponentContext) : ProfileComponent,
    ComponentContext by componentContext {
    override val name: String = "Pankov Vasya"
    override val description: String = "Cross-Platform Development, UI/UX Design"
    override val avatar: DrawableResource = Res.drawable.avatar
}