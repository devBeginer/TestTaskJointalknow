package com.devbeginner.testtaskjointalknow

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.devbeginner.testtaskjointalknow.Utils.stopPlay

class UserAdapter(val onClick: (mPlayer: MediaPlayer) -> Unit) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var values: List<User> = ArrayList()
    lateinit var mPlayer: MediaPlayer

    fun setItemList(newList: List<User>) {
        values = newList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_conteiner_person, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        holder.nameTextView?.text = "${values[position].name}, "
        holder.age?.text = values[position].age.toString()
        holder.photoAdapter?.setItemList(values[position].photos)
        holder.viewPager2?.adapter = holder.photoAdapter

        mPlayer = MediaPlayer.create(context, R.raw.salmonlikethefish_glacier)

        mPlayer.setOnCompletionListener {
            stopPlay(context, mPlayer)
        }

        if (!values[position].isPlayingDescription) {
            holder.playButton?.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        } else {
            holder.playButton?.setImageResource(R.drawable.ic_baseline_stop_24)
        }
        var playState = PlayState.PLAY
        holder.setOnClickPlay {
            if (playState == PlayState.PLAY) {
                playState = PlayState.STOP
                values[position].isPlayingDescription = true
                holder.playButton?.setImageResource(R.drawable.ic_baseline_stop_24)
            } else {
                playState = PlayState.PLAY
                values[position].isPlayingDescription = false
                holder.playButton?.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
            onClick(mPlayer)

        }
    }

    override fun getItemCount(): Int {
        return values.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView? = null
        var age: TextView? = null
        var viewPager2: ViewPager2? = null
        var photoAdapter: PhotoAdapter? = null
        var playButton: ImageButton? = null

        init {
            nameTextView = itemView.findViewById(R.id.tv_name)
            age = itemView.findViewById(R.id.tv_age)
            viewPager2 = itemView.findViewById(R.id.vp_photo)
            photoAdapter = PhotoAdapter()

            playButton = itemView.findViewById(R.id.ibtn_play_description)
        }

        fun setOnClickPlay(onClick: () -> Unit) {
            playButton?.setOnClickListener {
                onClick()
            }
        }
    }
}