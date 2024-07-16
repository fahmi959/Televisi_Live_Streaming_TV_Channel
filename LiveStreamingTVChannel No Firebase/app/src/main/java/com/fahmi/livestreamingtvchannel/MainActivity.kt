
package com.fahmi.livestreamingtvchannel

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val channels = listOf(
        Channel("KOMPAS TV", "https://manifest.googlevideo.com/api/manifest/hls_variant/expire/1721056258/ei/oueUZpy9JJK9juMP1I29sA8/ip/103.175.229.161/id/DOOrIxw5xOw.1/source/yt_live_broadcast/requiressl/yes/xpc/EgVo2aDSNQ%3D%3D/hfr/1/playlist_duration/30/manifest_duration/30/maxh/4320/maudio/1/siu/1/spc/NO7bASBkqHFN7CBigNm2IVrssju6GsjvTwnBz9TnYDKiedchJpAN1Mpww0YSwXNLsgOZjZxANuiQ/vprv/1/go/1/rqh/5/pacing/0/nvgoi/1/keepalive/yes/dover/11/itag/0/playlist_type/DVR/sparams/expire%2Cei%2Cip%2Cid%2Csource%2Crequiressl%2Cxpc%2Chfr%2Cplaylist_duration%2Cmanifest_duration%2Cmaxh%2Cmaudio%2Csiu%2Cspc%2Cvprv%2Cgo%2Crqh%2Citag%2Cplaylist_type/sig/AJfQdSswRQIgPKsCSstjk-5Pw2vSxxFww0iGlP0qmd9Y-RYsDP1GkJUCIQDiWWZpKcq35MoH2bDuZScBZU7wAUyu0EkWTJlQehkyiw%3D%3D/file/index.m3u8"
        , "https://i.imgur.com/bD6UHeZ.pngg"),
        Channel("CNN Indonesia" , "https://live.cnnindonesia.com/livecnn/smil:cnntv.smil/playlist.m3u8" , "https://i.imgur.com/l0JyOrm.png"),
        Channel("Anime TV", "https://stmv1.srvif.com/animetv/animetv/playlist.m3u8" , "https://i.imgur.com/CFSSTID.png"),


        Channel("Trans TV" , "https://video.detik.com/transtv/smil:transtv.smil/playlist.m3u8" , "https://upload.wikimedia.org/wikipedia/en/thumb/6/62/Trans_TV_2013.svg/512px-Trans_TV_2013.svg.png"),

        Channel("Trans 7" , "https://video.detik.com/trans7/smil:trans7.smil/playlist.m3u8", "https://i.imgur.com/fAbGImS.png"),
       Channel("TVRI", "https://ott-balancer.tvri.go.id/live/eds/Nasional/hls/Nasional.m3u8", "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/TVRILogo2019.svg/512px-TVRILogo2019.svg.png"),
        Channel("TV One" , "https://manifest.googlevideo.com/api/manifest/hls_variant/expire/1721067407/ei/LxOVZufCGvejjuMP9JGK6AI/ip/103.175.229.161/id/yNKvkPJl-tg.3/source/yt_live_broadcast/requiressl/yes/xpc/EgVo2aDSNQ%3D%3D/hfr/1/playlist_duration/30/manifest_duration/30/maxh/4320/maudio/1/siu/1/spc/NO7bAaKAHY49PIfe19dbaMMphKP0K5-2d5EFCtbJvmU5eMoZF8MDpK4OCRSHLTe-QkX9eqsS_00U/vprv/1/go/1/rqh/5/pacing/0/nvgoi/1/keepalive/yes/dover/11/itag/0/playlist_type/DVR/sparams/expire%2Cei%2Cip%2Cid%2Csource%2Crequiressl%2Cxpc%2Chfr%2Cplaylist_duration%2Cmanifest_duration%2Cmaxh%2Cmaudio%2Csiu%2Cspc%2Cvprv%2Cgo%2Crqh%2Citag%2Cplaylist_type/sig/AJfQdSswRAIgGi9Dl67v2Af1xT6K4zM7yZG5QtTfHxQ953Z6sg28Jl8CIHrR-LpOV107rqT4v_y1L1XFo6F8btV6DYj2JFk0Cak1/file/index.m3u8",
        "https://2.bp.blogspot.com/-F5ayPYiHzIs/V9TayDqnIoI/AAAAAAAAAY8/aWw_0sEIvVQGrFP4O9y63DtDL8o9QviRwCLcB/s1600/tv-one.png"),
        Channel("Metro TV", "https://manifest.googlevideo.com/api/manifest/hls_variant/expire/1721058181/ei/Je-UZs-mIKO6z7sPzoOc-A0/ip/103.175.229.161/id/XKueVSGTk2o.1/source/yt_live_broadcast/requiressl/yes/xpc/EgVo2aDSNQ%3D%3D/hfr/1/playlist_duration/30/manifest_duration/30/maxh/4320/maudio/1/siu/1/spc/NO7bATUsam9Et4qCDf6GwzfbggfiFx9tdMg2itNgQPhpT4-nU9TPFP0Qq9NXCB1V1WfiuPm8aQOE/vprv/1/go/1/rqh/5/pacing/0/nvgoi/1/keepalive/yes/dover/11/itag/0/playlist_type/DVR/sparams/expire%2Cei%2Cip%2Cid%2Csource%2Crequiressl%2Cxpc%2Chfr%2Cplaylist_duration%2Cmanifest_duration%2Cmaxh%2Cmaudio%2Csiu%2Cspc%2Cvprv%2Cgo%2Crqh%2Citag%2Cplaylist_type/sig/AJfQdSswRAIgKlT_xTiTl-Q-kObCU-Pc1uWqX95zKfSH8rq2pXK8OoMCIDWG7pg-bIWdRremGREHoDnVcFPUiZNbIyu69bL04oiN/file/index.m3u8"
        , "https://i.imgur.com/QnU70NI.png"),
        Channel("HyperTv" ,"https://stmv5.voxtvhd.com.br/hiperconectados/hiperconectados/playlist.m3u8" , "https://i.imgur.com/CBbbrkI.png"),
        Channel("Disney Channel" ,"https://fl5.moveonjoy.com/DISNEY_CHANNEL/index.m3u8" , "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Disney_Channel_logo_%282014%29.svg/512px-Disney_Channel_logo_%282014%29.svg.png"),

        Channel("Film Kartun Retro", "https://stmv1.srvif.com/retrotv/retrotv/playlist.m3u8" , "https://i.imgur.com/hIlEfhl.png")

        // Tambahkan channel lainnya sesuai kebutuhan
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ChannelAdapter(channels) { channel ->
            startVideoPlayerActivity(channel.videoUrl)
        }



        showToast("Aplikasi Ini Buatan Fahmi")
    }

    private fun showToast(message: String) {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_container))
        val text = layout.findViewById<TextView>(R.id.toast_text)
        text.text = message

        with (Toast(this)) {
            setDuration(Toast.LENGTH_SHORT)
            setView(layout)
            show()
        }

    }

    private fun startVideoPlayerActivity(videoUrl: String) {
        val intent = Intent(this, VideoPlayerActivity::class.java)
        intent.putExtra("videoUrl", videoUrl)
        startActivity(intent)
    }

}
