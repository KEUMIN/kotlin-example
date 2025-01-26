package org.example.classes

fun main() {
    val david = Member(Role.ADMIN, "David", null)
    println(david.age?.let { Member.isAdultMember(it) })
}

enum class Role {
    USER,
    ADMIN,
    MASTER,
}

class Member(
    val rule: Role,
    val name: String,
    val age: Int?,
) {
    companion object {
        val DEFAULT_RULE = Role.USER

        fun isAdultMember(age: Int): Boolean = age >= 20
    }
}
