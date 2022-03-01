package com.example.realmnoteskotin.manager


import com.example.realmnoteskotin.model.Note
import io.realm.Realm
import io.realm.RealmResults

class RealmManager {
    companion object {
        private var realmManager: RealmManager? = null
        private lateinit var realm: Realm
        var instance: RealmManager? = null
        get() {
            if (realmManager == null){
                realmManager = RealmManager()
            }
            return realmManager
        }
    }
    init {
        realm = Realm.getDefaultInstance()
    }
    fun savePosition(note: Note) {
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(note)
        realm.commitTransaction()
    }
    fun loadNotes():ArrayList<Note> {
        val notes:ArrayList<Note> = ArrayList()
        val results: RealmResults<Note> = realm.where(Note::class.java).findAll()
        for (result in results){
            notes.add(result)
        }
        return notes
    }
}