package su.pank.site

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import kotlinx.browser.document
import su.pank.site.ui.content.root.DefaultRootComponent
import su.pank.site.ui.content.root.RootContent


@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()

    val root =
        DefaultRootComponent(
            componentContext = DefaultComponentContext(lifecycle = lifecycle)
        )
    ComposeViewport(document.body!!) {
        RootContent(root)
    }
}


