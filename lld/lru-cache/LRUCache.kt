class LRUCache(private val capacity: Int) {
    private val map = HashMap<Int,Node>()
    private val head = Node(0,0)
    private val tail = Node(0,0)
    init {
        head.next = tail
        tail.prev = head
    }
    class Node(val key:Int, var value:Int) {
        var prev: Node? = null
        var next: Node? = null
    }
    
    private fun remove(node: Node) {
        node.prev!!.next=node.next
        node.next!!.prev = node.prev
    }
    
    private fun insert(node: Node) {
        node.next = head.next
        node.prev=head
        head.next!!.prev=node
        head.next=node
    }
    
    fun get(key : Int):Int {
        val node = map[key] ?: return -1
        remove(node)
        insert(node)
        return node.value
        
    }
    fun put( key:Int,  value:Int){ 
        
        if(map.containsKey(key)) {
            val existing = map[key]!!
            remove(existing)
        }
        
        val newNode = Node(key,value) 
        map[key] = newNode
        insert(newNode)
        if(map.size>capacity) {
            val lru = tail.prev!!
            remove(lru)
            map.remove(lru.key)
        }
    }
    
}

fun main() {
    val lru = LRUCache(2)

    lru.put(1, 1)
    lru.put(2, 2)

    println(lru.get(1)) // 1

    lru.put(3, 3) // evicts key 2

    println(lru.get(2)) // -1

    lru.put(4, 4) // evicts key 1

    println(lru.get(1)) // -1
    println(lru.get(3)) // 3
    println(lru.get(4)) // 4
}
