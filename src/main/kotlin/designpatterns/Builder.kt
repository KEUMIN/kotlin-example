package org.example.designpatterns

class House private constructor(
    val rooms: Int?,
    val windows: Int?,
    val doors: Int?,
) {
    class Builder {
        private var rooms: Int? = null
        private var windows: Int? = null
        private var doors: Int? = null

        fun setRooms(rooms: Int) = apply { this.rooms = rooms }

        fun setWindows(windows: Int) = apply { this.windows = windows }

        fun setDoors(doors: Int) = apply { this.doors = doors }

        fun build() = House(rooms, windows, doors)
    }
}

data class User(
    val name: String,
    val age: Int,
    val email: String = "", // 기본값 설정 가능
    val address: String = "",
)

fun main() {
    val house: House =
        House
            .Builder()
            .setDoors(2)
            .setRooms(1)
            .build()

    // 사용 예시
    val user =
        User(
            name = "Jon Jones",
            age = 11,
        )
}
