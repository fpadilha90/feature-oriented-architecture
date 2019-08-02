package com.example.app.ui

import org.junit.Before

import org.junit.Test

class AvatarRecyclerAdapterTest {

    private lateinit var items: List<Avatar>
    private lateinit var adapter: AvatarRecyclerAdapter

    @Before
    fun setUp() {
        items = listOf(Avatar("name", "imageUrl"), Avatar("name", "imageUrl"), Avatar("name", "imageUrl"),Avatar("name", "imageUrl"))
        adapter = AvatarRecyclerAdapter(items) {Toast.makeText(this, "", Toast.LENGTH_SHORT).show()}
    }

    @Test fun itemCountShouldReturnCorrectlyValue(){
        assertEquals(items.size, adapter.itemCount)
    }
}