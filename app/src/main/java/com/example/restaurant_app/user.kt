package com.example.restaurant_app

class User{
    var id : Int=0
    var name : String = ""
    var age : Int = 0
    var addr : String=""
    var email: String=""
    constructor(name:String,age:Int,addr:String,email:String){
        this.name=name
        this.age=age
        this.addr=addr
        this.email=email

    }
    constructor(){

    }
}