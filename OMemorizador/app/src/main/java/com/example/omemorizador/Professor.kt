package com.example.omemorizador

import java.io.Serializable

class Professor : Serializable {
    var id: Int
    var nome: String


    constructor(id: Int, nome: String){
        this.id = id
        this.nome = nome

    }

    constructor(nome: String){
        this.id = -1
        this.nome = nome
    }

    override fun toString(): String {
        return "${id} - ${nome}"
    }

}