package chapter1.part5.socialnetwork

import chapter1.part5.unionfind.UnionFind
import edu.princeton.cs.algs4.Stopwatch

class SocialNetwork(private val membersAmount: Int) {
    private val members = UnionFind(membersAmount)
    val timestamps = ArrayList<Double>()

    fun makeFriendships() {
        val timer = Stopwatch()

        for (i in 0 until membersAmount / 4) {
            /* Block #1 */
            members.union(i, i + 1) // from one side

            val b1fromOtherSide = membersAmount / 2 - 1 - i
            members.union(b1fromOtherSide, b1fromOtherSide - 1)

            /* Block #2 */
            members.union(membersAmount / 2 + i, membersAmount / 2 + i + 1)
            val b2fromOtherSide = membersAmount / 1 - 1 - i
            members.union(b2fromOtherSide, b2fromOtherSide - 1)

            members.union(b1fromOtherSide, b2fromOtherSide)

            timestamps.add(timer.elapsedTime())
        }
    }

    fun allAreFriends(): Boolean {
        return members.connected(0, membersAmount - 1)
    }
}

fun main(args: Array<String>) {
    val sn = SocialNetwork(100000000)
    sn.makeFriendships()
    println(sn.timestamps.last())
    println("All are friends: ${sn.allAreFriends()}")
}