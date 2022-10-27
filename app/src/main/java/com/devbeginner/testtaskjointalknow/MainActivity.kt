package com.devbeginner.testtaskjointalknow

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.devbeginner.testtaskjointalknow.Utils.play
import com.devbeginner.testtaskjointalknow.Utils.stopPlay

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2Adapter = UserAdapter() {

            if (it.isPlaying) stopPlay(this, it) else play(it)


        }

        viewPager2 = findViewById(R.id.vp_persons)
        val users = mutableListOf<User>()
        users.add(
            User(
                "Petr",
                32,
                listOf(
                    "https://www.flickr.com/photos/rusamesame/23977157340/in/photolist-CwMcwu-6J6fFe-GCjWae-FNSa3K-B3LjAJ-DDmwxF-MSAxg1-LHjmS3-KQ1C4K-Ni2jsn-JHptZ9-7CwCuy-ATh2VA-KfBD1t-23TB43s-CCjNp5-KNt4yU-N8imeA-28Hzc5N-CTasD3-FCcHnE-yJf385-E6Sivc-K7nkBQ-PK5iys-TfWv1g-Hx4rux-BdfRuF-CzrqMw-BcnE6A-QoyvU9-RtBmsA-edZvk6-5gjdKW-4ZxdjN-y1NKvp-GHDTeW-xDgA8y-LvEXBo-J2Srp7-UqLBfJ-Pt5Htk-223AYmu-z8E4gv-2brdg7s-KLq3yn-6D8EFF-VTXkF8-GMrSxs-Mtp7Kq",
                    "https://www.flickr.com/photos/rusamesame/23977157340/in/photolist-CwMcwu-6J6fFe-GCjWae-FNSa3K-B3LjAJ-DDmwxF-MSAxg1-LHjmS3-KQ1C4K-Ni2jsn-JHptZ9-7CwCuy-ATh2VA-KfBD1t-23TB43s-CCjNp5-KNt4yU-N8imeA-28Hzc5N-CTasD3-FCcHnE-yJf385-E6Sivc-K7nkBQ-PK5iys-TfWv1g-Hx4rux-BdfRuF-CzrqMw-BcnE6A-QoyvU9-RtBmsA-edZvk6-5gjdKW-4ZxdjN-y1NKvp-GHDTeW-xDgA8y-LvEXBo-J2Srp7-UqLBfJ-Pt5Htk-223AYmu-z8E4gv-2brdg7s-KLq3yn-6D8EFF-VTXkF8-GMrSxs-Mtp7Kq"
                )
            )
        )
        users.add(
            User(
                "Ivan",
                19,
                listOf(
                    "https://www.flickr.com/photos/rusamesame/23977157340/in/photolist-CwMcwu-6J6fFe-GCjWae-FNSa3K-B3LjAJ-DDmwxF-MSAxg1-LHjmS3-KQ1C4K-Ni2jsn-JHptZ9-7CwCuy-ATh2VA-KfBD1t-23TB43s-CCjNp5-KNt4yU-N8imeA-28Hzc5N-CTasD3-FCcHnE-yJf385-E6Sivc-K7nkBQ-PK5iys-TfWv1g-Hx4rux-BdfRuF-CzrqMw-BcnE6A-QoyvU9-RtBmsA-edZvk6-5gjdKW-4ZxdjN-y1NKvp-GHDTeW-xDgA8y-LvEXBo-J2Srp7-UqLBfJ-Pt5Htk-223AYmu-z8E4gv-2brdg7s-KLq3yn-6D8EFF-VTXkF8-GMrSxs-Mtp7Kq",
                    "https://www.flickr.com/photos/rusamesame/23977157340/in/photolist-CwMcwu-6J6fFe-GCjWae-FNSa3K-B3LjAJ-DDmwxF-MSAxg1-LHjmS3-KQ1C4K-Ni2jsn-JHptZ9-7CwCuy-ATh2VA-KfBD1t-23TB43s-CCjNp5-KNt4yU-N8imeA-28Hzc5N-CTasD3-FCcHnE-yJf385-E6Sivc-K7nkBQ-PK5iys-TfWv1g-Hx4rux-BdfRuF-CzrqMw-BcnE6A-QoyvU9-RtBmsA-edZvk6-5gjdKW-4ZxdjN-y1NKvp-GHDTeW-xDgA8y-LvEXBo-J2Srp7-UqLBfJ-Pt5Htk-223AYmu-z8E4gv-2brdg7s-KLq3yn-6D8EFF-VTXkF8-GMrSxs-Mtp7Kq"
                )
            )
        )
        users.add(
            User(
                "Sergey",
                22,
                listOf(
                    "https://www.flickr.com/photos/rusamesame/23977157340/in/photolist-CwMcwu-6J6fFe-GCjWae-FNSa3K-B3LjAJ-DDmwxF-MSAxg1-LHjmS3-KQ1C4K-Ni2jsn-JHptZ9-7CwCuy-ATh2VA-KfBD1t-23TB43s-CCjNp5-KNt4yU-N8imeA-28Hzc5N-CTasD3-FCcHnE-yJf385-E6Sivc-K7nkBQ-PK5iys-TfWv1g-Hx4rux-BdfRuF-CzrqMw-BcnE6A-QoyvU9-RtBmsA-edZvk6-5gjdKW-4ZxdjN-y1NKvp-GHDTeW-xDgA8y-LvEXBo-J2Srp7-UqLBfJ-Pt5Htk-223AYmu-z8E4gv-2brdg7s-KLq3yn-6D8EFF-VTXkF8-GMrSxs-Mtp7Kq",
                    "https://www.flickr.com/photos/rusamesame/23977157340/in/photolist-CwMcwu-6J6fFe-GCjWae-FNSa3K-B3LjAJ-DDmwxF-MSAxg1-LHjmS3-KQ1C4K-Ni2jsn-JHptZ9-7CwCuy-ATh2VA-KfBD1t-23TB43s-CCjNp5-KNt4yU-N8imeA-28Hzc5N-CTasD3-FCcHnE-yJf385-E6Sivc-K7nkBQ-PK5iys-TfWv1g-Hx4rux-BdfRuF-CzrqMw-BcnE6A-QoyvU9-RtBmsA-edZvk6-5gjdKW-4ZxdjN-y1NKvp-GHDTeW-xDgA8y-LvEXBo-J2Srp7-UqLBfJ-Pt5Htk-223AYmu-z8E4gv-2brdg7s-KLq3yn-6D8EFF-VTXkF8-GMrSxs-Mtp7Kq"
                )
            )
        )

        viewPager2Adapter.setItemList(users)



        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_DRAGGING) {
                    if (viewPager2Adapter.mPlayer.isPlaying) {
                        stopPlay(this@MainActivity, viewPager2Adapter.mPlayer)
                    }
                }

            }
        })
        viewPager2.adapter = viewPager2Adapter
    }


}