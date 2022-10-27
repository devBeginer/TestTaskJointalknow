package com.devbeginner.testtaskjointalknow

import android.content.Context
import android.media.MediaPlayer
import android.widget.Toast

object Utils {

    fun stopPlay(context: Context, player: MediaPlayer) {
        player.stop();
        try {
            player.prepare()
            player.seekTo(0)
        } catch (t: Throwable) {
            Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
        }
    }

    fun play(player: MediaPlayer) {
        player.start()
    }
}