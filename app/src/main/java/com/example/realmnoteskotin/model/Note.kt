package com.example.realmnoteskotin.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class Note: RealmObject {
    @PrimaryKey
    var time:String = ""
    var message:String = ""
    constructor()
    constructor(time:String, message:String) {
        this.time = time
        this.message = message
    }
}

