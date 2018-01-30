package com.khalilayache.newspapper.network.api

class NewsCategoryApi {

  fun getNewsCategories(): ArrayList<String> {
    return arrayListOf(
        "Economia",
        "Educação",
        "Empreendedorismo",
        "Entretenimento",
        "Esporte",
        "Futebol",
        "Inovação",
        "Internacional",
        "Política",
        "Tecnologia",
        "Viagem"
    )
  }

}
