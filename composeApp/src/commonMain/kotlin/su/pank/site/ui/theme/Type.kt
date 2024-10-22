package su.pank.site.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import site.composeapp.generated.resources.Res
import site.composeapp.generated.resources.jetbrains
import site.composeapp.generated.resources.space_grotesk

private val jetbrainsMono
    @Composable
    get() = FontFamily(Font(Res.font.jetbrains))

private val space
    @Composable
    get() = FontFamily(Font(Res.font.space_grotesk))


val AppTypography
    @Composable
    get() = Typography(
        headlineMedium = TextStyle(
            fontFamily = jetbrainsMono,
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic
        ),
        bodyMedium = TextStyle(fontFamily = space, fontSize = 25.sp)
    )
