package com.paraskcd.quiztrivia.repository

import android.util.Log
import com.paraskcd.quiztrivia.data.DataOrException
import com.paraskcd.quiztrivia.models.QuestionItem
import com.paraskcd.quiztrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()
    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, java.lang.Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()

            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        } catch (ex: Exception) {
            dataOrException.e = ex
            Log.d("DEBUG: ", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }

        return dataOrException
    }
}