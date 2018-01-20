package chapter1.part5.socialnetwork

import chapter1.part5.unionfind.UnionFind
import edu.princeton.cs.algs4.Stopwatch

class SocialNetwork(private val membersAmount: Int) {
    private val members = UnionFind(membersAmount)
    val timestamps = ArrayList<Double>()

    fun makeFriendships() {
        val timer = Stopwatch()
        for (i in 0 until membersAmount / 2) {
            members.union(i, i + 1) // from one side

            val fromOtherSide = membersAmount - 1 - i
            members.union(fromOtherSide, fromOtherSide - 1)

            timestamps.add(timer.elapsedTime())
        }
    }

    fun allAreFriends(): Boolean {
        return members.connected(0, membersAmount - 1)
    }
}

fun main(args: Array<String>) {
    val sn = SocialNetwork(10000000)
    sn.makeFriendships()
    println(sn.timestamps.last())
    println("All are friends: ${sn.allAreFriends()}")
}