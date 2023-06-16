package com.example.sawithub.data.response

import com.google.gson.annotations.SerializedName

data class PenyakitResponse(
	@field:SerializedName("PenyakitResponse")
	val penyakitResponseItem: List<PenyakitResponseItem>
)

data class Detail(
	@field:SerializedName("penanganan")
	val penanganan: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null
)

data class PenyakitResponseItem(
	@field:SerializedName("nama_penyakit")
	val namaPenyakit: String? = null,

	@field:SerializedName("detail")
	val detail: Detail
)
