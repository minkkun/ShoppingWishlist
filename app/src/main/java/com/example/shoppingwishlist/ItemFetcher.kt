package com.example.shoppingwishlist

class ItemFetcher {
//    companion object {
        val names = ArrayList<String>()
        val prices = ArrayList<String>()
        val urls = ArrayList<String>()

        fun addItem(name: String, price: String, url: String) {
            names.add(name)
            prices.add(price)
            urls.add(url)
        }

        fun getItems(): MutableList<Item> {
            var items : MutableList<Item> = ArrayList()
            var i = 0
            while (i < names.size) {
                val item = Item(names[i], prices[i], urls[i])
                items.add(item)
                i++
            }
           // println(names.size)
            return items
        }
    }