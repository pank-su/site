package su.pank.site

import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import su.pank.site.ui.content.root.DefaultRootComponent
import su.pank.site.ui.content.root.RootContent
import javax.swing.SwingUtilities


fun main(){
    val lifecycle = LifecycleRegistry()

    val root = runOnUiThread { DefaultRootComponent(componentContext = DefaultComponentContext(lifecycle)) }

    application {
        val windowState = rememberWindowState()
        Window(::exitApplication, windowState) {

            LifecycleController(
                lifecycleRegistry = lifecycle,
                windowState = windowState,
                windowInfo = LocalWindowInfo.current,
            )
            RootContent(root)
        }
    }
}

internal fun <T> runOnUiThread(block: () -> T): T {
    if (SwingUtilities.isEventDispatchThread()) {
        return block()
    }

    var error: Throwable? = null
    var result: T? = null

    SwingUtilities.invokeAndWait {
        try {
            result = block()
        } catch (e: Throwable) {
            error = e
        }
    }

    error?.also { throw it }

    @Suppress("UNCHECKED_CAST")
    return result as T
}

