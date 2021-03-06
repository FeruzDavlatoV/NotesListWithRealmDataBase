package com.example.realmnoteskotin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realmnoteskotin.R
import com.example.realmnoteskotin.adapter.NoteAdapter
import com.example.realmnoteskotin.helper.NoteDialog
import com.example.realmnoteskotin.manager.RealmManager
import com.example.realmnoteskotin.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton



class MainActivity : AppCompatActivity() {

    companion object {
        var noteList: ArrayList<Note> = ArrayList()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        var add_fab = findViewById<FloatingActionButton>(R.id.add_fab)
        add_fab.setOnClickListener{
            val dialog = NoteDialog(this)
            dialog.show()
            adapter.notifyDataSetChanged()
        }
        recyclerView = findViewById(R.id.recyclerView)
        getAllNotes()
        refreshAdapter(noteList)
    }

    private fun refreshAdapter(note:ArrayList<Note>) {
        adapter = NoteAdapter(this,note)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

    }

    fun getAllNotes() {
         noteList.addAll(RealmManager.instance!!.loadNotes())
    }


}