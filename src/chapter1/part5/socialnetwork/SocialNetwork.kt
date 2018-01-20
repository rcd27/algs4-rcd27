package chapter1.part5.socialnetwork

import chapter1.part5.unionfind.UnionFind
import edu.princeton.cs.algs4.Stopwatch

class SocialNetwork(private val membersAmount: Int) {
    private val members = UnionFind(membersAmount)
    val timestamps = ArrayList<Double>()

    fun makeFriendships() {
        val timer = Stopwatch()
        for (i in 0 until membersAmount - 1) {
            members.union(i, i + 1) // from one side
            timestamps.add(timer.elapsedTime())
        }
    }
}

fun main(args: Array<String>) {
    val sn = SocialNetwork(100000000)
    sn.makeFriendships()
    println(sn.timestamps.last())
}