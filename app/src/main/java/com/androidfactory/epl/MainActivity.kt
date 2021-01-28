package com.androidfactory.epl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), SoccerTileInterface {

    lateinit var soccerTileList: ArrayList<SoccerTile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soccerTileList = getList()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragmentContainerView, ListFragment())
        }
    }

    override fun onLearnMoreButtonClicked(position: Int) {
        val soccerTile = soccerTileList[position]

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            val bundle = Bundle().apply {
                putString("soccerTileId", soccerTile.id)
            }

            setCustomAnimations(
                R.anim.fragment_slide_in_right,
                R.anim.fragment_slide_out_left,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )

            replace(R.id.fragmentContainerView, DetailFragment().apply {
                arguments = bundle
            })
        }
    }

    override fun onFavoriteClicked(position: Int) {
        val soccerTile = soccerTileList[position]
        soccerTile.isFavorite = !soccerTile.isFavorite

        (supportFragmentManager.fragments[0] as? ListFragment)?.onFavoriteClicked(position)

        SharedPrefUtil.setSoccerTileFavorite(soccerTile.id, soccerTile.isFavorite)
    }

    private fun getList(): ArrayList<SoccerTile> {
        return ArrayList<SoccerTile>().apply {
            add(
                SoccerTile(
                    id = "manchester_united",
                    title = "Manchester United",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.manu_header,
                    headerImageUrl = "https://pbs.twimg.com/media/CrNZMBcWEAILToa?format=jpg&name=4096x4096",
                    teamUrl = "https://www.manutd.com/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("manchester_united"),
                    winPercentage = "66%"
                )
            )
            add(
                SoccerTile(
                    id = "manchester_city",
                    title = "Manchester City",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.mancity_header,
                    headerImageUrl = "https://pbs.twimg.com/media/CrrrsIlXgAALMsw?format=jpg&name=4096x4096",
                    teamUrl = "https://www.mancity.com/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("manchester_city")
                )
            )
            add(
                SoccerTile(
                    id = "arsenal",
                    title = "Arsenal",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.arsenal_header,
                    headerImageUrl = "https://pbs.twimg.com/media/CrNbDCMXYAEquGu?format=jpg&name=4096x4096",
                    teamUrl = "https://www.arsenal.com/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("arsenal")
                )
            )
            add(
                SoccerTile(
                    id = "tottenham",
                    title = "Tottenham Spurs",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.tottenham_header,
                    headerImageUrl = "https://pbs.twimg.com/media/CsEWC3UXgAA3o-u.jpg",
                    teamUrl = "https://www.tottenhamhotspur.com/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("tottenham")
                )
            )
            add(
                SoccerTile(
                    id = "liverpool",
                    title = "Liverpool",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.liverpool_header,
                    headerImageUrl = "https://pbs.twimg.com/media/CrVea3NVMAAEhKn?format=jpg&name=4096x4096",
                    teamUrl = "https://www.liverpool.com/",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("liverpool")
                )
            )
            add(
                SoccerTile(
                    id = "chelsea",
                    title = "Chelsea",
                    description = "Description of the club",
                    descriptionLong = "A longer description of the club that wouldn't fit on a single line",
                    buttonText = "Learn More",
                    headerImageResId = R.drawable.chelsea_header,
                    headerImageUrl = "https://pbs.twimg.com/media/CrNZBNPW8AAub_1?format=jpg&name=4096x4096",
                    teamUrl = "https://www.chelseafc.com/en",
                    isFavorite = SharedPrefUtil.getSoccerTileFavorite("chelsea")
                )
            )
        }
    }
}