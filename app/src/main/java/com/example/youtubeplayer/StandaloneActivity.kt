package com.example.youtubeplayer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.android.youtube.player.YouTubeStandalonePlayer
import com.google.android.youtube.player.internal.v
import kotlinx.android.synthetic.main.activity_standalone.*
import java.lang.IllegalArgumentException

class StandaloneActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

        btnPlayVideo.setOnClickListener(this)
        btnPlaylist.setOnClickListener(this)      // different way just below
//        btnPlayVideo.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//       })                  //try with lambda expression below
//        btnPlayVideo.setOnClickListener(View.OnClickListener { v ->
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        })              // Now another way with assigning to a variable for quicker use with more buttons
//        val listener = View.OnClickListener { v->
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        }
//        btnPlayVideo.setOnClickListener(listener)
//        btnPlaylist.setOnClickListener(listener)   // up to me what to use
    }

    override fun onClick(view: View) {
       val intent = when (view.id){
           R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(
               this, getString((R.string.GOOGLE_API_KEY)), YOUTUBE_VIDEO_ID,0,true,false)
           R.id.btnPlaylist -> YouTubeStandalonePlayer.createPlaylistIntent(
               this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST,0,0,true,false)
           else -> throw IllegalArgumentException("Undefined button clicked")
       }
        startActivity(intent)
    }
}