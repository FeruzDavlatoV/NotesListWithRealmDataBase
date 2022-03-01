package com.example.realmnoteskotin

import android.app.Application
import com.example.realmnoteskotin.model.Note
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication :Application(){

    companion object {
        val TAG = MyApplication::class.java.simpleName
        var instance: MyApplication? = null
        var notes = ArrayList<Note>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initRealm()
    }

    private fun initRealm() {
Realm.init(this)
        val config =RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
    }


}