package com.fahmi.livestreamingtvchannel


import android.app.ProgressDialog
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var pd: ProgressDialog
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        pd = ProgressDialog(this)
        pd.setMessage("Buffering...")
        pd.setCancelable(true)

        videoView = findViewById(R.id.videoView)

        val videoUrl = intent.getStringExtra("videoUrl")
        videoUrl?.let {
            playVideo(it)
        }


    }

    private fun playVideo(videoUrl: String) {
        try {
            window.setFormat(PixelFormat.TRANSLUCENT)
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)

            val uri = Uri.parse(videoUrl)
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(uri)
            videoView.requestFocus()
            videoView.setOnPreparedListener { mp ->
                pd.dismiss()
                videoView.start()
            }
        } catch (e: Exception) {
            pd.dismiss()
            Toast.makeText(this, "Error playing video: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}
