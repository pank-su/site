package su.pank.site.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import su.pank.site.ui.content.achivements.load.Achivement

interface AchivementsRepository {
    val achivements: Flow<List<Achivement>>
}


// In future load achivements from another place
class TestAchivementsRepository : AchivementsRepository {
    @OptIn(ExperimentalResourceApi::class)
    private val _achivements = listOf(
        Achivement(
            "Second place in T1 Hackathon",
            "",
            "https://sun9-30.userapi.com/impg/8FBxE76XavcDcqLP-OE76a17qmJDAvhoU9XkKQ/Djylf8sQitE.jpg?size=1280x854&quality=96&sign=e1d5127b52a1eee002c3a28de46de98f&type=album"
        ),
        Achivement(
            "Second place in BRICS Future Skills 2024",
            "",
            "https://sun9-42.userapi.com/impg/08ALXl2z405urIYLIV3myh4YgOZZ1NNRQz4ADg/HjOoPxeYbBI.jpg?size=853x1280&quality=95&sign=66b5254cb39c275cd1a871ded7d2f4d8&type=album"
        ),
        Achivement(
            "Diploma of secondary vocational education in the specialty of programmer",
            "",
            "https://sun9-20.userapi.com/impg/8BW3BLDDHsPGmaogBkCMnfsibaoFtnjr0NwQJw/czYzoaHjh_0.jpg?size=964x1280&quality=96&sign=9bc057c8b8673728238c29306ef45083&type=album"
        ),
        Achivement(
            "5th place in Russia in \"Professionals\"",
            "",
            "https://sun9-6.userapi.com/impg/XVdWaR5YuuF0nAynWRSdHgRgWiW7fIjDkGJH6Q/29MxuAI4_0Q.jpg?size=1815x2029&quality=95&sign=0e51c358d3664a11cce8f56560ff3d80&type=album"
        ),
    )

    override val achivements: Flow<List<Achivement>> = flow {
        emit(_achivements)
    }

}