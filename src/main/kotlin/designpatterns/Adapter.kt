package org.example.designpatterns

fun main() {
    val ipad = iPad(1080)

    fun iPad.toMp3Player(): Mp3Player {
        val volume = 700
        // 일회용의 익명 클래스를 반환하는 것
        return object : Mp3Player {
            override fun play() {
                // this@toMp3Player --> toMp3Player를 호출한 이전 객체
                val resolution = this@toMp3Player.resolution
                println("Play mp3. Maximum songs are $volume. and we support $resolution p quality video")
            }
        }
    }

    playMp3(ipad.toMp3Player())
}

interface MediaPlayer {
    fun play()
}

interface Mp3Player : MediaPlayer {
    override fun play() {
        println("Play mp3")
    }
}

interface Mp4Player : MediaPlayer {
    override fun play() {
        println("Play mp4")
    }
}

class iPodMini(
    val volume: Int,
) : Mp3Player {
    override fun play() {
        println("Play mp3. Maximum songs are $volume")
    }
}

class iPad(
    val resolution: Int,
) : Mp4Player {
    override fun play() {
        println("Play mp4. we provide $resolution p quality video")
    }
}

fun playMp3(player: Mp3Player) {
    player.play()
}
