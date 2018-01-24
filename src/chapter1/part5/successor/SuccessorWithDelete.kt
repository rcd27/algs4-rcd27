package chapter1.part5.successor

class SuccessorWithDelete(integersAmount: Int) {

    var integers = IntArray(integersAmount)

    /**
     *  Удаляет элемент из сета интеджеров, переопределяет сет на такой же за исключением удалённого элемента
     */
    fun delete(p: Int) {

    }

    /**
     *  Выдаёт саксесора для элемента p. Саксесоры хранятся в сете в качестве значений (или нет)
     */
    fun successor(p: Int) {

    }

    /**
     *  Вовзращает текущий сет
     */
    fun getSet(): IntArray {
        return integers
    }
}