package br.com.eloyvitorio.androidcoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    //Um callback para simular uma resposta de api
    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1, "It - A coisa"),
                    Filme(2, "O Senhor dos Anéis - A Sociedade do Anel")
                )
            )
        }).start()
    }

    //Ao iniciar um contexto de coroutine, este deve estar dentro de uma função
    //suspend
    suspend fun getFilmesCoroutines(): List<Filme> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(1, "It - A coisa"),
                Filme(2, "O Senhor dos Anéis - A Sociedade do Anel")
            )
        }
    }
}