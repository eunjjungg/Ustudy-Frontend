package com.itstime.haejo.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.itstime.haejo.api.APIS
import com.itstime.haejo.api.PostListDTO
import com.itstime.haejo.databinding.ActivityMypageCommentBinding
import com.itstime.haejo.util.AdapterRecyclerPostList
import com.itstime.haejo.util.PostData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageCommentActivity : AppCompatActivity() {

    //data binding
    lateinit var binding : ActivityMypageCommentBinding

    //recyclerView Post List 용
    private val postDataList: MutableList<PostListDTO> = mutableListOf()
    lateinit var postAdapter: AdapterRecyclerPostList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMypageCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        setRecyclerPostList()
        getDataFromDB()
    }

    //db에서 받아오는 값으로 data 수정 필요
    private fun setRecyclerPostList() {
        postAdapter = AdapterRecyclerPostList()
        postDataList.apply {
            //dummy data
            add(PostListDTO(title = " "))
        }

        postAdapter.listData = postDataList
        binding.recycPost.adapter = postAdapter
        binding.recycPost.layoutManager = LinearLayoutManager(this)
    }

    private fun getDataFromDB() {
        var studyId = 2
        val api = APIS.create()
        api.getPostList(studyId).enqueue(object : Callback<PostListDTO> {
            override fun onResponse(call: Call<PostListDTO>, response: Response<PostListDTO>) {
                val tmpDTO = response.body()
                postDataList.clear()
                postDataList.add(tmpDTO!!)
                postAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<PostListDTO>, t: Throwable) {
                Toast.makeText(binding.root.context, "다시 시도해주세요", Toast.LENGTH_SHORT).show()
            }

        })
    }
}